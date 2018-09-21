import java.io.FileReader;
import java.lang.*;
import java.io.*;
import java.util.*;
/**
 * Class for plagrism.
 */
public final class Solution {
    /**
     * this is the main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        File files = new File(scan.nextLine());
        File[] testfiles = files.listFiles();
        // System.out.println(Arrays.toString(testfiles));
        // System.out.print("\t\t");
        for (File filename : testfiles) {
            System.out.print("      \t" + filename.toString().split("\\\\")[1]);

        }
        for (File each : testfiles) {
            String input1 = each.getAbsolutePath();
            // System.out.println(input1);
            System.out.println();

            System.out.print(each.toString().split("\\\\")[1] + "       \t");
            for (File next : testfiles) {  
                String input2 = next.getAbsolutePath();
                // System.out.println(input2);
                try {
                    FileReader fr1 = new FileReader(input1);
                    FileReader fr2 = new FileReader(input2);

                    BufferedReader br1 = new BufferedReader(fr1);
                    BufferedReader br2 = new BufferedReader(fr2);
                    HashMap<String, Integer> hm1 = new HashMap<>();
                    HashMap<String, Integer> hm2 = new HashMap<>();

                    String str;
                    while ((str = br1.readLine()) != null ) {
                        String [] line = str.replaceAll("[^a-zA-Z0-9_ ]", "").toLowerCase().split(" ");
                        // String[] line = str.toLowerCase().split(" ");
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
                        // System.out.println(freq);

                    }

                    while ((str = br2.readLine()) != null ) {
                        String [] str1 = str.replaceAll("[^a-zA-Z0-9_ ]", "").toLowerCase().split(" ");


                        // String [] line = str.toLowerCase().split(" ");

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
                        // System.out.println(freq2);

                    }
                    System.out.print(plagarismpercentage(hm1, hm2) + "\t");
                } catch (FileNotFoundException e) {
                    System.out.println("File not Found");

                } catch (IOException e) {
                    System.out.println("Invalid Input");

                }

            }

        }
        System.out.println();
        // String input1 = "dfghjklkhgvfcghj/fghjklkjh/";
        //String input2 = "/Users/harinathareddy/Desktop/MSIT COURSES/CSPP2_20186033/cspp2-assignments/m23/input002.txt";

    }
    /**
     * plagrism percentage calculation.
     *
     * @param      freq   The frequency
     * @param      freq2  The frequency 2
     *
     * @return     { description_of_the_return_value }
     */
    public static int plagarismpercentage(final HashMap<String, Integer> hm1,
                                   final HashMap<String, Integer> hm2) {
        int sum1 = 0 ;
        int sum2 = 0;
        int dot = 0;
        int hundred = 100;
        // System.out.println(freq + "    " + freq2);
        for (String str2 : hm1.keySet()) {
            sum1 += hm1.get(str2) * hm1.get(str2);
            // System.out.println(sum);
            sum2 += hm2.get(str2) * hm2.get(str2);
            // System.out.println(sum2);
            dot += hm1.get(str2) * hm2.get(str2);
            // System.out.println(dot);

        }
        return ((int)((dot/(Math.sqrt(sum1) * Math.sqrt(sum2))) * hundred));
    }

}
