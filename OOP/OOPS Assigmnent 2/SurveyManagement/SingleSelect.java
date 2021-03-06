package SurveyManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deepali
 *
 */
public class SingleSelect extends Question {

	List<String> options;//List of Options
	String answer;//Answer in String
	
	/**
	 * @param questionId : denote question no
	 * @param question :Question
	 * @param options :List of Options
	 * @param answer :String
	 */
	public SingleSelect(int questionId, String question, List<String> options,
			String answer) {
		super(questionId, question);
		
		this.options = new ArrayList<String>(options);
		this.answer = answer;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
