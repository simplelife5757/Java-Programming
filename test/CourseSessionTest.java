import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

public class CourseSessionTest extends junit.framework.TestCase{
	private CourseSession session;
	private Date startDate;
	//클래스에서 생성자를 정의 하지 않으면 기본적으로 인수를 가지지 않는 생성자를 제공한다.
	//자바는 생성자를 클래스의 필수 요소로 여긴다. 
//	CourseSessionTest() {
//		
//	}
	public void setUp() {
		int year = 103;
		int month = 0;
		int date = 6;
		startDate = new Date(year, month, date);
		session = new CourseSession("ENGL", "101", startDate);
	}
	
	public void testCreate() {
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(startDate, session.getStartDate());		
	}
	
	//등록했을 상황을 추가한다. 
	public void testEnrollStudents() {
		Student student1 = new Student("Cain DiVoe");
		session.enroll(student1);
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		
		Student student2 = new Student("Coralee DeVaughn");
		session.enroll(student2);
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
	}
	
	public void testCourseDates() {
		int year = 103;
		int month = 3;
		int date = 25;
		Date sixteemWeelsOut = new Date(year, month, date);
		assertEquals(sixteemWeelsOut, session.getEndDate());
	}
}
