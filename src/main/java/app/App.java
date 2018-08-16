package app;

import app.dto.CountryDTO;
import app.exceptions.MyException;
import app.repository.generic.DbConnection;
import app.service.MyService;
import app.service.MyServiceImpl;

import java.math.BigDecimal;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        try {
            MyService service = new MyServiceImpl();

            /*service.addCompany(CompanyDTO
                    .builder()
                    .name("BBB")
                    .budget(new BigDecimal("100"))
                    .countryDTO(CountryDTO.builder().id(21L).build())
                    .build());*/

            Map<CountryDTO, BigDecimal> avgs = service.countriesAndCompaniesAvgBudget();
            avgs.forEach((k, v) -> System.out.println(k + " " + v));
        } catch (MyException e) {
            System.err.println(e.getMessage());
        } finally {
            DbConnection.getInstance().close();
        }
    }


}
