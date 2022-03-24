package learning.hibernate_mysql;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentApp {
	@SuppressWarnings({ "deprecation", "resource" })
	public static void main(String[] args) throws IOException {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		System.out.println("Hibernate SAVE method started");
		Student student = new Student();
		student.setFirstName("Naman");
		student.setLastName("Bharadwaj");
		student.setGender('F');
		student.setDob(new Date(92, 05, 05));
		// reading and adding image to student object
		FileInputStream fis = new FileInputStream("C:\\Users\\smankoti\\GIT\\hibernate-mysql\\src\\main\\java\\learning\\hibernate_mysql\\profile-pic.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		student.setImage(data);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		tx.commit();
		
		System.out.println("---------------------------------------------");
		// GET method do eager loading
		System.out.println("Hibernate GET method started");
		Student studentGet = session.get(Student.class, 2);
		System.out.println("Printing GET student : "+studentGet);
		
		
		
		System.out.println("---------------------------------------------");
		// LOAD method do eager loading
		System.out.println("Hibernate LOAD method started");
		Student loadStudent = session.load(Student.class, 1);
		System.out.println("Printing LOAD student : "+loadStudent);
		
		
		session.close();
		factory.close();

	}
}
