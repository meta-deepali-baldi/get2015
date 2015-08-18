package SurveyManagement;
/**
 * @author Deepali
 *
 */
public class Text extends Question {
	String answer;//Answer in String

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @param questionId : denote question no
	 * @param question :Question
	 * @param answer :String
	 */
	public Text(int questionId, String question, String answer) {
		super(questionId, question);
		this.answer = answer;
	}

}
