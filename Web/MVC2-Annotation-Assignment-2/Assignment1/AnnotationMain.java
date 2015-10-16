package Assignment1;
  /** 
 * 
Assignment 1:

Define an annotation type for an enhancement request with elements id, synopsis, engineer, and date.
 Specify the default value as unassigned for engineer and unknown for date.

 */

/** 
 * @author Deepali
 *
 */
public class AnnotationMain {
	 public static void main(String[] args) throws Exception {
	      TestAnnotationParser parser = new TestAnnotationParser();
	      parser.parse(Employee.class);
	   }
}
