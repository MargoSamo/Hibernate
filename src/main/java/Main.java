import com.mariia.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try(SessionFactory sessionFactory = new MetadataSources( registry ).addAnnotatedClass(Student.class).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(new Student("Max34"));
            session.getTransaction().commit();
        }
        /*
        Create table STUDENT ;
        CREATE TABLE Student
        ( id int auto_increment primary key,
        name varchar(255) not null
        );

        insert into student (name) values "Max";
         */
    }
}
