package app.repository.interfaces;

import app.model.Country;
import app.repository.generic.CrudRepository;

import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country> {
    Optional<Country> findByName(String name);
}
