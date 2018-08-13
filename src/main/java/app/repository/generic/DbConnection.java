package app.repository.generic;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConnection {

    // SINGLETON
    private static DbConnection ourInstance = new DbConnection();
    public static DbConnection getInstance() {
        return ourInstance;
    }
    private DbConnection() {
    }

    // CONNECTIONS
    private SessionFactory sessionFactory
            = new Configuration().configure().buildSessionFactory();

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }


}
