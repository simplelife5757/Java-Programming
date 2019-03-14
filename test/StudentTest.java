import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest extends junit.framework.TestCase{
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
}
