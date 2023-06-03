package cgginterns.hibernate.map1;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		Question q1 = new Question();
		 q1.setQuestionid(1212);
		 q1.setQuestion("What is java?");
		 
		 
		 //creating answer object
		 Answer answer = new Answer();
		 answer.setAnswerId(343);
		 answer.setAnswer("Java is a Programming Language");
		 answer.setQuestion(q1);
		 
		 Answer answer1 = new Answer();
		 answer1.setAnswerId(344);
		 answer1.setAnswer("Java is strongly typed language");
		 answer1.setQuestion(q1);
		 
		 Answer answer2=new Answer();
		 answer2.setAnswerId(455);
		 answer2.setAnswer("Java is platform independent");
		 answer2.setQuestion(q1);
		 
		 Question q2=new Question();
		 q2.setQuestionid(1211);
		 q2.setQuestion("What is python?");
		 
		 Answer a1=new Answer();
		 a1.setAnswerId(333);
		 a1.setAnswer("Python is easy");
		 a1.setQuestion(q2);
		 
		 Answer a2=new Answer();
		 a2.setAnswerId(334);
		 a2.setAnswer("Python is easy and high level");
		 a2.setQuestion(q2);
		 
		 List<Answer> l= new ArrayList<>();
		 l.add(answer1);
		 l.add(answer);
		 l.add(answer2);
		 List<Answer> l1= new ArrayList<>();
		 l1.add(a1);
		 l1.add(a2);
		 q1.setAnswers(l);
		 q2.setAnswers(l1);
		 
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//creating question object
		 
		 
		
		 Session s= factory.openSession();
		 
		 Transaction tx= s.beginTransaction();
		 
		 s.save(q1);
		 s.save(q2);
		 
		 s.save(answer);
		 s.save(answer1);
		 s.save(answer2);
		 
		 s.save(a1);
		 s.save(a2);
		 tx.commit();
		 
		// fetching objects.......
//		 Question question = (Question)s.get(Question.class,1212);
//		 System.out.println(question.getQuestion());
//		 List<Answer> answers=question.getAnswers();
//		 for(Answer an:answers) {
//			System.out.println(an.getAnswer());
//		 }
//		 Question question1 = (Question)s.get(Question.class,1211);
//		 System.out.println(question.getQuestion());
//		 List<Answer> answers1=question1.getAnswers();
//		 for(Answer an:answers1) {
//			System.out.println(an.getAnswer());
//		 }
//		 
		  
		 s.close();
		 factory.close();

	}

}
