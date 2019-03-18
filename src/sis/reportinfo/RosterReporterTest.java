package sis.reportinfo;
import junit.framework.TestCase;
import java.util.*;
import sis.studentinfo.*;

//�л��� �߰� �Ǿ��� �� ����Ʈ�� �� �������� ȹ�� �ϴ� Ŭ���� 
public class RosterReporterTest extends TestCase {
	public void testRosterReport() {
	CourseSession session = CourseSession.create("ENGL", "101", DateUtil.createDate(2003, 1, 6));
	
	session.enroll(new Student("A"));
	session.enroll(new Student("B"));
	
	String rosterReport = new RosterReporter(session).getReport(); // �̷��� ���� �͵� �����ϱ���... �ʱ�ȭ �ϸ鼭 �޼ҵ� ȣ���� ���ÿ� �� �� �ִ� ���ΰ�... 
	
	System.out.println(rosterReport);
	assertEquals(RosterReporter.ROSTER_REPORT_HEADER +
			"A" + RosterReporter.NEWLINE +
			"B" + RosterReporter.NEWLINE +
			RosterReporter.ROSTER_REPORT_FOOTER + "2" +
			RosterReporter.NEWLINE, rosterReport);
	}
	
}
