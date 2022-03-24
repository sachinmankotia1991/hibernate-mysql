package learning.hibernate_mysql.mapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project_details")
public class Project {

	@Id
	@Column(name = "project_id")
	private int id;
	@Column(name = "project_name")
	private String name;

	@ManyToMany(mappedBy = "projects") // mappedBy means Project entity wont try to create new linking table. It will use linking table proposed by Employee entity
	private List<Employee> employees;

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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
