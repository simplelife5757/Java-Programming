package sis.studentinfo;

import junit.framework.*;
import java.util.*;
import static sis.studentinfo.DateUtil.createDate;

abstract public class SessionTest extends TestCase {
	protected Session session;
	protected Date startDate;
	private static final int CREDITS = 3;

		public void setUp() {
			startDate = createDate(2003, 1, 6);
			session = createSession("ENGL", "101", startDate);
			session.setNumberOfCredits(CREDITS);
		}
	
		abstract protected Session createSession(
				String department, String number, Date startDate);
		
		
	//코스의 정보에 관한 것에 대한 테스트 
		public void testCreate() {
			assertEquals("ENGL", session.getDepartment());
			assertEquals("101", session.getNumber());
			assertEquals(0, session.getNumberOfStudents());
			assertEquals(startDate, session.getStartDate());		
		}
		
		public void testComparable() {
			final Date date = new Date();
			CourseSession sessionA = CourseSession.create("CMSC", "101", date);
			CourseSession sessionB = CourseSession.create("ENGL", "101", date);
			assertTrue(sessionA.compareTo(sessionB) < 0);
			assertTrue(sessionB.compareTo(sessionA) > 0);
			
			CourseSession sessionC = CourseSession.create("CMSC", "101", date);
			assertEquals(0, sessionA.compareTo(sessionC));
		
			CourseSession sessionD = CourseSession.create("CMSC", "210", date);
			assertTrue(sessionC.compareTo(sessionD) < 0);
			assertTrue(sessionD.compareTo(sessionC) > 0);
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
	
		public void testSessionLength() {
			Session session = createSession(new Date());
			assertTrue(session.getSessionLength() > 0);
		}
}
