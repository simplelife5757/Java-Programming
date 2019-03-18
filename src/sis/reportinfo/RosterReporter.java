package sis.reportinfo;
import java.util.*;
import sis.studentinfo.*;

public class RosterReporter {
	public static final String NEWLINE = 
			System.getProperty("line.separator");
	public static final String ROSTER_REPORT_HEADER = 
			"Student" + NEWLINE + 
			"-" + NEWLINE;
	public static final String ROSTER_REPORT_FOOTER = 
			NEWLINE + "# students = ";
	
	
	private CourseSession session;

	RosterReporter(CourseSession session) {
		this.session = session;
	}

	String getReport() {
		StringBuilder buffer = new StringBuilder();
		writeHeader(buffer);
		writeBody(buffer);
		writeFooter(buffer);
		return buffer.toString();
	}
	void writeHeader(StringBuilder buffer) {
		buffer.append(ROSTER_REPORT_HEADER);
	}
	void writeBody(StringBuilder buffer) {
		for (Student student : session.getAllStudents()) {
			buffer.append(student.getName());
			buffer.append(NEWLINE);
		}
	}
	void writeFooter(StringBuilder buffer) {
		buffer.append(
				ROSTER_REPORT_FOOTER + session.getAllStudents().size() +
				NEWLINE);
	}
}
