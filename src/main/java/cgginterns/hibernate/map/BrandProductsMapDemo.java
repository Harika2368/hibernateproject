package cgginterns.hibernate.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BrandProductsMapDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Brand b= new Brand();
		b.setBrandId(1);
		b.setBrandname("Tata");
		
		Products p= new Products();
		p.setProductId(11);
		p.setProductname("Tata Salt");
		p.setBrand(b);
		
		Products p1= new Products();
		p1.setProductId(12);
		p1.setProductname("Tata Steels");
		p1.setBrand(b);
		
		Products p2= new Products();
		p2.setProductId(13);
		p2.setProductname("Tata Clothes");
		p2.setBrand(b);
		
		List<Products> l=new ArrayList<>();
		l.add(p);
		l.add(p1);
		l.add(p2);
		
		b.setProducts(l);
		
		Session s=factory.openSession();
		Transaction t=s.beginTransaction();
		s.save(b);
		s.save(p);
		s.save(p1);
		s.save(p2);
		
		//fetching objects...
		Brand b1=(Brand)s.get(Brand.class, 1);
		
		System.out.println(b1.getBrandname());
		for(Products pro:b1.getProducts()) {
			System.out.println(pro.getProductname());
		}
		
		t.commit();
		s.close();
        factory.close();
	}

}
