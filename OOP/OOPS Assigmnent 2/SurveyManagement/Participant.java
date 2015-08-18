package SurveyManagement;

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

	public int getParticipantId() {
		return participantId;
	}

	public HashMap<String, String> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, String> hm) {
		this.hm = hm;
	}

	
	
}
