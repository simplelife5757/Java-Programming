package sis.studentinfo;

//import static org.junit.Assert.*;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.GregorianCalendar;
import java.util.*;
import org.junit.Test;
import static sis.studentinfo.DateUtil.createDate;

//CourseSession클래스에서 꼭 다루어야 하는 목표는 강의에 대한 모든 정보를 추적하는 것 
public class CourseSessionTest extends SessionTest {
	
	//클래스에서 생성자를 정의 하지 않으면 기본적으로 인수를 가지지 않는 생성자를 제공한다.
	//자바는 생성자를 클래스의 필수 요소로 여긴다. 
//	CourseSessionTest() {
//		
//	}

	//코스의 날짜에 대한 정보에 대한 테스트 
	public void testCourseDates() {
		Date startDate = DateUtil.createDate(2003, 1, 6);
		Session session = createSession("ENGL", "200", startDate);
		Date sixteenWeeksOut = createDate(2003, 4, 25);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}
		
	
	public void testCount() {
		CourseSession.resetCount();
		createSession("", "", new Date()); //객체를 찍어내는 것도 메소드로 만들기. 
//		assertEquals(1, CourseSession.count); 직접 변수를 보이는 것은 좋지 않다.  
		assertEquals(1, CourseSession.getCount()); 
		createSession("", "", new Date());
		assertEquals(2, CourseSession.getCount());
	}
	
	protected Session createSession(String department, String number, Date date) {
		return CourseSession.create(department, number, date);
	}
	
	
}
