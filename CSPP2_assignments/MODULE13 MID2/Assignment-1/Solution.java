import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : 
 */
class Set {
    //your code goes here...
    //Good luck :-)
    private int[] list;
    private int size;
    /**
     * Constructs the object.
     */
    public Set() {
    	final int num = 10;
    	list = new int[num];
    	size = 0;
    }
    /**
     * add item into a list.
     *
     * @param      item  The item
     */
    public void addval(int item) {
    	if (size >= list.length) {
    		resize();
    	}
    	list[size] = item;
    	size++;
    }
    /**
     * add an array of elements.
     *
     * @param      newArray  The new array
     */
    public void add(int[] newArray) {
    	for (int i = 0; i < newArray.length; i++) {
    		addval(newArray[i]);

    	}
    }
    /**
     * resize the size value.
     */
    public void resize() {
    	list = Arrays.copyOf(list, list.length * 2);
    }
    /**
     * contains says that item is there in list or not.
     *
     * @param      item  The item
     *
     * @return     return boolean value.
     */
    public boolean contains(int item) {
    	for (int i = 0; i < size; i++) {
    		if (list[i] == item) {
    			return true;
    		}
    	}
    	return false;
    }
    /**
     * size of list.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
    	return size;
    }

    public int[] cartesianProduct(int[] newArray1) {
    	return newArray1;
    }
    public void intersection(int[] newArray2, int[] newArray3) {
    	int[] subArray = new int[10];
    	for (int i = 0; i < newArray2.length; i++) {
    		for(int j = 0; j < newArray3.length; j++) {
    			if (newArray2[i] == newArray3[i]) {
    				addval(subArray[i]);
    			}
    		}
    	}
    }
    public void retainAll(int[] newArray3, int[] newArray4) {
    	int[] subArray1 = new int[10];
    	for (int i = 0; i < newArray3.length; i++) {
    		for(int j = 0; j < newArray4.length; j++) {
    			if (newArray3[i] == newArray4[i]) {
    				addval(subArray1[i]);
    			}
    		}
    	}
    }
    /**
     * add item at integer value.
     *
     * @param      index  The index
     * @param      item   The item
     */
    public void addval(final int index, final int item) {
        if (index >= 0) {
            for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
        } else {
            System.out.println("Negative Index Exception");
        }
    }
    /**
     * set.
     */
    public void set(){
        int[] set = new int[10];
        int siz = 0,f;
        int count;
        String st;
        for (int i = 0; i < size; i++) {
            count = count(list[i]);
            if(count == 1){
                set[siz] = list[i];
                siz++;
            }
            if(count > 1){
                f = 0;
                for(int j = 0; j < siz; j++){
                    if(set[j] == list[i]){
                        f = 1;
                    }
                }
                if(f == 0){
                    set[siz] = list[i];
                    siz++;
                }
            }
        }
        st="{";
        for(int i = 0; i < siz - 1; i++){
            st += set[i] + ", ";
        }
        st = st + set[siz-1] + "}";
        System.out.println(st);
    }
    /**
     * count of duplicate items.
     *
     * @param      item  The item
     *
     * @return     returns the count value.
     */
    public int count(final int item) {
        int count = 0;
        for (int j = 0; j < size; j++) {
            if (item == list[j]) {
                count += 1;
            }
        }
        return count;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String str = "{";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + list[i] + ", ";
        }
        str = str + list[i] + "}";
        return str;
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
                    s.addval(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                // case "intersection":
                // s = new Set();
                // Set t = new Set();
                // intArray = intArray(tokens[1]);
                // s.add(intArray);
                // intArray = intArray(tokens[2]);
                // t.add(intArray);
                // System.out.println(s.intersection(t));
                // break;
                // case "retainAll":
                // s = new Set();
                // intArray = intArray(tokens[1]);
                // s.add(intArray);
                // intArray = intArray(tokens[2]);
                // System.out.println(s.retainAll(intArray));
                // break;
                // case "cartesianProduct":
                // s = new Set();
                // t = new Set();
                // intArray = intArray(tokens[1]);
                // s.add(intArray);
                // intArray = intArray(tokens[2]);
                // t.add(intArray);
                // System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                // break;
                case "set":
                    s.set();
                break;
                default:
                break;
            }
        }
    }
}
