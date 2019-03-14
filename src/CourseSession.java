import java.util.ArrayList;

public class CourseSession {
	private String department;
	private String number;
	private int numberOfStudents = 0; // int ���� �ʵ�� �⺻������ 0���� �ʱ�ȭ�ȴ�. �׷��� �ڵ��� ��Ȯ�� �ϱ� ���� ����д�. 
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
	// Student Ŭ������ CourseSession Ŭ���� ��� �ٸ� ��ü���� �����͸� �������� �޼ҵ带 �����Ѵ�. �̰� ��ü ������ �ƴϰ�
	// � ���� �ϵ��� �ϱ� ���� �޼����� ������ �����ؾ� �Ѵ�. 

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