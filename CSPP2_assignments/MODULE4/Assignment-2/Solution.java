import java.util.Scanner;
public class Solution {
	/* Fill the main function to print resultant of addition of matrices*/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int rowsA = s.nextInt();
		int colsA = s.nextInt();
		int sum[][] = new int[rowsA][colsA];
		int a[][] = new int[rowsA][colsA];
		for (int c=0;c<rowsA;c++) {
			for (int d=0;d<colsA;d++) {
				a[c][d] = s.nextInt();
			}
		}
		int rowsB = s.nextInt();
		int colsB = s.nextInt();
		int b[][] = new int[rowsB][colsB];
		for (int c=0;c<rowsB;c++) {
			for (int d=0;d<colsB;d++) {
				b[c][d] = s.nextInt();
			}
		}
		if(rowsA == rowsB && colsA == colsB) {
			for (int c=0;c<rowsA;c++) {
				for (int d=0;d<colsA;d++) {
					sum[c][d] = a[c][d] + b[c][d];
					System.out.print(sum[c][d]+" ");
					System.out.println( );
				}
			}

		}
		else {
			System.out.println("not possible");
		}
	}
}