//import static org.junit.Assert.*;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.GregorianCalendar;
import java.util.*;

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
		startDate = createDate(2003, 1, 6);
		session = new CourseSession("ENGL", "101", startDate);
	}
	
	public void testCreate() {
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(startDate, session.getStartDate());		
	}
	
	Date createDate(int year, int month, int date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, date);
		return calendar.getTime();
	}
	public void testCourseDates() {
		Date sixteenWeeksOut = createDate(2003, 4, 25);
		assertEquals(sixteenWeeksOut, session.getEndDate());
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
}
