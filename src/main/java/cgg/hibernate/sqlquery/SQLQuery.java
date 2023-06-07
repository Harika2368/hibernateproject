package cgg.hibernate.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import cgginterns.hibernate.Student;

public class SQLQuery {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		String q1="select *from student";
	

		NativeQuery nq = session.createNativeQuery(q1);
		nq.setFirstResult(1);
		nq.setMaxResults(7);
		List<Object []> list1 = nq.list();
		
		for(Object[] l : list1) {
//			System.out.println(Arrays.toString(l));
			System.out.println(l[0]+" : "+l[1]);
		}
		
	}

}
