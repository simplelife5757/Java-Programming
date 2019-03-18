package sis.reportinfo;
import junit.framework.TestCase;
import java.util.*;
import sis.studentinfo.*;

//학생이 추가 되었을 때 리포트가 잘 나오는지 획인 하는 클래스 
public class RosterReporterTest extends TestCase {
	public void testRosterReport() {
	CourseSession session = CourseSession.create("ENGL", "101", DateUtil.createDate(2003, 1, 6));
	
	session.enroll(new Student("A"));
	session.enroll(new Student("B"));
	
	String rosterReport = new RosterReporter(session).getReport(); // 이렇게 쓰는 것도 가능하구나... 초기화 하면서 메소드 호출을 동시에 할 수 있는 것인가... 
	
	System.out.println(rosterReport);
	assertEquals(RosterReporter.ROSTER_REPORT_HEADER +
			"A" + RosterReporter.NEWLINE +
			"B" + RosterReporter.NEWLINE +
			RosterReporter.ROSTER_REPORT_FOOTER + "2" +
			RosterReporter.NEWLINE, rosterReport);
	}
	
}
