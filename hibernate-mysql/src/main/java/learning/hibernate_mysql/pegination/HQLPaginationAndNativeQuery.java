package learning.hibernate_mysql.pegination;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import learning.hibernate_mysql.Student;

public class HQLPaginationAndNativeQuery {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Query<Student> query = session.createQuery("from Student");
		// Pagination demo started
		System.out.println("-----------------Pagination demo started-----------------");
		query.setFirstResult(0); // starting element in fetched data (starting from 0)
		query.setMaxResults(4); // Number of records to be fetched

		List<Student> list = query.getResultList();
		for (Student student : list) {
			System.out.println(student.getFirstName());
			System.out.println(student.getLastName());
			System.out.println(student.getGender());
			System.out.println(student.getDob());
		}
		System.out.println("-----------------Pagination demo ended-----------------");

		// Native query demo started
		System.out.println("-----------------Native query demo started-----------------");
		String nativeQuery = "select * from Student_details";
		NativeQuery nq = session.createNativeQuery(nativeQuery);
		List<Object[]> listStudent = nq.getResultList();
		for (Object[] student : listStudent) {
			System.out.println(Arrays.deepToString(student));
			System.out.println(student[2]+ ":" +student[5]);
		}
		System.out.println("-----------------Native query demo ended-----------------");

		session.close();
		factory.close();

	}

}
