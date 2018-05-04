package dai.luis.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static final SessionFactory sessionFactory;
    static {
       try {
          // Create the SessionFactory from hibernate.cfg.xml
          sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();        
        /*  new Configuration().configure(new File("hibernate1.cfg.xml")).buildSessionFactory();*/
       }catch (Throwable ex) {
          // Make sure you log the exception, as it might be swallowed
          System.err.println("Falla la creacion  de Initial SessionFactory."+ ex);
          throw new ExceptionInInitializerError(ex);
       }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
