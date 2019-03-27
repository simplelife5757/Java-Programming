package sis.studentinfo;

public class HonorsGradingStrategy extends BasicGradingStrategy {
	public int getGradePointsFor(Student.Grade grade) {// 학점을 넣었을 때 점수(point)가 나올 수 있도록 
		int points = super.getGradePointsFor(grade);
		if (points > 0) {
			points += 1;
		}
		return points;
	}
}
