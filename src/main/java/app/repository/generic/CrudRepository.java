package app.repository.generic;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    void addOrUpdate(T item);
    void addAll(List<T> items);
    void delete(Long id);
    Optional<T> findOneById(Long id);
    List<T> findAll();
    void deleteAll();
}
