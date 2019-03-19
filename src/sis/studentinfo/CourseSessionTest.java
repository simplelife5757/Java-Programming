package sis.studentinfo;

//import static org.junit.Assert.*;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.GregorianCalendar;
import java.util.*;

import org.junit.Test;

//CourseSession클래스에서 꼭 다루어야 하는 목표는 강의에 대한 모든 정보를 추적하는 것 
public class CourseSessionTest extends junit.framework.TestCase{
	private static final int CREDITS = 3;
	private CourseSession session;
	private Date startDate;
	//클래스에서 생성자를 정의 하지 않으면 기본적으로 인수를 가지지 않는 생성자를 제공한다.
	//자바는 생성자를 클래스의 필수 요소로 여긴다. 
//	CourseSessionTest() {
//		
//	}
	public void setUp() {
		startDate = DateUtil.createDate(2003, 1, 6);
		session = createCourseSession();
	}
	
	//코스의 정보에 관한 것에 대한 테스트 
	public void testCreate() {
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(startDate, session.getStartDate());		
	}
	
	//코스의 날짜에 대한 정보에 대한 테스트 
	
	public void testCourseDates() {
		Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}
	//등록했을 상황을 추가한다. 
	public void testEnrollStudents() {
		Student student1 = new Student("Cain DiVoe");
		session.enroll(student1);
		assertEquals(CREDITS, student1.getCredits());
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		
		Student student2 = new Student("Coralee DeVaughn");
		session.enroll(student2);
		assertEquals(CREDITS, student1.getCredits());
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
	}	
	
	public void testCount() {
		CourseSession.resetCount();
		createCourseSession(); //객체를 찍어내는 것도 메소드로 만들기. 
//		assertEquals(1, CourseSession.count); 직접 변수를 보이는 것은 좋지 않다.  
		assertEquals(1, CourseSession.getCount()); 
		createCourseSession();
		assertEquals(2, CourseSession.getCount());
	}
	private CourseSession createCourseSession() {
		CourseSession session = CourseSession.create("ENGL", "101", startDate);
		session.setNumberOfCredits(CourseSessionTest.CREDITS);
		return session;
	}
}
