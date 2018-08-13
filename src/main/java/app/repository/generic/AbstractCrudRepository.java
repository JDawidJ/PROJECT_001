package app.repository.generic;

import app.exceptions.MyException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudRepository<T> implements CrudRepository<T> {

    private SessionFactory sessionFactory = DbConnection.getInstance().getSessionFactory();
    private Class<T> type = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void addOrUpdate(T item) {
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            tx.begin();
            session.merge(item);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new MyException("REPOSITORY ADD OR UPDATE EXCEPTION: " + type.getCanonicalName(), LocalDateTime.now());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void addAll(List<T> items) {
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            tx.begin();
            for (T item : items) {
                session.merge(item);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new MyException("REPOSITORY ADD ALL EXCEPTION: " + type.getCanonicalName(), LocalDateTime.now());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(Long id) {
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            tx.begin();
            T item = session.get(type, id);
            session.delete(item);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new MyException("REPOSITORY DELETE EXCEPTION: " + type.getCanonicalName(), LocalDateTime.now());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<T> findOneById(Long id) {
        Optional<T> op = Optional.empty();
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            tx.begin();
            op = Optional.of(session.get(type, id));
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new MyException("REPOSITORY FIND ONE EXCEPTION: " + type.getCanonicalName(), LocalDateTime.now());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return op;
    }

    @Override
    public List<T> findAll() {
        List<T> items = null;
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            tx.begin();
            // HQL - syntax podobny do sql (ale nie sql) ktory dziala na encjach
            // a nie na tabelach bazy danych
            // kiedy chcesz pobrac wszystkie elementy z tabeli Person to piszesz
            // select * from person a w HQL piszesz
            // select p from Person p
            items = session
                    .createQuery("select i from " + type.getCanonicalName() + " i", type)
                    .getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new MyException("REPOSITORY FIND ALL EXCEPTION: " + type.getCanonicalName(), LocalDateTime.now());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return items;
    }

    @Override
    public void deleteAll() {
        Session session = null;
        Transaction tx = null;

        try {
            session = sessionFactory.openSession();
            tx = session.getTransaction();
            tx.begin();
            List<T> items = session
                    .createQuery("select i from " + type.getCanonicalName() + " i", type)
                    .getResultList();
            for (T item : items) {
                session.delete(item);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new MyException("REPOSITORY DELETE ALL EXCEPTION: " + type.getCanonicalName(), LocalDateTime.now());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
