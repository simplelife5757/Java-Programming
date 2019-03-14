import static org.junit.Assert.*;

import org.junit.Test;

public class CourseSessionTest extends junit.framework.TestCase{

	//클래스에서 생성자를 정의 하지 않으면 기본적으로 인수를 가지지 않는 생성자를 제공한다.
	//자바는 생성자를 클래스의 필수 요소로 여긴다. 
//	CourseSessionTest() {
//		
//	}
	
	public void testCreate() {
		CourseSession session = new CourseSession("ENGL", "101");
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
		
	}
	
	//등록했을 상황을 추가한다. 
	public void testEnrollStudents() {
		CourseSession session = new CourseSession("ENGL", "101");
		
		Student student1 = new Student("Cain DiVoe");
		session.enroll(student1);
		assertEquals(1, session.getNumberOfStudents());
		java.util.ArrayList<Student> allStudents = session.getAllStudents();
		assertEquals(1, allStudents.size());
		assertEquals(student1, allStudents.get(0));
		
		
		Student student2 = new Student("Coralee DeVaughn");
		session.enroll(student2);
		assertEquals(2, session.getNumberOfStudents());
		assertEquals(2, allStudents.size());
		assertEquals(student2, allStudents.get(1));
	}
}
