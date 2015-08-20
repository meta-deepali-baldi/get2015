package RefactoredSurveyManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Deepali
 * 
 */
public class MultiSelect extends Question {
	List<String> options;// List of Options
	List<String> answer;// List of answers

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

	/**
	 * @return the options
	 */
	public List<String> getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(List<String> options) {
		this.options = options;
	}

	/**
	 * @return the answer
	 */
	public List<String> getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(List<String> answer) {
		this.answer = answer;
	}
	

}
