import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CourseSession {
	private String department;
	private String number;
	private ArrayList<Student> students = new ArrayList<Student>();
	private Date startDate;

	public CourseSession(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}

	String getDepartment() {
		return department;
	}

	String getNumber() {
		return number;
	}
	// Student 클래스나 CourseSession 클래스 모두 다른 객체에서 데이터를 가져가기 메소드를 제공한다. 이건 객체 지향이 아니고
	// 어떤 일을 하도록 하기 위해 메세지를 보내서 수행해야 한다.

	int getNumberOfStudents() {
		return students.size();
	}

	void enroll(Student student) {
		students.add(student);
	}
	
	Student get(int index) {
		return students.get(index);
	}

	Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		int numberOfDays = 16 * 7 - 3;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		Date endDate = calendar.getTime();
		return endDate;
	}

	Date getStartDate() {
		return startDate;
	}
	
}
