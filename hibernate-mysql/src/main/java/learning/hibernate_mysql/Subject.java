package learning.hibernate_mysql;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Subject {
	
	@Column(name = "subject_id")
	private int id;

	@Column(name = "subject_name")
	private String subject;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
