package sis.studentinfo;
import java.util.*;
	
public class Student {
	enum Grade { A, B, C, D, F};
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final String IN_STATE = "CO";
	private String name; //������ �ʵ��� �θ���. private�� �ܺο��� ���� ������ ���ǵ帮�� �Ѵ�. 
	private int credits;
	private String state = "";
	private ArrayList<Grade> grades = new ArrayList<Grade>();
	private GradingStrategy gradingStrategy = new RegularGradingStrategy();
	
	void setGradingStrategy(GradingStrategy gradingStrategy) {
		this.gradingStrategy = gradingStrategy;
	}
	
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

	void addGrade(Grade grade) {
		grades.add(grade);
	}

	double getGpa() {
		if (grades.isEmpty())
			return 0.0;
		double total = 0.0;
		for (Grade grade: grades) 
			total += gradingStrategy.getGradePointsFor(grade);
		return total / grades.size();
	}
	

}
