package sis.studentinfo;
import java.util.*;
	
public class Student {
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final String IN_STATE = "CO";
	private String name; //������ �ʵ��� �θ���. private�� �ܺο��� ���� ������ ���ǵ帮�� �Ѵ�. 
	private int credits;
	private String state = "";
	private ArrayList<String> grades = new ArrayList<String>();
	
	public Student(String name) {
		this.name = name; //this�� ���� �ڵ带 �����ϰ� �ִ� ��ü�� ���� ��ü�� ���� ���۷����� �ǹ��Ѵ�.
		// �����ڴ� Ŭ���� �̸��� ���ƾ� �ϰ� �ٸ� ��ü�� �μ��� �����ڿ� �����ϴ� ���� �̿��Ͽ� ��ü�� �ʱ�ȭ �ϱ� ���� ����Ѵ�.
		credits = 0;
	}

	public String getName() {
		return name;
	}

	boolean isFullTime() {
		return credits >= CREDITS_REQUIRED_FOR_FULL_TIME;
	}

	int getCredits() {
		return credits;
	}
	
	void addCredits(int credits) {
		this.credits += credits;
	}

	boolean isInState() {
		return state.equals(Student.IN_STATE);
	}

	void setState(String state) {
		this.state = state; 
	}

	void addGrade(String grade) {
		grades .add(grade);
	}

	double getGpa() {
		if (grades.isEmpty())
			return 0.0;
		double total = 0.0;
		for (String grade: grades) {
			if (grade.equals("A"))
				total += 4;
			else if (grade.equals("B"))
				total += 3;
			else if (grade.equals("C"))
				total += 2;
			else if (grade.equals("D"))
				total += 1;
			}
		return total / grades.size();
	}

}
