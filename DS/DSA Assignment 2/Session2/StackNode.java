package Session2;

/**
 * @author Deepali
 *
 */
public class StackNode {

	protected String data;// data in node
	protected StackNode link;// next link

	public StackNode(String item) {
		this.data = item;
		link = null;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data: the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the link
	 */
	public StackNode getLink() {
		return link;
	}

	/**
	 * @param link :the link to set
	 */
	public void setLink(StackNode link) {
		this.link = link;
	}

}
