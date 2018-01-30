import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by zehoss on 30.01.18.
 */
public class HibernateExampleApplication {

    public static void main(String[] args) {


        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();


            // Storing objects
//            Session session = sessionFactory.openSession();
//            session.beginTransaction();
//            // etities
//            session.save( new Event( "Our very first event!", new Date() ) );
//            session.save( new Event( "A follow up event", new Date() ) );
//            session.getTransaction().commit();
//            session.close();

// Selecting objects
//            session = sessionFactory.openSession();
//            session.beginTransaction();
//            List result = session.createQuery( "from Event" ).list();
//            for ( Event event : (List<Event>) result ) {
//                System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
//            }
//            session.getTransaction().commit();
//            session.close();

        } catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy(registry);
        }

    }

}
