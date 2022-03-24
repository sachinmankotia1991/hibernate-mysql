package learning.hibernate_mysql.mapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class QuestionApp {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// 1st object
		Question q1 = new Question();
		q1.setName("What is Java");

		Answer a1 = new Answer();
		a1.setId(101);
		a1.setName("Its a programming language");
		q1.setId(1001);
		q1.setAnswer(a1);
		a1.setQuestion(q1);

		Category cat1 = new Category();
		cat1.setId(201);
		cat1.setName("Programming");

		Category cat2 = new Category();
		cat2.setId(202);
		cat2.setName("Education");

		List<Category> listCate1 = new ArrayList<Category>();
		listCate1.add(cat1);
		listCate1.add(cat2);
		q1.setCategory(listCate1);
		cat1.setQuestion(q1);
		cat2.setQuestion(q1);

		session.save(cat1);
		session.save(cat2);
		session.save(q1);
		session.save(a1);

		// 2nd object
		Question q2 = new Question();
		q2.setName("What is Eclipse");
		Answer a2 = new Answer();
		a2.setId(102);
		a2.setName("Its a programming IDE");
		q2.setAnswer(a2);
		a2.setQuestion(q2);
		List<Category> listCate2 = new ArrayList<Category>();
		Category cat3 = new Category();
		cat3.setId(203);
		cat3.setName("Tools");
		Category cat4 = new Category();
		cat4.setId(204);
		cat4.setName("IDE");
		listCate2.add(cat3);
		listCate2.add(cat4);
		q2.setCategory(listCate2);
		cat3.setQuestion(q2);
		cat4.setQuestion(q2);
		// saving all data
		session.save(cat3);
		session.save(cat4);
		session.save(q2);
		session.save(a2);

		tx.commit();

		// get data

		System.out.println("-------------------------------------------");
		Question quesFromDB = session.get(Question.class, 1);
		System.out.println(quesFromDB.getName());
		System.out.println("-------------------------------------------");

		session.close();
		factory.close();

	}

}
