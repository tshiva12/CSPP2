import java.util.Scanner;
public class Solution {
	/* Fill the main function to print resultant of addition of matrices*/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int rows = s.nextInt();
		int cols = s.nextInt();
		int a[][] = new int[rows][cols];
		int b[][] = new int[rows][cols];
		int sum[][] = new int[rows][cols];
		int c = 0;
		int d = 0;
		for (c=0;c<rows;c++) {
			for (d=0;d<cols;d++) {
				a[c][d] = s.nextInt();
			}
		}
		for (c=0;c<rows;c++) {
			for (d=0;d<cols;d++) {
				b[c][d] = s.nextInt();
			}
		}
		for (c=0;c<rows;c++) {
			for (d=0;d<cols;d++) {
				sum[c][d] = a[c][d] + b[c][d];
			}
		}
		for (c=0;c<rows;c++) {
			for (d=0;d<cols;d++) {
				System.out.print(sum[c][d]+" ");
				System.out.println( );
			}
		}
	}
}