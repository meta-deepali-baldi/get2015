package SurveyManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deepali
 * 
 */
public class MultiSelect extends Question {
	List<String> options;// List of Options
	List<String> answer;// List of answers

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public List<String> getAnswer() {
		return answer;
	}

	public void setAnswer(List<String> answer) {
		this.answer = answer;
	}

	/**
	 * @param questionId : denote question no
	 * @param question :Question
	 * @param options :List of Options
	 * @param answer :List of answers
	 */
	public MultiSelect(int questionId, String question, List<String> options,
			List<String> answer) {
		super(questionId, question);
		this.options = new ArrayList<String>(options);

		this.answer = new ArrayList<String>(answer);
	}

}
