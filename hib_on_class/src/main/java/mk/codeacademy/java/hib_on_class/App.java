package mk.codeacademy.java.hib_on_class;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Hello Hibernate!");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		Address a1 = new Address();
		

		Student s1 = new Student();
		s1.setAddress(a1);
		s1.setName("Angjel Gjorgjiev");
		session.save(s1);

		t.commit();

		System.out.println("i am done :) ");

	}

}