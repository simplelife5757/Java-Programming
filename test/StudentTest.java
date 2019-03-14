import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest extends junit.framework.TestCase{
	public void testCreate() {
		Student student = new Student("Jane Doe"); //new �����ڴ� �޸� ������ ��ü�� ��ġ�� ���� ���۷����� ��ȯ�Ѵ�.
		//Student���� student��� �̸�  �޼ҵ� �������� �����ϴ� �������� = temporary variable 
		String studentName = student.getName();
		assertEquals("Jane Doe", studentName); // 
//		assertEquals("Jane Doe", student.name); �����ϸ� not visible �̶�� ���.

		// �ߺ��� ���ְ� �ǹ̸� ��Ȯ�� �ϱ� ���ؼ� ���ڿ� ����� ��ü
		final String secondStudentName = "Joe Blow";
		Student secondStudent = new Student(secondStudentName); 
		assertEquals(secondStudentName, secondStudent.getName()); //secondStudent.name ���� �����ϴ°� ��ü���� (x)
		
		// ��ü ���� = ���ο� ��ü ����, �ٸ� ��ü�� �޼����� �����ų�, ��ü ���۷�����(new�� ���� �����ǰų� �޽��� ������ ���� ���� )��ü�� �ּҸ� �Ҵ��ϴ� ��.

	}
}
