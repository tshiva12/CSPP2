import java.util.*;
import java.io.*;
class Frequency {
	public static String toString(File filename) {
		String str = "";
		try {
			Scanner scan = new Scanner(new FileReader(filename));
			StringBuilder sb = new StringBuilder();
			while(scan.hasNext()) {
				sb.append(scan.next());
				sb.append(" ");
			}
			scan.close();
			str = sb.toString();
		} catch (FileNotFoundException e) {
			System.out.println("no file");
		}
		return str;
	}
	public static Map removeAll(String text) {
		String[] word = text.replaceAll("[^a-zA-Z0-9_ ]","").toLowerCase().split(" ");
		HashMap<String, Integer> list = new HashMap<>();
		int freq = 0;
		for (int i = 0; i < word.length; i++) {
			if (!list.containsKey(word[i])) {
				list.put(word[i], 1);
			} else {
				list.put(word[i], list.get(word[i]) + 1);
			}
		}
		return list;
	}
	public static double subString(String str1, String str2) {
		int a = str1.length();
		int b = str2.length();
		double strLen1 = a + b;
		int[][] max= new int[a+1][b+1];
		int res = 0;
		double similarity = 0;
		final double hundred = 100;
		for (int i = 0; i <= a; i++) {
			for (int j = 0; j <= b; j++) {
				if (i == 0 || j == 0) {
					max[i][j] = 0;
				} else if (str1.charAt(i-1) == str2.charAt(j-1)) {
					max[i][j] = max[i-1][j-1]+1;
				} else {
					max[i][j] = 0;
				}
				if (res < max[i][j]) {
					res = max[i][j];
				}
			}
		}
		similarity = Math.round(((res * 2)/strLen1) * hundred)/hundred;
		return (similarity * hundred);
		}
}