package RoomManagement;

/**
 * @author Deepali
 *
 */
public class Guest {
	 private int age;//age of guest
	 private String name;  //name of guest
	 
	/**
	 * @param key: age of guest
	 * @param name  :name of guest
	 */
	public Guest(int key, String name) {
		this.age = key;
		this.name = name;
	}
	/**
	 * @return the key
	 */
	public int getKey() {
		return age;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(int key) {
		this.age = key;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
