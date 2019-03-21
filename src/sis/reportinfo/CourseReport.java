package sis.reportinfo;

import sis.studentinfo.CourseSession;
import java.util.*;
import static sis.reportinfo.ReportConstant.NEWLINE;

public class CourseReport {
	private ArrayList<CourseSession> sessions = 
			new ArrayList<CourseSession>();
	
	void add(CourseSession session) {
		sessions.add(session);
	}
	
	String text() {
		Collections.sort(sessions);
		StringBuilder builder = new StringBuilder();
		for(CourseSession session: sessions)
			builder.append(
					session.getDepartment() + " " +
			session.getNumber() + NEWLINE);
		return builder.toString();
	}
	
}
