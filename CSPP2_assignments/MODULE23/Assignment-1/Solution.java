import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Class for plagrism.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //default constructor.
    }
    /**
     * this is the main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            File files = new File(scan.nextLine());
            File[] testfiles = files.listFiles();
            for (File filename : testfiles) {
                System.out.print("      \t"
                 + filename.toString().split("\\\\")[1]);
            }
            for (File each : testfiles) {
                String input1 = each.getAbsolutePath();
                System.out.println();
                System.out.print(each.toString().split("\\\\")[1]
                 + "       \t");
                for (File next : testfiles) {
                    String input2 = next.getAbsolutePath();
                    FileReader fr1 = new FileReader(input1);
                    FileReader fr2 = new FileReader(input2);
                    BufferedReader br1 = new BufferedReader(fr1);
                    BufferedReader br2 = new BufferedReader(fr2);
                    HashMap<String, Integer> hm1 = new HashMap<>();
                    HashMap<String, Integer> hm2 = new HashMap<>();
                    String str;
                    while ((str = br1.readLine()) != null) {
                        String[] line = str.replaceAll(
                           "[^a-zA-Z0-9_ ]", "").toLowerCase().split(" ");
                        for (String word : line) {
                            if (hm1.containsKey(word)) {
                            hm1.put(word, hm1.get(word) + 1);
                            } else {
                                hm1.put(word, 1);
                            }
                            if (!hm2.containsKey(word)) {
                                hm2.put(word, 0);
                            }
                        }
                    }
                    while ((str = br2.readLine()) != null) {
                        String[] str1 = str.replaceAll(
                            "[^a-zA-Z0-9_ ]", "").toLowerCase().split(" ");
                        for (String word : str1) {
                            if (hm2.containsKey(word)) {
                                hm2.put(word, hm2.get(word) + 1);
                            } else {
                                hm2.put(word, 1);
                            }
                            if (!hm1.containsKey(word)) {
                                hm1.put(word, 0);
                            }
                        }
                    }
                    System.out.print(plagarismpercentage(hm1, hm2) + "\t");
                }
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("empty directory");
        }
    }
    /**
     * plagrism percentage calculation.
     *
     * @param      hm1   The hm 1
     * @param      hm2   The hm 2
     * @return     return the plagarism percentage.
     */
    public static int plagarismpercentage(final HashMap<String, Integer> hm1,
                                   final HashMap<String, Integer> hm2) {
        int sum1 = 0;
        int sum2 = 0;
        int dot = 0;
        final int hundred = 100;
        for (String str2 : hm1.keySet()) {
            sum1 += hm1.get(str2) * hm1.get(str2);
            sum2 += hm2.get(str2) * hm2.get(str2);
            dot += hm1.get(str2) * hm2.get(str2);
        }
        return ((int) ((dot) / (Math.sqrt(sum1) * Math.sqrt(sum2)) * hundred));
    }

}



