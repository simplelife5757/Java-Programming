package sis.reportinfo;

import static org.junit.Assert.*;
import static sis.reportinfo.ReportConstant.NEWLINE;

import org.junit.Test;

import junit.framework.TestCase;
import sis.studentinfo.CourseSession;
import java.util.*;

public class CourseReportTest extends TestCase{
	public void testReport() {
		final Date date = new Date();
		CourseReport report = new CourseReport();
		// report method: add, text 
		report.add(CourseSession.create("ENGL", "101", date));
		report.add(CourseSession.create("CZEC", "200", date));
		report.add(CourseSession.create("ITAL", "410", date));
		report.add(CourseSession.create("CZEC", "220", date));
		report.add(CourseSession.create("ITAL", "330", date));
		
		assertEquals(
				"CZEC 200" + NEWLINE +
				"CZEC 220" + NEWLINE +
				"ENGL 101" + NEWLINE +
				"ITAL 330" + NEWLINE +
				"ITAL 410" + NEWLINE,
				report.text());
	}
	
}
