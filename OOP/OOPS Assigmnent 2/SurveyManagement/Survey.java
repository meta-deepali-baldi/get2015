package SurveyManagement;

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
import SurveyManagement.Question.questionType;

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
		String type = "";
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
				type = row[2];

				if (questionType.singleselect.toString().equals(type)) {
					//for single type question
					optionList = row[3].split("/");
					for (int i = 0; i < optionList.length; i++) {
						options.add(optionList[i]);
					}
					SingleSelect select = new SingleSelect(questionId,
							question, options, row[4]);
					questionList.add(select);

				} else if (questionType.multipleselect.toString().equals(type)) {//for multiple answer question
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
		Scanner scanner = new Scanner(System.in);
		Participant participant = new Participant();
		//Iterating list of questions
		Iterator<Question> itr = questionList.iterator();

		while (itr.hasNext()) {
			Question question2 = itr.next();
			id = question2.getQuestionId();//getting id of question
			question = question2.getQuestion();//getting question
			System.out.print("Q" + id + "  " + question + "  ");

			if (question2 instanceof SingleSelect) {//if question is of single select type
				System.out.print(",SingleSelect,");
				SingleSelect select = (SingleSelect) question2;
				//Iterating option list
				Iterator<String> itr1 = select.getOptions().iterator();
				System.out.print("( ");
				while (itr1.hasNext()) {
					System.out.print(itr1.next() + " /");
				}
				System.out.println(")");
				answer = scanner.next();

			} else if (question2 instanceof MultiSelect) {//if question is of multiselect type
				MultiSelect select = (MultiSelect) question2;
				System.out.println(",MultiSelect,");
				//Iterating option list
				Iterator<String> itr1 = select.getOptions().iterator();
				System.out.print("( ");
				while (itr1.hasNext()) {
					System.out.print(itr1.next() + " /");
				}
				System.out.println(")   (Answer in format of answer1/answer2/..)");

				answer = scanner.next();

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
		List<String> options;
		//To set initial default value(0) and question in hashmap 
		Iterator<Question> itr1 = questionList.iterator();
		while (itr1.hasNext()) {//question list iterator
			Question question2 = itr1.next();
			HashMap<String, Integer> hmOption = new HashMap<String, Integer>();
			if (question2 instanceof SingleSelect) {//selecting only singleselect questions

				SingleSelect select = (SingleSelect) question2;
				question = select.getQuestion();
				options = select.getOptions();
				Iterator<String> itr2 = options.iterator();//iterating options
				while (itr2.hasNext()) {
					hmOption.put("" + itr2.next().charAt(0), 0);//adding it to hashmap
				}
				hmQuestion.put(question, hmOption);//adding hashmap of options into hashmap of questions
			}
		}
		
		
		//To calculate statistics 
		Iterator<Participant> itr = participantList.iterator();
		while (itr.hasNext()) {
			Participant participant = itr.next();
			HashMap<String, String> hmParticipant = participant.getHm();//get paticipant hashmap
			for (Map.Entry  m1 : hmQuestion.entrySet()) {
				question = (String) m1.getKey();//getting question from hashmap
				
				if (hmParticipant.containsKey(question)) {//checking if participant contain this question or not
					
					String answer = hmParticipant.get(question);//getting answer of participant
					int i = hmQuestion.get(question).get(answer);
					int j = i + 1;
					hmQuestion.get(question).put(answer, j);//updating value at that answer in hashmap of question
				}
			}

		}

	}

	/**
	 * To display statistics
	 */
	public void displayStatistics() {
		int size = 0;
		size = participantList.size();//calculated size of participant list
		for (Map.Entry m : hmQuestion.entrySet()) {
			System.out.println(m.getKey());//getting question
			for (Map.Entry me : ((HashMap<String, Integer>) m.getValue()).entrySet()) {
				// Get an iterator

				int percentage = ((Integer) me.getValue() * 100) / size;  //calculating percentage
				System.out.println(me.getKey() + " : " + percentage + "%");
				System.out.println();
			}

		}
	}

	/**
	 * TO DISPLAY WHAT ARE ANSWERS OF PARTICIPANTS
	 */
	public void displayParticipant() {
		int i=1;
		Iterator<Participant> itr = participantList.iterator();
		while (itr.hasNext()) {   //iterating participant list
			Participant participant = itr.next();
			System.out.println();
			System.out.println("Participant  " + i
					+ ":");				//participant id
			HashMap<String, String> hm = participant.getHm();  //getting hashmap of participant
			for (Map.Entry m : hm.entrySet()) {
				System.out.println(m.getKey() + "  ");   //question
				String[] row = ((String) m.getValue()).split("/");
				for (String answers : row) {
					System.out.println(answers);  //answers of participant
				}

			}
			i=i+1;
		}

	}
}
