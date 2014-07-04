package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created with IntelliJ IDEA.
 * User: Ashish Bardhan
 * Date: 6/27/13
 * Time: 1:29 PM
 * To change this template use File | Settings | File Templates.
 */

public class HibernateUtils {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();

        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
