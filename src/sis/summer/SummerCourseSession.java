package sis.summer;

import java.util.*;
import sis.studentinfo.*;

public class SummerCourseSession extends Session {
	public static SummerCourseSession create(String department, String number, Date startDate) {
		return new SummerCourseSession(department, number, startDate);
	}
	
	public SummerCourseSession(String department, String number, Date startDate) {
		super (department, number, startDate);
	}
	
	@Override
	protected int getSessionLength() {
		return 8;
	}
	
}
