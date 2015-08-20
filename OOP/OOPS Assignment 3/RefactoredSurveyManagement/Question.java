package RefactoredSurveyManagement;
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

	/**
	 * @param questionId : denote question id
	 * @param question  :denote question
	 */
	public Question(int questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}

	/**
	 * @return the questionId
	 */
	public int getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	};
	
	

}
