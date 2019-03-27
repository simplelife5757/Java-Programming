package sis.reportinfo;

import java.util.*;
import sis.studentinfo.*;

public class ReportCard {
	static final String A_MESSAGE = "Excellent";
	static final String B_MESSAGE = "Very good";
	static final String C_MESSAGE = "Hmm...";
	static final String D_MESSAGE = "Youre not trying";
	static final String F_MESSAGE = "Excellent";
	
	private Map<Student.Grade, String> messages = null;
	
	public String getMessage(Student.Grade grade) {
		return getMessages().get(grade);
	}
	
	private Map<Student.Grade, String> getMessages(){
		if (messages == null)
			loadMessages();
		return messages;
	}
	//void load()
	private void loadMessages() {
		messages = new EnumMap<Student.Grade, String>(Student.Grade.class);
		messages.put(Student.Grade.A, A_MESSAGE);
		messages.put(Student.Grade.B, B_MESSAGE);
		messages.put(Student.Grade.C, C_MESSAGE);
		messages.put(Student.Grade.D, D_MESSAGE);
		messages.put(Student.Grade.F, F_MESSAGE);
	}
}
