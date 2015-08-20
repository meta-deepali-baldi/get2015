package RefactoredSurveyManagement;
/**
 * @author Deepali
 *
 */
public class Text extends Question {
	String answer;//Answer in String

	/**
	 * @param questionId : denote question no
	 * @param question :Question
	 * @param answer :String
	 */
	public Text(int questionId, String question, String answer) {
		super(questionId, question);
		this.answer = answer;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	

}
