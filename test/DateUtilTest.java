import java.util.Date;
import junit.framework.TestCase;


public class DateUtilTest extends TestCase {
	public void testCreateDate() {
	Date date = new DateUtil().createDate(2003, 1, 6);
	
	assertEquals("Mon Jan 06 00:00:00 KST 2003", date);
	}
}

