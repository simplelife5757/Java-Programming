package sis.studentinfo;
import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTest extends junit.framework.TestCase{
	public void testCreate() {
		final String firstStudentName = "Jane Doe";
		final Student firstStudent = new Student(firstStudentName);
		//Student형의 student라는 이름  메소드 내에서만 존재하는 지역변수 = temporary variable 
		String fisrtStudentName = firstStudent.getName();
		assertEquals("Jane Doe", firstStudentName); // 
//		assertEquals("Jane Doe", student.name); 실행하면 not visible 이라고 뜬다.

		// 중복을 없애고 의미를 명확히 하기 위해서 문자열 상수로 교체
		final String secondStudentName = "Joe Blow";
		final Student secondStudent = new Student(secondStudentName); 
		assertEquals(secondStudentName, secondStudent.getName()); //secondStudent.name 으로 접근하는게 객체지향 (x)
		
		// 객체 지향 = 새로운 객체 생성, 다른 객체로 메세지를 보내거나, 객체 레퍼런스에(new를 통해 생성되거나 메시지 전송을 통해 얻은 )객체의 주소를 할당하는 것.
		
	}
	
	public void testStudentStatus() {
		Student student = new Student("a");
		assertEquals(0, student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(3);
		assertEquals(3, student.getCredits());
		assertFalse(student.isFullTime());
		
		student.addCredits(4);
		assertEquals(7, student.getCredits());
		assertFalse("not enough credits for FT status", student.isFullTime());

		student.addCredits(5);
		assertEquals(12, student.getCredits());
		assertTrue("not enough credits for FT status", student.isFullTime());
		
	}
}
