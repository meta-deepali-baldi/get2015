/**
 * 
 */
package Assignment;

/**
 * @author Deepali
 *
 */
class CallByValue{  
	 int data=50;  
	  
	 void change(int data){  
	 data=data+100;//changes will be in the local variable only  
	 }  
	     
	 public static void main(String args[]){  
	   CallByValue callByValue=new CallByValue();  
	  
	   System.out.println("before change "+callByValue.data);  
	   callByValue.change(500);  
	   System.out.println("after change "+callByValue.data);  
	  
	 }  
	}  