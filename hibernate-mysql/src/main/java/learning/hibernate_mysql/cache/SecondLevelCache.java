package learning.hibernate_mysql.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import learning.hibernate_mysql.Student;

public class SecondLevelCache {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session1 = factory.openSession();
		Student student1 = session1.get(Student.class, 1);
		System.out.println("Printing first student " + student1);
		session1.close();
		// session 1 closed, hence first level cache wont work now. So hibernate will use second level cache as we have enabled it on Student object

		Session session2 = factory.openSession();
		Student student2 = session2.get(Student.class, 1);
		System.out.println("Printing second student " + student2);
		session2.close();

	}

}
