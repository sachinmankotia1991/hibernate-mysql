package learning.hibernate_mysql.mapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "emp_details")
public class Employee {
	@Id
	@Column(name = "emp_id")
	private int id;
	@Column(name = "emp_name")
	private String name;

	@ManyToMany
	@JoinTable(name = "emp_project_mapping") // @JoinTable used to give a custom name to linking table
	private List<Project> projects;

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

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
