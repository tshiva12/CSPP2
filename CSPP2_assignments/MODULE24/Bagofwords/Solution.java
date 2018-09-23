import java.util.*;
import java.io.*;
public final class Solution {
	public static void main(String[] args) {
		try {
		Frequency f = new Frequency();
		Scanner sc = new Scanner(System.in);
		File fileinput = new File(sc.next());
		File[] filelist = fileinput.listFiles();
		int max = 0;
		String res = "";
		int len1 = filelist.length;
		int[][] result = new int[len1][len1];
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len1; j++) {
				if (i == j) {
					result[i][j] = 100;
				} else {
					result[i][j] = Frequency.similarity(Frequency.toString(filelist[i]),Frequency.toString(filelist[j]));
				}
				if (max < result[i][j]) {
					max = result[i][j];
					res = "Maximum similarity is in between " + filelist[i].getName() + " and " + filelist[j].getName();
				}
			}
		}
		System.out.print("      \t");
		for (int i = 0; i < len1; i++) {
			System.out.print("\t" + filelist[i].getName());
		}
		System.out.println();
		for (int i = 0; i < len1; i++) {
			System.out.print(filelist[i].getName() + "\t");
			for (int j = 0; j < len1; j++) {
				System.out.print(result[i][j] + "\t\t");
			}
			System.out.println();
		}
		System.out.println(res);
		} catch (NoSuchElementException e) {
		System.out.println("empty directory");
		}
	}
}