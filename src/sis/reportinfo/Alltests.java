package sis.reportinfo;
import junit.framework.TestSuite;

public class Alltests {
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(RosterReporterTest.class);
		return suite;
	}

}
