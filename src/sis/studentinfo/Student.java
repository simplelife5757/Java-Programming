package sis.studentinfo;
	
public class Student {
	static final int CREDITS_REQUIRED_FOR_FULL_TIME = 12;
	private String name; //������ �ʵ��� �θ���. private�� �ܺο��� ���� ������ ���ǵ帮�� �Ѵ�. 
	private int credits;
	
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

}
