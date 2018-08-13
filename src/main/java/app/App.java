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

    /*
    1. Dokoncz DTO, popraw encje.
    2. Przemysl sprawe, ze masz kilka plikow csv z danymi dla poszczegolnych
    tabel i robisz osobny service, w ktorym masz metode, ktora najpierw
    usuwa wszystkie dane z tabel, a potem laduje na nowo dane z plikow csv.
    3. Pobierz zestawienie druzyna i gracz, ktory strzelil dla niej najwiecej goli
    4. Pobierz zestawienie druzyna i ilosc czerwonych kartek ktore dostali wszyscy
    zawodnicy tej druzyny
    5. Pobierz zestawienie w ktorym kluczem jest obiekt klasy Manager a
    wartoscia nazwa firmy, z ktora klub trenowany przez managera podpisal
    najwyzszy kontrakt.
     */
}
