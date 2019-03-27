package sis.studentinfo;
import java.util.*;
	
public class Student {
	public enum Grade {
		A(4),
		B(3),
		C(2),
		D(1),
		F(0);
		
		private int points;
		
		Grade(int points){
			this.points = points;
		}
		
		int getPoints() {
			return points;
		}
		};
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	static final String IN_STATE = "CO";
	private String name; //������ �ʵ��� �θ���. private�� �ܺο��� ���� ������ ���ǵ帮�� �Ѵ�. 
	private int credits;
	private String state = "";
	private ArrayList<Grade> grades = new ArrayList<Grade>();
	private GradingStrategy gradingStrategy = new BasicGradingStrategy();
	private String firstName = "";
	private String middleName = "";
	private String lastName;
	
	void setGradingStrategy(GradingStrategy gradingStrategy) {
		this.gradingStrategy = gradingStrategy;
	}
	
	
	public Student(String fullName) {
		this.name = fullName; //this�� ���� �ڵ带 �����ϰ� �ִ� ��ü�� ���� ��ü�� ���� ���۷����� �ǹ��Ѵ�.
		// �����ڴ� Ŭ���� �̸��� ���ƾ� �ϰ� �ٸ� ��ü�� �μ��� �����ڿ� �����ϴ� ���� �̿��Ͽ� ��ü�� �ʱ�ȭ �ϱ� ���� ����Ѵ�.
		credits = 0;
		List<String> nameParts = split(fullName);
		setName(nameParts);
	}

	private List<String> tokenize(String string) {
		List<String> results = new ArrayList<String>();
		
		StringBuffer word = new StringBuffer();
		int index = 0;
		while (index < string.length()) {
			char ch = string.charAt(index);
			if (ch != ' ') // prefer Character.isSpace. Defined yet?
				word.append(ch);
			else
				if (word.length() > 0) {
					results.add(word.toString());
					word = new StringBuffer();
				}
			index++;
		}
		if (word.length() > 0)
			results.add(word.toString());
		return results;
	}

	private List<String> split(String fullName) {
		// TODO Auto-generated method stub
		return null;
	}


	private void setName(List<String> nameParts) {
		if (nameParts.size() == 1)
			this.lastName = nameParts.get(0);
		else if (nameParts.size() == 2) {
			this.firstName = nameParts.get(0);
			this.lastName = nameParts.get(0);
		}
		else if (nameParts.size() == 3) {
			this.firstName = nameParts.get(0);
			this.lastName = nameParts.get(2);
			this.middleName = nameParts.get(1);
		}
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

	public String getFirstName() {
		return firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}


}
