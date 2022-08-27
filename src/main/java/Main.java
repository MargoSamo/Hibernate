import com.mariia.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try(SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            HomeAddress homeAddress = new HomeAddress("BigBen str");
            List<HomeAddress> list = new ArrayList<>();
            list.add(homeAddress);
            Person person = new Person("Felix", list);
            homeAddress.setPerson(person);
            session.persist(homeAddress);
            session.persist(person);
            session.getTransaction().commit();
        }
        /*
        Create table STUDENT ;
        CREATE TABLE Student
        ( id int auto_increment primary key,
        name varchar(255),
        days int
        );

        insert into student (name) values "Max";
         */
    }
}
