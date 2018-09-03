import java.util.Scanner;
public class StudentDetails {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		String rollnumber = s.nextLine();
		double marks1 = s.nextDouble();
		double marks2 = s.nextDouble();
		double marks3 = s.nextDouble();
		Student s1 = new Student(name, rollnumber, marks1, marks2, marks3); 
	}
}
class Student {
	String name;
	String rollnumber;
	double marks1,marks2,marks3;
	public Student(String name, String roll, double m1, double m2, double m3) {
		this.name = name;
		this.rollnumber = roll;
		this.marks1 = m1;
		this.marks2 = m2;
		this.marks3 = m3;
		double average = (m1 + m2 + m3)/3;
		System.out.println(average);
	}
}