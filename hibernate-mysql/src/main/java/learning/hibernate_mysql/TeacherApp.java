package learning.hibernate_mysql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// Example of @Embeddable annotation
public class TeacherApp {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Teacher t1 = new Teacher();
		t1.setName("Sanjay");
		t1.setSalary(20000);
		Subject sub1 = new Subject();
		sub1.setId(101);
		sub1.setSubject("Chemistry");

		t1.setSubject(sub1);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(t1);
		tx.commit();

		session.close();
		factory.close();

	}

}
