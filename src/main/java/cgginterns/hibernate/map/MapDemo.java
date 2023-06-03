package cgginterns.hibernate.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//creating question object
		 Question q1 = new Question();
		 q1.setQuestionid(1212);
		 q1.setQuestion("What is java?");
		 
		 Question q2 = new Question();
		 q2.setQuestionid(242);
		 q2.setQuestion("What is Collection framework?");
		 
		 
		 //creating answer object
		 Answer answer = new Answer();
		 answer.setAnswerId(343);
		 answer.setAnswer("Java is a Programming Language");
		 
		 Answer answer1 = new Answer();
		 answer1.setAnswerId(344);
		 answer1.setAnswer("API to work with group of Objects");
		 
		 q1.setAnswer(answer);
		 q2.setAnswer(answer1);
		 answer.setQuestion(q1);
		 answer1.setQuestion(q2);
		
		 Session s= factory.openSession();
		 
		 Transaction tx= s.beginTransaction();
		 
		 s.save(q1);
		 s.save(q2);
		 
		 s.save(answer);
		 s.save(answer1);
		 
		 tx.commit();
		 
		 //fetching objects.......
		 Question question = (Question)s.get(Question.class,1212);
		 System.out.println(question.getQuestion());
		 System.out.println(question.getAnswer().getAnswer());
		 
		 //fetching objects...
		 Answer a = (Answer)s.get(Answer.class, 344);
		 System.out.println(a.getAnswer());
		 System.out.println(a.getQuestion().getQuestion());
		 
		  
		 s.close();
		 factory.close();

	}

}
