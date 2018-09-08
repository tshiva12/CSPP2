import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author :
 */
class Set {
    //your code goes here...
    //Good luck :-).
    /**
    declaring an int array.
    **/
    private int[] set;
    /**
     * var_description.
     **/
    private int size;
    /**
     * Constructs the object.
     **/

    /**
     * Constructs the object.
     **/
    Set() {
        final int num = 10;
        set = new int[num];
        size = 0;
    }
    /**
     * Constructs the object.
     *
     * @param      cap   The capability
     **/
    Set(final int cap) {
        set = new int[cap];
        size = 0;
    }
    /**
     * Constructs the object.
     *
     * @param      elements  The elements
     **/
    Set(final int[] elements) {
    this.set = new int[elements.length];
    for (int pos = 0; pos < elements.length; pos++) {
        this.set[pos] = elements[pos];
    }
}
    /**
     * function_description.
     **/
    private void resize() {
        int cap = 2 * size;
        set = Arrays.copyOf(set, cap);
    }

    /**
     * function_description.
     *
     * @param      item  The item
     **/
    public void add(final int item) {
        int flag = 0;
        if (size == set.length) {
            resize();
        }
        if (contains(item)) {
            flag = 0;
        } else {
            set[size++] = item;
        }
    }

    /**
     * function_description.
     *
     * @return     { description_of_the_return_value }
     **/
    public int size() {
        return size;
    }
    /**
     * function_description.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     **/
    public boolean contains(final int item) {
        // return true;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                count++;
            }
        }
        if (count == 1) {
            return true;
        }
        return false;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     **/
    public String toString() {
        // return "string";
        if (size == 0) {
            return "{}";
        }
       String res = "{";
        for (int i = 0; i < size - 1; i++) {
            res = res + set[i] + ", ";
        }
        res += set[size - 1] + "}";
        return res;
    }
    /**
     * function_description.
     *
     * @param      item  The item
     */
    public void add(final int[] item) {
        // int len = set.length + size;
     //    int temp = 0;
     //    for (int i = size; i < len; i++) {
     //        if (size == set.length) {
     //        resize();
     //    }
     //    set[i] = item[temp];
     //    temp += 1;
     //    size += 1;
     //    }
        for (int i:item) {
            add(i);
    }
    }
    /**
     * function_description.
     *
     * @param      a     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     **/
    public String intersection(final Set a) {
        int members = 0;
        int x = 0;
        for (int i = 0; i < set.length; i++) {
        if (a.contains(set[i])) {
            members++;
        }
        }
        // System.out.println(members);
        int[] newMembers = new int[members];
        int position = 0;
        for (int i = 0; i < set.length; i++) {
        if (a.contains(set[i])) {
            // System.out.println(set[i]);
            x = set[i];
            newMembers[position++] = set[i];
        }
    }
    int n = newMembers.length;
    if (n == 0) {
        System.out.print("{}");
    } else {
        System.out.print("{");
        for (int p = 0; p < n - 1; p++) {
            System.out.print(newMembers[p] + ", ");
        }
        System.out.print(newMembers[n - 1] + "}");
    }
    // return new Set(newMembers);
        return "";
    }
    /**
     * function_description.
     *
     * @param      a  The item
     *
     * @return     { description_of_the_return_value }
     */
    public String retainAll(final int[] a) {
        return null;
    }
    /**
     * function_description.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int[][] cartesianProduct(final Set item) {
        return null;
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
