package LibraryManagement;

/**
 * @author Deepali
 *
 */
public class Member {
	private int memberId; //member id
	private String memberName; //Member name
	private String addressLineFirst; //address Line 1 of member
	private String addressLineSecond; //address Line 2 of member
	private char category; //Gender of member
	private String personType; //Specification of member
	
	/**
	 * @return the memberId
	 */
	public int getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}
	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	/**
	 * @return the addressLineFirst
	 */
	public String getAddressLineFirst() {
		return addressLineFirst;
	}
	/**
	 * @param addressLineFirst the addressLineFirst to set
	 */
	public void setAddressLineFirst(String addressLineFirst) {
		this.addressLineFirst = addressLineFirst;
	}
	/**
	 * @return the addressLineSecond
	 */
	public String getAddressLineSecond() {
		return addressLineSecond;
	}
	/**
	 * @param addressLineSecond the addressLineSecond to set
	 */
	public void setAddressLineSecond(String addressLineSecond) {
		this.addressLineSecond = addressLineSecond;
	}
	/**
	 * @return the category
	 */
	public char getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(char category) {
		this.category = category;
	}
	/**
	 * @return the personType
	 */
	public String getPersonType() {
		return personType;
	}
	/**
	 * @param personType the personType to set
	 */
	public void setPersonType(String personType) {
		this.personType = personType;
	}

	
	
}
