package RefactoredSurveyManagement;

import java.util.HashMap;

/**
 * @author Deepali
 *
 */
public class Participant {
	int participantId=0; //Denotes id of participant
	HashMap<String, String> hm = new HashMap<String, String>(); //Hashmap storing question and its related answer of participant

	
	public Participant() {
		super();
		this.participantId++;//whenever new participant come new id created
	}


	/**
	 * @return the participantId
	 */
	public int getParticipantId() {
		return participantId;
	}

	/**
	 * @return the hm
	 */
	public HashMap<String, String> getHm() {
		return hm;
	}


	/**
	 * @param hm the hm to set
	 */
	public void setHm(HashMap<String, String> hm) {
		this.hm = hm;
	}

	
	
}
