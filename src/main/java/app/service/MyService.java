package app.service;

import app.dto.CompanyDTO;
import app.dto.CountryDTO;
import app.dto.PlayerDTO;
import app.dto.TeamDTO;
import app.model.Country;

import java.math.BigDecimal;
import java.util.Map;

public interface MyService {
    void addCompany(CompanyDTO companyDTO);
    Map<CountryDTO, BigDecimal> countriesAndCompaniesAvgBudget();

}
