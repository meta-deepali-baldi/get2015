package SurveyManagement;
/**
 * @author Deepali
 *
 */
public class Question {
	int questionId; //denote question id
	String question;//denote question

	enum questionType {
		singleselect, multipleselect, text
	};

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @param questionId : denote question id
	 * @param question  :denote question
	 */
	public Question(int questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	};
	
	

}
