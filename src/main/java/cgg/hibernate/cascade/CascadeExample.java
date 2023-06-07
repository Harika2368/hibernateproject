package cgg.hibernate.cascade;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cgginterns.hibernate.map.Brand;
import cgginterns.hibernate.map.Products;

public class CascadeExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Brand b1 = new Brand();
		b1.setBrandId(4);
		b1.setBrandname("SUMSUNG");
		
		
		Products p1 = new Products(31,"Phone");
		Products p2 = new Products(32,"Laptop");
		Products p3 = new Products(33,"AC");
		
		ArrayList<Products> list = new ArrayList<Products>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		b1.setProducts(list);
		
		Transaction tx = session.beginTransaction();
		session.save(b1);
//		session.save(p1);
//		session.save(p2);
//		session.save(p3);
		session.delete(b1);
//		
		tx.commit();
		session.close();
		factory.close();
		

	}

}
