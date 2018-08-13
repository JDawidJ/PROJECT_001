package app.service;

import app.dto.CompanyDTO;
import app.dto.CountryDTO;
import app.dto.PlayerDTO;
import app.dto.TeamDTO;
import app.dto.mappers.ModelMapper;
import app.exceptions.MyException;
import app.model.Company;
import app.model.Country;
import app.model.Player;
import app.model.Team;
import app.repository.implementations.CompanyRepositoryImpl;
import app.repository.implementations.CountryRepositoryImpl;
import app.repository.implementations.PlayerRepositoryImpl;
import app.repository.implementations.TeamRepositoryImpl;
import app.repository.interfaces.CompanyRepository;
import app.repository.interfaces.CountryRepository;
import app.repository.interfaces.PlayerRepository;
import app.repository.interfaces.TeamRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class MyServiceImpl implements MyService {

    private CompanyRepository companyRepository = new CompanyRepositoryImpl();
    private CountryRepository countryRepository = new CountryRepositoryImpl();
    private ModelMapper modelMapper = new ModelMapper();
    private TeamRepository teamRepository = new TeamRepositoryImpl();
    private PlayerRepository playerRepository=new PlayerRepositoryImpl();


    @Override
    public void addCompany(CompanyDTO companyDTO) {
        try {
            // 1. kiedy nie ma country w company to wyjatek
            if (companyDTO.getCountryDTO() == null) {
                throw new IllegalArgumentException("NO COUNTRY FOR COMPANY");
            }

            Country country = null;
            if (companyDTO.getCountryDTO().getId() == null) {
                if (companyDTO.getCountryDTO().getName() == null) {
                    throw new IllegalArgumentException("COUNTRY WITHOUT NEITHER ID NOR NAME");
                } else {
                    country = countryRepository
                            .findByName(companyDTO.getCountryDTO().getName())
                            .orElseThrow(NullPointerException::new);
                }
            } else {
                country = countryRepository
                        .findOneById(companyDTO.getCountryDTO().getId())
                        .orElseThrow(NullPointerException::new);
            }

            Company company = modelMapper.fromCompanyDTOTOCompany(companyDTO);
            company.setCountry(country);
            companyRepository.addOrUpdate(company);
        } catch (Exception e) {
            throw new MyException("SERVICE ADD COMPANY EXCEPTION", LocalDateTime.now());
        }
    }

    @Override
    public Map<CountryDTO, BigDecimal> countriesAndCompaniesAvgBudget() {
        return companyRepository
                .findAll()
                .stream()
                .collect(Collectors.groupingBy(Company::getCountry))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        e -> modelMapper.fromCountryToCountryDTO(e.getKey()),
                        e -> e.getValue().stream().map(Company::getBudget).reduce(BigDecimal.ZERO, (d1, d2) -> d1.add(d2)).divide(new BigDecimal(e.getValue().size()), 2, BigDecimal.ROUND_DOWN))
                );

    }


}
