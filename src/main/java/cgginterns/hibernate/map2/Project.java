package cgginterns.hibernate.map2;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
@Id
private int pro_id;
private String pro_name;
@ManyToMany(mappedBy="projects")
private List<Employee> employee;
public Project() {
	super();
	// TODO Auto-generated constructor stub
}
public Project(int pro_id, String pro_name, List<Employee> employee) {
	super();
	this.pro_id = pro_id;
	this.pro_name = pro_name;
	this.employee = employee;
}
public int getPro_id() {
	return pro_id;
}
public void setPro_id(int pro_id) {
	this.pro_id = pro_id;
}
public String getPro_name() {
	return pro_name;
}
public void setPro_name(String pro_name) {
	this.pro_name = pro_name;
}
public List<Employee> getEmployee() {
	return employee;
}
public void setEmployee(List<Employee> employee) {
	this.employee = employee;
}

}
