package learning.hibernate_mysql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLDemo {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();
		System.out.println("Hibernate HQL Demo started");

		// Query to fetch all Students list using getResultList
		String strQuery = "from Student";
		Query<Student> query = s.createQuery(strQuery);
		List<Student> listStudent = query.getResultList();
		for (Student student : listStudent) {
			System.out.println(student.getFirstName());
			System.out.println(student.getLastName());
			System.out.println(student.getGender());
			System.out.println(student.getDob());
		}
		System.out.println("------------------------------------------------------");

		// Query to fetch multiple Students object using getResultList using where clause
		String strQuery1 = "from Student where lastName = :lastname";
		Query<Student> query1 = s.createQuery(strQuery1);
		query1.setParameter("lastname", "Mankotia");
		List<Student> listStudent1 = query1.getResultList();
		for (Student student : listStudent1) {
			System.out.println(student.getFirstName());
			System.out.println(student.getLastName());
			System.out.println(student.getGender());
			System.out.println(student.getDob());
		}
		System.out.println("------------------------------------------------------");

		// Query to fetch one Student object using getResultList
		String strQuery2 = "from Student where lastName = :lastname";
		Query<Student> query2 = s.createQuery(strQuery2);
		query2.setParameter("lastname", "Tiwari");
		System.out.println("Printing data");
		Student student = query2.getSingleResult();
		System.out.println("" + student.getFirstName());
		System.out.println("" + student.getLastName());
		System.out.println("" + student.getGender());
		System.out.println("" + student.getDob());
		System.out.println("------------------------------------------------------");

		// Delete HQL query demo
		String strQuery3 = "delete from Student where lastName = :lastname";
		Query query3 = s.createQuery(strQuery3);
		query3.setParameter("lastname", "Tiwari");
		Transaction tx = s.beginTransaction();
		int deleteResult = query3.executeUpdate();
		System.out.println(deleteResult + " rows deleted");
		tx.commit();
		System.out.println("------------------------------------------------------");
		
		
		// Update HQL query demo
		String strQuery4 = "update from Student set lastName = :newlastname where firstName = :currentfirstname";
		Query query4 = s.createQuery(strQuery4);
		query4.setParameter("newlastname", "Mankotia");
		query4.setParameter("currentfirstname", "Naman");
		Transaction tx1 = s.beginTransaction();
		int updateResult = query4.executeUpdate();
		System.out.println(updateResult + " rows updated");
		tx.commit();
		System.out.println("------------------------------------------------------");

		s.close();
		factory.close();
	}

}
