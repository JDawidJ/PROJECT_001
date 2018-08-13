package app.repository.implementations;

import app.exceptions.MyException;
import app.model.Country;
import app.repository.generic.AbstractCrudRepository;
import app.repository.interfaces.CountryRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;
import java.util.Optional;

public class CountryRepositoryImpl extends AbstractCrudRepository<Country> implements CountryRepository {
    @Override
    public Optional<Country> findByName(String name) {
        Optional<Country> op = Optional.empty();
        Session session = null;
        Transaction tx = null;

        try {
            session = getSessionFactory().openSession();
            tx = session.getTransaction();
            tx.begin();
            op = Optional.of((Country)session.createQuery("select c from Country c where c.name = :name")
                    .setParameter("name", name)
                    .getSingleResult());
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new MyException("REPOSITORY FIND BY NAME EXCEPTION: COUNTRY" , LocalDateTime.now());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return op;
    }
}
