package Session5;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author deepali
 * 
 */

class LinkedQueue {
	private LinkedList<String> queue;
	
	/**
	 *  Constructor 
	 */
	public LinkedQueue() {
		queue = new LinkedList<String>();
	}


	/** Function to get the size of the queue 
	 * @return :returning size
	 */
	public int getSize() {
		return queue.size();
	}


	/**Function to insert an element to the queue
	 * @param data :data to insert in queue
	 */
	public void enqueue(String data) {
		queue.addLast(data);
	}

	
	/**Function to remove front element from the queue
	 * @return :first data to be removed
	 */
	public String dequeue() {
		return queue.removeFirst();

	}

	
	/**Function to check the front element of the queue 
	 * @return :front element from queue
	 */
	public String getFront() {
		return queue.getFirst();
	}

	
	/**
	 * Function to display the element of the queue
	 */
	public void display() {
		int i = 1;
		Iterator<String> queueIterator = queue.iterator();
		while (queueIterator.hasNext()) {
			System.out.println("Element at" + i + "is : "
					+ queueIterator.next());
			i++;
		}
		if(queue.size()==0) {
			System.out.println("No element in queue");	
		}
	}

	/**
	 *To make queue empty 
	 */
	void makeEmpty() {
		queue.removeAll(queue);
	}

}
