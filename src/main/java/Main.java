import com.mariia.entities.*;
import com.mariia.entities.hierarchies.Car;
import com.mariia.entities.hierarchies.Opel;
import com.mariia.entities.hierarchies.Toyota;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.*;




public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try(SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Session session2 = sessionFactory.openSession()) {
            session.beginTransaction();

            Car car = new Car("123");
            session.persist(car);
            session.getTransaction().commit();

            final int carId = car.getId();

            new Thread() {
                @Override
                public void run() {
                    session.beginTransaction();
                    Car car = session.load(Car.class, carId);
                    car.setNumber(car.getNumber() + "4");
                    try {Thread.sleep(400);}
                    catch (InterruptedException e) {}
                    session.getTransaction().commit();
                }
            }.start();

            new Thread() {
                @Override
                public void run() {
                    session2.beginTransaction();
                    Car car = session2.load(Car.class, carId);
                    car.setNumber(car.getNumber() + "5");
                    session.getTransaction().commit();
                }
            }.start();
            Thread.sleep(600);


//            Car car = new Car("123");
//            System.out.println(car.getId());
//            session.persist(car);
//            session.flush();
//            System.out.println(car.getId());
//            car.setNumber("321");
//            session.detach(car);
//            car.setNumber("456");
//            session.merge(car);
//            session.update(car);
//            session.remove(car);
//            System.out.println(car.getId());
//            System.out.println(car.getNumber());
//            car.setNumber("789");
//            session.refresh(car);
//            System.out.println(car.getNumber());


//            Car car = new Toyota("123", "220");
//            Car car2 = new Opel("456", 200000);
//            Car car3 = new Car("789");
//            session.persist(car);
//            session.persist(car2);
//            session.persist(car3);

//            HomeAddress homeAddress = new HomeAddress("BigBen str");
//            List<HomeAddress> list = new ArrayList<>();
//            list.add(homeAddress);
//            list.add(new HomeAddress("Lenina"));
//            List<Integer> marks = new ArrayList<>();
//            marks.add(1);
//            marks.add(5);
//            marks.add(3);

//            Person person = new Person("Felix", list, marks, "123");
//            Person load = session.load(Person.class, 1);
//            System.out.println(load.getMarks());
//            List<Person> people = new ArrayList<>();
//            people.add(person);
//            homeAddress.setPerson(people);
//            session.persist(homeAddress);
//            session.persist(person);

//            Person iCode = session.byNaturalId(Person.class).using("iCode", "123").getReference();
//            System.out.println(iCode);

//            Map<String, String> book = new HashMap<>();
//            book.put("isbn", "978-9730228236");
//            book.put("title", "High-Performance Java Persistence");
//            book.put("author", "Vlade Mihalcea");
//
//            session.save("Book", book);

//            session.getTransaction().commit();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
