package learning.hibernate_mysql.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer_details")
public class Answer {

	@Id
	@Column(name = "answer_id")
	private int id;

	@Column(name = "answer_name")
	private String name;

	@OneToOne(mappedBy = "answer") // MappedBy is used when you want to join table with another table, but don't want to have joining column (as a separate column) in target table
	private Question question;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}



}
