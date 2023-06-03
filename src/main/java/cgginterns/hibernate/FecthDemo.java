package cgginterns.hibernate;

import java.io.FileOutputStream;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FecthDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
//		fecthing student data
//		Student s =(Student)session.load(Student.class, 1);
//		Student s3 =(Student)session.load(Student.class, 2);
//		System.out.println(s);
//		System.out.println(s3);
		
//		fecthing address data
		
		Address s1=(Address)session.get(Address.class, 1);
//		Address s2=(Address)session.get(Address.class, 1);
		
//		System.out.println(s1.getStreet()+" : "+ s1.getCity());
//		System.out.println(s2.getStreet()+" : "+ s2.getCity());
		
		//fetching image
		byte[] image = s1.getImage();
		try(FileOutputStream fos = new FileOutputStream("src/main/java/fetchedimage.jpg")){
			fos.write(image);
			fos.flush();
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		factory.close();
	}

}
