package sis.studentinfo;
import java.util.*;
	
public class Student {
	enum Grade { A, B, C, D, F};
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final String IN_STATE = "CO";
	private String name; //변수를 필드라고도 부른다. private은 외부에서 직접 변수를 못건드리게 한다. 
	private int credits;
	private String state = "";
	private ArrayList<Grade> grades = new ArrayList<Grade>();
	private GradingStrategy gradingStrategy = new RegularGradingStrategy();
	
	void setGradingStrategy(GradingStrategy gradingStrategy) {
		this.gradingStrategy = gradingStrategy;
	}
	
	public Student(String name) {
		this.name = name; //this는 현재 코드를 수행하고 있는 객체인 현재 객체에 대한 레퍼런스를 의미한다.
		// 생성자는 클래스 이름과 같아야 하고 다른 객체가 인수로 생성자에 전달하는 값을 이용하여 개체를 초기화 하기 위해 사용한다.
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
