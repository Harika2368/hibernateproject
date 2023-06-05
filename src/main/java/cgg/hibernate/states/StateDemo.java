package cgg.hibernate.states;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cgginterns.hibernate.Student;

public class StateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
//		//Create student object
//		Student student=new Student();
//		student.setId(1414);
//		student.setName("PQR");
//		student.setCity("Secd");
//		student.setCerti(new Certifcate("Android","2 Months"));
//		
//		//student : transient
//		
//		Session session = factory.openSession();
//        Transaction tx= session.beginTransaction();
//    
//		
////		session.save(student);
//		//student : Persistent :session,databse
//		
////		student.setName("UVW");
//		
//		Student std = session.get(Student.class, 1414);
//		
//		session.delete(std);
//		
//		//student : Removed state :
//		
//		
//		tx.commit();
//		
//		session.close();
//
//		student.setName("Def");
//		System.out.println(student.getName());
//		System.out.println(std.getName()+" : "+std.getCity());
//		
//		//Student : Detached :session and database no langer sync with eachother
//		
//		
//		Session s=factory.openSession();
//		Transaction tx1=s.beginTransaction();
//		s.update(student);
//		student.setCity("Hyd");
//		tx1.commit();
//		Student s2=s.get(Student.class, 1414);
//		System.out.println(s2.getName()+": "+s2.getCity());
//		s.close();
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		
		Student st= s.get(Student.class,1414);
		
		//detached
//		s.evict(st);
//		st.setName("zzz");
//		
//		s.update(st);
		
		//remove state
		s.delete(st);
		s.update(st);
		
		tx.commit();
		s.close();
		factory.close();
	}

}
