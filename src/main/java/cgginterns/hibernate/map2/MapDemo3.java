package cgginterns.hibernate.map2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo3 {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Employee emp=new Employee();
		emp.setEmpId(12);
		emp.setEmpName("Ram");
		
		
		Employee emp1=new Employee();
		emp1.setEmpId(13);
		emp1.setEmpName("Shyam");
		
		
		Employee emp2=new Employee();
		emp2.setEmpId(123);
		emp2.setEmpName("Sundar");
		
		Project p=new Project();
		p.setPro_id(2);
		p.setPro_name("Library Management");
		
		Project p1=new Project();
		p1.setPro_id(3);
		p1.setPro_name("Chatbot");
		
		List<Employee> e=new ArrayList<>();
		e.add(emp);
		e.add(emp1);
		
		List<Employee> e1=new ArrayList<>();
		e1.add(emp1);
		
		List<Project> pr=new ArrayList<>();
		pr.add(p1);
		pr.add(p);
		
		List<Project> pr1=new ArrayList<>();
		pr1.add(p);
		
		emp.setProjects(pr1);
		emp1.setProjects(pr);
		
		p.setEmployee(e);
		p1.setEmployee(e1);
		
		Session session = factory.openSession();
		Transaction txn = session.beginTransaction();
		
		session.save(emp);
		session.save(emp1);
		session.save(p);
		session.save(p1);
		txn.commit();
		Employee employees = (Employee) session.get(Employee.class,13);
		System.out.println(employees.getEmpName());
		List<Project> ps=employees.getProjects();
		for(Project proj:ps) {
			System.out.println(proj.getPro_name());
		}
		Employee employees1 = (Employee) session.get(Employee.class,12);
		System.out.println(employees1.getEmpName());
		List<Project> ps1=employees1.getProjects();
		for(Project proj:ps1) {
			System.out.println(proj.getPro_name());
		}
		System.out.println("------------------------------------------------------------");
		Project proj1 = (Project) session.get(Project.class,2);
		System.out.println(proj1.getPro_name());
		List<Employee> es1=proj1.getEmployee();
		for(Employee es2:es1) {
			System.out.println(es2.getEmpName());
		}
		session.close();
		factory.close();
	}

}
