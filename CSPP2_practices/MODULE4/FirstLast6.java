import java.util.Scanner;
public class FirstLast6 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int n[] = new int[num];
		// a = s.nextInt();
		for (int i=0;i<num;i++) {
			System.out.println("Enter a number");
			n[i] = s.nextInt();
		}
		int dup = n.length;
		if (n[0] == 6 || n[num-1] == 6) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
	}
}