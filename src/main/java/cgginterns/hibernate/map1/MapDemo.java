package cgginterns.hibernate.map1;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
//		Question1 q1 = new Question1();
//		 q1.setQuestionid(1212);
//		 q1.setQuestion("What is java?");
//		 
//		 
//		 //creating answer object
//		 Answer1 answer = new Answer1();
//		 answer.setAnswerId(343);
//		 answer.setAnswer("Java is a Programming Language");
//		 answer.setQuestion(q1);
//		 
//		 Answer1 answer1 = new Answer1();
//		 answer1.setAnswerId(344);
//		 answer1.setAnswer("Java is strongly typed language");
//		 answer1.setQuestion(q1);
//		 
//		 Answer1 answer2=new Answer1();
//		 answer2.setAnswerId(455);
//		 answer2.setAnswer("Java is platform independent");
//		 answer2.setQuestion(q1);
//		 
//		 Question1 q2=new Question1();
//		 q2.setQuestionid(1211);
//		 q2.setQuestion("What is python?");
//		 
//		 Answer1 a1=new Answer1();
//		 a1.setAnswerId(333);
//		 a1.setAnswer("Python is easy");
//		 a1.setQuestion(q2);
//		 
//		 Answer1 a2=new Answer1();
//		 a2.setAnswerId(334);
//		 a2.setAnswer("Python is easy and high level");
//		 a2.setQuestion(q2);
//		 
//		 List<Answer1> l= new ArrayList<>();
//		 l.add(answer1);
//		 l.add(answer);
//		 l.add(answer2);
//		 List<Answer1> l1= new ArrayList<>();
//		 l1.add(a1);
//		 l1.add(a2);
//		 q1.setAnswers(l);
//		 q2.setAnswers(l1);
		 
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//creating question object
		 
		 
		
		 Session s= factory.openSession();
		 
//		 Transaction tx= s.beginTransaction();
//		 
//		 s.save(q1);
//		 s.save(q2);
//		 
//		 s.save(answer);
//		 s.save(answer1);
//		 s.save(answer2);
//		 
//		 s.save(a1);
//		 s.save(a2);
		// tx.commit();
		 
		// fetching objects.......
		 Question1 question = (Question1)s.get(Question1.class,1212);
		 System.out.println(question.getQuestion());
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
		
		 System.out.println(question.getAnswers().size());  
		 s.close();
		 factory.close();

	}

}
