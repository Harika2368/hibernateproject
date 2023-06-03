package cgginterns.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EMDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		//Create student object
		Student student=new Student();
		student.setId(101);
		student.setName("ABC");
		student.setCity("Hyd");
		
		Certifcate certi = new Certifcate();
		certi.setCourse("Android");
		certi.setDuration("2 months");
		Student student1=new Student();
		student1.setId(102);
		student1.setName("PQR");
		student1.setCity("Sec");
		
		Certifcate certi1= new Certifcate();
		certi1.setCourse("Hibernate");
		certi1.setDuration("3 months");
		
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(student);
		
		session.getTransaction().commit();
		session.clear();
		factory.close();
	}

}
