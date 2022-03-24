package learning.hibernate_mysql.xmlconfigdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersonApp {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Person p = new Person();
		p.setId(3);
		p.setName("Sachin");
		p.setAddress("Kangra");
		p.setPhone("+919730118220");
		session.save(p);
		tx.commit();
		session.close();
		factory.close();

	}
}
