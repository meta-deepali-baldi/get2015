package Assignment1;

/**
 * @author Deepali
 *
 */
abstract class Approver{
    
	protected Approver successor;//protected instance used only by sub classes
 
    /**To set successor of a approver
     * @param successor :successor
     */
    public void SetSuccessor(Approver successor)
    {
      this.successor = successor;
    }
 
    /**
     * @param noOfDays :no of days for leave
     */
    public abstract void ProcessRequest(int noOfDays);
  }