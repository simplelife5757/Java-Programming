package sis;
import junit.framework.TestSuite;

public class Alltests extends junit.framework.TestCase{
	public static TestSuite suite() {
		TestSuite suite = new TestSuite ();
		suite.addTest(sis.reportinfo.Alltests.suite());
		suite.addTest(sis.studentinfo.Alltests.suite());
		return suite;
	}
}
