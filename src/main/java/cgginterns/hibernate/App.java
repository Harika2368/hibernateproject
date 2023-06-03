package cgginterns.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program created...." );
        Configuration cfg = new Configuration();
        cfg.configure();
        //if we put xml file ito another folder , we have to provide entire path in configure
        SessionFactory factory = cfg.buildSessionFactory();
        
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();       
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
        
//        creating student object
        Student student = new Student();
        student.setId(1);
        student.setName("XYZ");
        student.setCity("Sidd");
        
        //creating address object
        Address ad = new Address();
        ad.setStreet("Strret1");
        ad.setCity("Hyd");
        ad.setOpen(true);
        ad.setX(12.56);
        ad.setAddedDate(new Date());
        
        //Read Image file and store in database
        try(FileInputStream fis= new FileInputStream("src/main/java/image.jpg")) {
        	byte []data = new byte[fis.available()];
        	fis.read(data);
        	ad.setImage(data);
        	
        	
        }catch(IOException e) {
        	e.printStackTrace();
        }
        
        Session session=factory.openSession();
        
      //  session.beginTransaction();
        Transaction tx= session.beginTransaction();
        
        session.save(student);
        session.save(ad);
        
       // session.getTransaction().commit();
        tx.commit();
        session.close();
        factory.close();
        System.out.println("Done.......");
        
    }
}
