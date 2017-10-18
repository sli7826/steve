package classwork;

import java.lang.reflect.Array;

public class Student extends Person {
	public static final String[] grades= {"Freshman","Sophmore","Junior","Senior","Super Senior"};
	private String grade;
	public Student(String first, String last, Borough home,int gradeLevel) {
		super(first, last, home);
		int index=gradeLevel-9;
		this.grade=grades[index];
	}
	public String toString() {
		return super.toString()+" I am also a "+grade+".";
	}
}
