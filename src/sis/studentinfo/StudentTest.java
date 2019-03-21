package sis.studentinfo;
import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTest extends junit.framework.TestCase{
	private static final double GRADE_TOLERANCE = 0.05;
	public void testCreate() {
		final String firstStudentName = "Jane Doe";
		final Student firstStudent = new Student(firstStudentName);
		//Student���� student��� �̸�  �޼ҵ� �������� �����ϴ� �������� = temporary variable 
		String fisrtStudentName = firstStudent.getName();
		assertEquals("Jane Doe", firstStudentName); // 
//		assertEquals("Jane Doe", student.name); �����ϸ� not visible �̶�� ���.

		// �ߺ��� ���ְ� �ǹ̸� ��Ȯ�� �ϱ� ���ؼ� ���ڿ� ����� ��ü
		final String secondStudentName = "Joe Blow";
		final Student secondStudent = new Student(secondStudentName); 
		assertEquals(secondStudentName, secondStudent.getName()); //secondStudent.name ���� �����ϴ°� ��ü���� (x)
		
		// ��ü ���� = ���ο� ��ü ����, �ٸ� ��ü�� �޼����� �����ų�, ��ü ���۷�����(new�� ���� �����ǰų� �޽��� ������ ���� ���� )��ü�� �ּҸ� �Ҵ��ϴ� ��.
		
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
		assertEquals(Student.CREDITS_REQUIRED_FOR_FULL_TIME, student.getCredits());
		assertTrue(student.isFullTime());
	}

	public void testInState() {
		Student student = new Student("a");
		assertFalse(student.isInState());
		student.setState(Student.IN_STATE);
		assertTrue(student.isInState());
		student.setState("MD");
		assertFalse(student.isInState());
	}
	public void testCalculateGpa() {
		Student student = new Student("a");
		assertEquals(0.0, student.getGpa(), GRADE_TOLERANCE);
		student.addGrade("A");
		assertEquals(4.0, student.getGpa(), GRADE_TOLERANCE);
		student.addGrade("B");
		assertEquals(3.5, student.getGpa(), GRADE_TOLERANCE);
		student.addGrade("C");
		assertEquals(3.0, student.getGpa(), GRADE_TOLERANCE);
		student.addGrade("D");
		assertEquals(2.5, student.getGpa(), GRADE_TOLERANCE);
		student.addGrade("E");
		assertEquals(2.0, student.getGpa(), GRADE_TOLERANCE);
	}
}
