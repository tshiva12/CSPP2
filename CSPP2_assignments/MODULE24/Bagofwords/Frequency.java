import java.util.*;
import java.io.*;
class Frequency {
	Frequency() {
	}
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
	public static int similarity(String str1, String str2) {
		double numer = 0;
		double s1 = 0;
		double s2 = 0;
		final int hundred = 100;
		Map<String, Integer> list1 = removeAll(str1);
		Map<String, Integer> list2 = removeAll(str2);
		for (String i:list1.keySet()) {
			for (String j:list2.keySet()) {
				if (i.equals(j)){
					numer += list1.get(i)*list2.get(j);
				}
			}
		}
		for (String i:list1.keySet()) {
			s1 += Math.pow(list1.get(i), 2);
		}
		for (String j:list2.keySet()) {
			s2 += Math.pow(list2.get(j), 2);
		}
		double denom = Math.sqrt(s1) * Math.sqrt(s2);
		return (int)((((numer/ denom) * hundred) / hundred) * hundred);
	}
}