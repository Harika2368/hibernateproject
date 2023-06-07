package cgg.hibernate.pagenation;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import cgginterns.hibernate.Student;

public class HQLPagenation {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		 Session session = factory.openSession();
		 
		 Query q1 = session.createQuery("from Student");
		 
		 //implementation pagination using hibernate
		 
		 q1.setFirstResult(1);//starting index
		 q1.setMaxResults(7);//Page size
		 
		 List<Student> list = q1.list();
		 for(Student s : list) {
			 System.out.println(s.getId()+ "  "+s.getName());
		 }
		 
		 
		 
		 session.close();
		 factory.close();

	}

}
