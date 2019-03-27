package sis.studentinfo;

import java.util.*;

abstract public class Session implements Comparable<Session> {
	private static int count;
	private String department;
	private String number;
	private ArrayList<Student> students = new ArrayList<Student>();
	public Date startDate;
	private int numberOfCredits;
	
	protected Session(String department, String number, Date startDate) {
		this.department = department;
		this.number = number;
		this.startDate = startDate;
	}
	
	public int compareTo(Session that) {
		int compare = this.getDepartment().compareTo(that.getDepartment());
		if (compare == 0)
			compare = this.getNumber().compareTo(that.getNumber());
		return compare;
	}
	void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
	
	public String getDepartment() {
		return department;
	}

	public String getNumber() {
		return number;
	}
	// Student Ŭ������ CourseSession Ŭ���� ��� �ٸ� ��ü���� �����͸� �������� �޼ҵ带 �����Ѵ�. �̰� ��ü ������ �ƴϰ�
	// � ���� �ϵ��� �ϱ� ���� �޼����� ������ �����ؾ� �Ѵ�.

	int getNumberOfStudents() {
		return students.size();
	}
	
	public ArrayList<Student> getAllStudents(){
		return students;
	}


	public void enroll(Student student) {
		student.addCredits(numberOfCredits);
		students.add(student);
	}
	
	Student get(int index) {
		return students.get(index);
	}

	protected Date getStartDate() {
		return startDate;
	}

	abstract protected int getSessionLength();
	
	public Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(getStartDate());
		final int daysFromFridayToMonday = 3;
		final int daysInWeek = 7;
		int numberOfDays = getSessionLength() * daysInWeek - daysFromFridayToMonday;
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}

}
