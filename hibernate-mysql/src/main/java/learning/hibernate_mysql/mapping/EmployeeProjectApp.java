package learning.hibernate_mysql.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeProjectApp {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// creating Employee objects
		List<Employee> listEmployee = new ArrayList<Employee>();
		List<Project> listProject = new ArrayList<Project>();
		Employee e1 = new Employee();
		e1.setId(1);
		e1.setName("Sachin");
		Employee e2 = new Employee();
		e2.setId(2);
		e2.setName("Naman");
		listEmployee.add(e1);
		listEmployee.add(e2);

		// creating Project objects
		Project p1 = new Project();
		p1.setId(101);
		p1.setName("TCM");
		Project p2 = new Project();
		p2.setId(102);
		p2.setName("DarwinIndex");
		listProject.add(p1);
		listProject.add(p2);
		e1.setProjects(listProject);

		// saving all data
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);

		tx.commit();
		session.close();
		factory.close();

	}

}

