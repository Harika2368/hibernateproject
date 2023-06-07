package cgg.hibernate.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session= factory.openSession();
		
		//HQL
		//Syntax
		
		String query = "from Student as s where s.city = :x and s.name= :n";
		Query q = session.createQuery(query);
		q.setParameter("x", "Hyd");
		q.setParameter("n", "ABC");
		
		//single result -(Unique)
		//Multiple result -(list)
//		List<Student> list = q.list();
//		
//		for(Student student : list) {
//			System.out.println(student.getName()+" : "+student.getCity());
//		}
//		
//		System.out.println("-----------------------------------");
		Transaction tx = session.beginTransaction();
		
		//delete query
		
//		Query q1=session.createQuery("delete from Student s where s.city=:a");
//		q1.setParameter("a", "Hyd");
//		int r= q1.executeUpdate();
//		System.out.println("deleted..");
//		System.out.println(r);
//		
//		//update query
//		Query q2 = session.createQuery("update Student set city = :c where name =:n");
//		q2.setParameter("c", "Sdpt");
//		q2.setParameter("n", "XYZ");
//		int r1=q2.executeUpdate();
//		System.out.println("Updated..");
//		System.out.println(r1);
		
		
		tx.commit();
		//How execute Join Query
		
		Query q3 = session.createQuery("select b.brandId,b.brandname,p.productname from Brand b INNER JOIN  b.products as p");
		List<Object []> list1 = q3.getResultList();
		for (Object[] arr : list1) {
			System.out.println(Arrays.toString(arr));
		}
		
		
		
		
		
		session.close();
		
		factory.close();
		
	}

}
