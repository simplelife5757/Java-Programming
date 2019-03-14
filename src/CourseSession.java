import java.util.ArrayList;

public class CourseSession {
	private String department;
	private String number;
	private int numberOfStudents = 0; // int 형의 필드는 기본적으로 0으로 초기화된다. 그러나 코드의 명확히 하기 위해 적어둔다. 
	private java.util.ArrayList<Student> students = new java.util.ArrayList<Student>();
	
	public CourseSession(String department, String number) {
		this.department = department;
		this.number = number;
	}

	public String getDepartment() {
		return department;
	}
	
		public String getNumber() {
			return number;
	}
	// Student 클래스나 CourseSession 클래스 모두 다른 객체에서 데이터를 가져가기 메소드를 제공한다. 이건 객체 지향이 아니고
	// 어떤 일을 하도록 하기 위해 메세지를 보내서 수행해야 한다. 

	 int getNumberOfStudents() {
			return numberOfStudents;
		}

	 void enroll(Student student) {
			numberOfStudents  += 1;
			students.add(student);
		}

	java.util.ArrayList<Student> getAllStudents() {
		return students ;
	}

}
