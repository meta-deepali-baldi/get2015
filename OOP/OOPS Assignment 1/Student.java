package Assignment5;

public class Student extends Person {
	private int studentId;
	private String[] courses;

	public Student(int uid, String name, int studentId) {
		super(uid, name);
		this.studentId = studentId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String[] getCourses() {
		return courses;
	}

	public void setCources(String[] courses) {
		this.courses = courses;
	}

	public String toString() {// overidden toString
		return super.toString() + ", StudentId:" + studentId;
	}
}