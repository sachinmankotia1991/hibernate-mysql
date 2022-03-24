package learning.hibernate_mysql.mapping;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "question_details")
public class Question {

	@Id
	@Column(name = "question_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "question_name")
	private String name;

	@OneToOne
	@JoinColumn(name = "answer_fk_id") // use this to give custom name to joining column
	private Answer answer;

	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER , cascade = CascadeType.ALL)  // MappedBy is used when you want to join table with another table, but don't want to have joining column (as a separate column) in target table
	private List<Category> category;							// fetch type EAGER means it will loaded data from child entity as well while fetching parent entity.
																//It won't wait for specific call for child entity
	

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

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Question [id=").append(id).append(", name=").append(name).append(", answer=").append(answer)
				.append(", category=").append(category).append("]");
		return builder.toString();
	}

}
