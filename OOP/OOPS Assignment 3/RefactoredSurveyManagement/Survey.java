package RefactoredSurveyManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import RefactoredSurveyManagement.Question.questionType;

/**
 * @author Deepali
 * 
 */
public class Survey {
	List<Participant> participantList; // List of participant
	List<Question> questionList; // List of question
	HashMap<String, HashMap<String, Integer>> hmQuestion; // Mapping for
															// relating question
															// with their
															// specified option
															// and no. of
															// participant
															// selecting it

	public Survey() {// for creating their list and hashmap
		super();
		participantList = new ArrayList<Participant>();
		questionList = new ArrayList<Question>();
		hmQuestion = new HashMap<String, HashMap<String, Integer>>();
	}

	/**
	 * @param fileName
	 *            :It takes filename as argument where questions are specified
	 * @throws IOException
	 *             :if no file found
	 */
	public void readData(String fileName) throws IOException {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		int questionId = 0;
		String question = "";
		String questiontype = "";
		String optionList[];
		List<String> options = new ArrayList<String>();

		List<String> answerMultiple = new ArrayList<String>();

		try {
			File f=new File(fileName).getAbsoluteFile();
			br = new BufferedReader(new FileReader(f));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] row = line.split(cvsSplitBy);
				questionId = Integer.parseInt(row[0]);
				question = row[1];
				questiontype = row[2];

				if (questionType.singleselect.toString().equals(questiontype)) {
					//for single type question
					optionList = row[3].split("/");
					for (int i = 0; i < optionList.length; i++) {
						options.add(optionList[i]);
					}
					SingleSelect select = new SingleSelect(questionId,
							question, options, row[4]);
					questionList.add(select);

				} else if (questionType.multipleselect.toString().equals(questiontype)) {//for multiple answer question
					//for option
					optionList = row[3].split("/");
					for (int i = 0; i < optionList.length; i++) {
						options.add(optionList[i]);
					}
					//for answer
					optionList = row[4].split("/");
					for (int i = 0; i < optionList.length; i++) {
						answerMultiple.add(optionList[i]);
					}
					MultiSelect select = new MultiSelect(questionId, question,
							options, answerMultiple);
					questionList.add(select);

				} else {
					//for text type question
					Text select = new Text(questionId, question, row[3]);
					questionList.add(select);
				}
				//to remove previous elements from list
				options.removeAll(options);
				answerMultiple.removeAll(answerMultiple);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * this function is to display question in survey for participants
	 */
	public void takeSurvey() {

		String answer = "";
		int id;
		String question = "";
		int count=0;
		Scanner scanner = new Scanner(System.in);
		Participant participant = new Participant();
	
		Iterator<Question> itr = questionList.iterator();	//Iterating list of questions

		while (itr.hasNext()) {
			Question questionObject = itr.next();
			id = questionObject.getQuestionId();//getting id of question
			question = questionObject.getQuestion();//getting question
			System.out.print("Q" + id + "  " + question + " ");

			if (questionObject instanceof SingleSelect) {//if question is of single select type
				System.out.print(",SingleSelect,");
				SingleSelect select = (SingleSelect) questionObject;
				//Iterating option list
				Iterator<String> optionIterator = select.getOptions().iterator();
				System.out.print("( ");
				while (optionIterator.hasNext()) {
					System.out.print(optionIterator.next() + "  ");
				}
				System.out.println(")");
				do{
				answer = scanner.next();
				if(answer.charAt(0)=='A'||answer.charAt(0)=='B'||answer.charAt(0)=='C'||answer.charAt(0)=='D'||answer.charAt(0)=='E'||answer.charAt(0)=='a'||answer.charAt(0)=='b'||answer.charAt(0)=='c'||answer.charAt(0)=='d'||answer.charAt(0)=='e'){
					break;
				}
				System.out.print("Enter correct value");
				}while(true);
				 answer=answer.toUpperCase();
			} else if (questionObject instanceof MultiSelect) {//if question is of multiselect type
				MultiSelect select = (MultiSelect) questionObject;
				System.out.println(",MultiSelect,");
				//Iterating option list
				Iterator<String> optionIterator = select.getOptions().iterator();
				System.out.print("( ");
				while (optionIterator.hasNext()) {
					System.out.print(optionIterator.next() + " /");
				}
				System.out.println(")   (Answer in format of answer1/answer2/..)");
				count=0;
				do{
					answer = scanner.next();
					String answerList[]=answer.split("/");
					for(int i=0;i<answerList.length;i++){
					if(answerList[i].charAt(0)=='A'||answerList[i].charAt(0)=='B'||answerList[i].charAt(0)=='C'||answerList[i].charAt(0)=='D'||answerList[i].charAt(0)=='E'||answerList[i].charAt(0)=='a'||answerList[i].charAt(0)=='b'||answerList[i].charAt(0)=='c'||answerList[i].charAt(0)=='d'||answerList[i].charAt(0)=='e'){
						count++;
						
					}
					}
					if(count==answerList.length){
						break;
					}
					System.out.print("Enter correct value");
					}while(true);
                   answer= answer.toUpperCase();
			} else {  //if question is of text type
				System.out.println(",Text");
				answer = scanner.next();
			}

			participant.getHm().put(question, answer);//adding it to hashmap in participant
		}
		participantList.add(participant);//adding to participant list
	}

	/**
	 * To display statistics of survey
	 */
	public void statistics() {
		String question = "";
		List<String> optionsList;
		//To set initial default value(0) and question in hashmap 
		Iterator<Question> questionIterator = questionList.iterator();
		while (questionIterator.hasNext()) {//question list iterator
			Question questionObject = questionIterator.next();
			HashMap<String, Integer> hmOption = new HashMap<String, Integer>();
			if (questionObject instanceof SingleSelect) {//selecting only singleselect questions

				SingleSelect select = (SingleSelect) questionObject;
				question = select.getQuestion();
				optionsList = select.getOptions();
				Iterator<String> optionIterator = optionsList.iterator();//iterating options
				while (optionIterator.hasNext()) {
					hmOption.put("" + optionIterator.next().charAt(0), 0);//adding it to hashmap
				}
				hmQuestion.put(question, hmOption);//adding hashmap of options into hashmap of questions
			}
		}
		
		
		//To calculate statistics 
		Iterator<Participant> participantIterator = participantList.iterator();
		while (participantIterator.hasNext()) {
			Participant participant = participantIterator.next();
			HashMap<String, String> hmParticipant = participant.getHm();//get paticipant hashmap
			for (Map.Entry  map : hmQuestion.entrySet()) {
				question = (String) map.getKey();//getting question from hashmap
				
				if (hmParticipant.containsKey(question)) {//checking if participant contain this question or not
					
					String answer = hmParticipant.get(question);//getting answer of participant
					int i=hmQuestion.get(question).get(answer);
					int j=i+1;
					hmQuestion.get(question).put(answer,j);//updating value at that answer in hashmap of question
				}
			}

		}

	}

	/**
	 * To display statistics
	 */
	public void displayStatistics() {
		int size=participantList.size();
		for (Map.Entry map : hmQuestion.entrySet()) {
			System.out.println(map.getKey());//getting question
			for (Map.Entry innerMap : ((HashMap<String, Integer>) map.getValue()).entrySet()) {
				// Get an iterator
				float percentage = ((Integer) innerMap.getValue() * 100.0f) / size;  //calculating percentage
				System.out.println(innerMap.getKey() + " : " + Math.round(percentage) + "%");
			
				System.out.println();
			}

		}
	}

	/**
	 * TO DISPLAY WHAT ARE ANSWERS OF PARTICIPANTS
	 */
	public void displayParticipant() {
		int i=1,j=1;
		Iterator<Participant> participantIterator = participantList.iterator();
			//participant id
		while (participantIterator.hasNext()) {   //iterating participant list
			System.out.println("Participant  " + i+ ":");			
			Participant participant = participantIterator.next();
			System.out.println();
			j=1;
			Iterator<Question> questionIterator = questionList.iterator();
			while (questionIterator.hasNext()) {//question list iterator
				Question questionObject = questionIterator.next();
				HashMap<String, String> hmParticipant = participant.getHm();  //getting hashmap of participant
				for (Map.Entry map : hmParticipant.entrySet()) {
					if(map.getKey().equals(questionObject.getQuestion())) {
						System.out.println("Q"+j+" "+map.getKey() + "  ");   //question
						String[] rowAnswers = ((String) map.getValue()).split("/");
						for (String answers : rowAnswers) {
							System.out.println(answers);  //answers of participant
						}
					}
				}
				j=j+1;
			}
			i=i+1;
		}

	}
}
