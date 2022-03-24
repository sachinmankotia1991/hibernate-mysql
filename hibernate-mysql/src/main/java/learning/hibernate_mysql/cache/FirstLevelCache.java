package learning.hibernate_mysql.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate_mysql.Student;

public class FirstLevelCache {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Student student = session.get(Student.class, 1);
		System.out.println("Printing first student " + student);
		System.out.println(session.contains(student)); // It will return true as session is still open and hence object is still present there
		
		Student student1 = session.get(Student.class, 1);
		System.out.println("Printing second student " + student1);  // Hibernate wont call DB again. Instead of that It will use same student object from cache
		
		session.close();
		factory.close();

	}
}
