package cgginterns.hibernate.map1;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Question1 {
	
	@Id
	@Column(name="question_id")
	private int questionid;
	private String question;
	@OneToMany(mappedBy="question",fetch=FetchType.LAZY)
	private List<Answer1> answers;
	public List<Answer1> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer1> answers) {
		this.answers = answers;
	}
	public int getQuestionid() {
		return questionid;
	}
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public Question1(int questionid, String question) {
		super();
		this.questionid = questionid;
		this.question = question;
	}
	public Question1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
