import java.util.Scanner;
public class Average {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int n[] = new int[num];
		float avg = 0;
		// a = s.nextInt();
		for (int i=0;i<num;i++) {
			System.out.println("Enter a number");
			n[i] = s.nextInt();
			avg += n[i];
		}
		System.out.println(avg/num);
	}
}