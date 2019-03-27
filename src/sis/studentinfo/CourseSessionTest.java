package sis.studentinfo;

//import static org.junit.Assert.*;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.GregorianCalendar;
import java.util.*;
import org.junit.Test;
import static sis.studentinfo.DateUtil.createDate;

//CourseSessionŬ�������� �� �ٷ��� �ϴ� ��ǥ�� ���ǿ� ���� ��� ������ �����ϴ� �� 
public class CourseSessionTest extends SessionTest {
	
	//Ŭ�������� �����ڸ� ���� ���� ������ �⺻������ �μ��� ������ �ʴ� �����ڸ� �����Ѵ�.
	//�ڹٴ� �����ڸ� Ŭ������ �ʼ� ��ҷ� �����. 
//	CourseSessionTest() {
//		
//	}

	//�ڽ��� ��¥�� ���� ������ ���� �׽�Ʈ 
	public void testCourseDates() {
		Date startDate = DateUtil.createDate(2003, 1, 6);
		Session session = createSession("ENGL", "200", startDate);
		Date sixteenWeeksOut = createDate(2003, 4, 25);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}
		
	
	public void testCount() {
		CourseSession.resetCount();
		createSession("", "", new Date()); //��ü�� ���� �͵� �޼ҵ�� �����. 
//		assertEquals(1, CourseSession.count); ���� ������ ���̴� ���� ���� �ʴ�.  
		assertEquals(1, CourseSession.getCount()); 
		createSession("", "", new Date());
		assertEquals(2, CourseSession.getCount());
	}
	
	protected Session createSession(String department, String number, Date date) {
		return CourseSession.create(department, number, date);
	}
	
	
}
