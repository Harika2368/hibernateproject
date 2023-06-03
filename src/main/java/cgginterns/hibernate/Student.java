package cgginterns.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity    //used to mark any class as Entity
//@Table(name="mystudents") //to change the name of your table(table details)

public class Student {
	
	@Id //refered as primary key..(use to mark colum as id(primary key))
	private int id;
	private String name;
	private String city;
	private Certifcate certi;
	public Student(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Certifcate getCerti() {
		return certi;
	}
	public void setCerti(Certifcate certi) {
		this.certi = certi;
	}
	

}
//---------------Annotations--------------------------------
//@GenerateValue -hiberanate will automatically generate values for that using an internal sequence.There we don't have to set it manually
//@Column = can be used to specify column mappings .For example .to change the column name in the assoiated table in database
//@Transient=This telld hibernate not to save this field.
//@Temporal = over a date field tells hibernate the format in which the date needs to be saved 
//@Lob - tells hibernate that this is a large objecct ,not a simple object
//@OneToOne, @OnetoMany @MAnyToOne @JOinColumn etc...