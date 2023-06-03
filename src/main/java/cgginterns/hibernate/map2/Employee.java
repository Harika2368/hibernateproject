package cgginterns.hibernate.map2;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
@Id

private int empId;
@Column(name="emp_name")
private String empName;
@ManyToMany
@JoinTable(name="emp_proj",joinColumns= {@JoinColumn(name="e_id")},inverseJoinColumns= {@JoinColumn(name="proj_id")})
private List<Project> projects;
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(int empId, String empName, List<Project> projects) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.projects = projects;
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public List<Project> getProjects() {
	return projects;
}
public void setProjects(List<Project> projects) {
	this.projects = projects;
}

}
