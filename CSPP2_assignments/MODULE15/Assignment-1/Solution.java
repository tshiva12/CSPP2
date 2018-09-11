import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Main class List.
 */
public final class Solution {
    //Implement all the methods mentioned to build a ListADT
    /*
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, assume we are only going to have ints in the list
     * We need to create an array of ints to store the items
     * added to the list.
     * Create a variable of the type int[]
     * Use the private access specifier
     * Why private access specifier and why not public?
     * Well, we don't want the array to be manipulated by
     * methods that are outside the List class.
     * If you allow methods outside the List class to manipulate
     * the array then there is a possibility of having a corrupted
     * list i.e., a list with incorrect items.
     * This is not desirable and so having private access specifer
     * will protect the array such corruption.
     * This is a hard concept to understand. Discuss with your mentor.
    */
    // declare a private int[]
    // don't create the array yet using new
    // that's the job of the List constructor
    //
    /**
     * int is private.
     */
    private int[] list;
    /*
     * What are the other class variables needed for creating a list?
     * How about keeping track of the size of the list?
     * If you add 2 items to the list then the size should be 2.
     * Let's think about the size of the list by comparing it to the
     * length of the array. Do they mean the same?
     * No, Array length signifies the maximum number of items
     * you can store in the list. Whereas, the size of the list
     * denotes the number of items in the list. Makes sense?
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * The length of the array is 10 and size is 3.
     * This means you can store 10 items in the list and
     * currently it has 3 items.
     * So, to keep track of the size we need a variable called size
     * Again, we use private as we don't want that size variable
     * to be accessed by the methods that are outside of the List class.
     */
    // declare a private int size
    // again, don't initialize it here
    // variable initialization should be done in the constructor.
    /**
     * size is private.
     */
    private int size;
    /*
     * The purpose of the constructor is to initialize the
     * class variables with some default values.
     */
    /**
     * Constructs the object List.
     */
    Solution() {
        // what are the two variables to be initialized here?
        // think about the private variables described above.
        // What should be the default values?
        // In the case of the list, it should be empty but
        // it should be initialized with an array size like 10
        size = 0;
        final int num = 10;
        list = new int[num];
        // Think about the initial value for size.
        // How many items do we have in the list when you create it?
        // An empty list has how many items?
        // That is the initial value to use for size.
    }
    /*
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     * The method returns void (nothing)
     */
    /**
     * add method that add item in a list.
     *
     * @param      item  The item is a integer.
     */
    public void add(final int item) {
        //Inserts the specified element at the end of the zelist.
        if (size < list.length) {
            list[size++] = item;
        } else {
            resize(item);
        }
    }
    /*
     * Resize the list
     * Sometimes the clients of the ADT won't know the expected list capacity
     * To solve this the list has to grow dynamically
     * when the maximum capacity is reached and there is no room to add items.
     * So, how do we dynamically resize the list?
     * Java doesn't support resize of array. Here are some options.
     * Option 1
     * Create a new array of the desired size,
     * and copy the contents from the original array to the new array,
     * using java.lang.System.arraycopy(...);
     * Option 2
     * Use java.util.Arrays.copyOf(...) methods which returns a bigger array,
     * with the contents of the original array.
     * TODO
     * Create a method called resize().
     * Resize should create an new array that is
     * double the size of the old array.
     * Then copy the contents of the old array to the new one.
     * When should the resize method be invoked and from where?
     * Will the client invoke resize or is it internal to List class?
     * Should the resize be public method or private?
     * Should the resize method return any values?
     * You know enough of Object Oriented Programming
     * to answer these questions :-)
     */
    /**
     * resize gives the double size.
     *
     * @param      item  The item is integer
     */
    public void resize(final int item) {
        list = Arrays.copyOf(list, size * 2);
        list[size++] = item;
    }

    /*
     * The size method returns the value of the size.
     * The purpose of the method is to announce the size of the list
     * to the objects outside the list
     * The method returns an int. Empty list should return 0.
     */
    /**
     * size of list.
     *
     * @return     return the size value.
     */
    public int size() {
        return size;
    }
    /*
     * The remove method does what the name suggests.
     * Removes an int item, specified by the index argument, from the list
     * It also does an additional step.
     * Think about what happens when
     * an item is removed from the middle of the list
     * It creates a hole in the list, right?
     * This would mean, all the items that are
     * to the right side of the removed item should be
     * moved to the left by one position.
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * remove(1) would remove the item 2 which is at index position 1.
     * But how do you remove the item from an array?
     * Well, the way to remove it is to move all
     * the items, that are to the right of the removed item, to the left
     * So, the new array looks like this.
     * array = [1,3,0,0,0,0,0,0,0,0]
     * The method returns void (nothing)
     */
    /**
     * remove method remove the index value.
     *
     * @param      index  The index is integer.
     */
    public void remove(final int index) throws Exception {
        // write the logic for remove here.
        // Think about what to do to the size variable.
        if (index < 0) {
            throw new Exception("Invalid Position Exception");
        } else {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        }
    }
    /*
     * Get method has to return the items that is
     * at the index position passed as an argument to the method.
     * If the item doesn't exist then return a -1 to indicate that
     * there is no element at that index.
     * How can an element not be there at a given position?
     * Well, if the position is greater than the number of items
     * in the list then that would mean the item doesn't exist.
     * How do we check if the position is greater than the
     * number of items in the list? Would size variable be useful?
     */
    /**
     * get gives the index value.
     *
     * @param      index  The index is integer.
     *
     * @return     return index value.
     */
    public int get(final int index) {
        if (index < 0 && index >= size) {
            return -1;
        } else {
            return list[index];
        }
    }
    /*
     * What happens when you print an object using println?
     * Java provides a method named toString that is internally
     * invoked when an object variable is used in println.
     * For example:
     * List l = new List();
     * System.out.println(l);
     * This statement is a shortcut for
     * System.out.println(l.toString());
     * So, implement the toString method to display the items
     * in the list in the square brackets notation.
     * i.e., if the list has numbers 1, 2, 3
     * return the string [1,2,3]
     * Caution: The array may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0]
     * toString should only return the items in the list and
     * not all the elements of the array.
     */
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String str = "[";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str = str + list[i] + ",";
        }
        str = str + list[i] + "]";
        return str;
    }
    /*
     * Contains return true if the list has
     * the item passed as an argument to the method
     * So, iterate through the list and return true if
     * the item exists and otherwise false
     */
    /**
     * boolean says that item is there or not.
     *
     * @param      item  The item
     *
     * @return     return the item.
     */
    public boolean contains(final int item) {
        for (int i = 0; i < size - 1; i++) {
            if (list[i] == item) {
                return true;
            }
        }
        return false;
    }
    /*
     * Returns the index of the first occurrence
     * of the specified element in this list,
     * or -1 if this list does not contain the element.
     */
    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     return the index of item value.
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                return i;
            }
        }
        return -1;
    }
   /*Inserts all the elements of specified int
    array to the end of list*/
    /**
     * addAll add the list of items into a list.
     *
     * @param      items  The items are integer list.
     */
    public void addAll(final int[] items) {
        for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }
    }
     /*
        Inserts the specified element at the specified index
    by moving all the elements to the right.
        The method returns void (nothing)
     */
    /**
     * add method add the value of index given.
     *
     * @param      index  The index is integer.
     * @param      item   The item is integer.
     */
    // public void add(final int index, final int item) {
    //     if (index >= 0) {
    //         for (int i = size; i > index; i--) {
    //         list[i] = list[i - 1];
    //     }
    //     list[index] = item;
    //     size++;
    //     } else {
    //         System.out.println("Negative Index Exception");
    //     }
    // }
    /* Returns the count of occurances of a given item in the list*/
    /**
     * count the duplicate values in the list.
     * @param      item  The item is integer.
     *
     * @return     return the count of items.
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
    /*
     Removes all of its elements that are contained in the specified int
     array.
    */
    /**
     * Removes all.
     *
     * @param      items  The items are array Integers.
     */
    public void removeAll(final int[] items) throws Exception {
        if (items.length < list.length) {
            for (int i = 0; i < items.length; i++) {
                for (int j = 0; j < size; j++) {
                    if (items[i] == list[j]) {
                        remove(j);
                        j--;
                    }
                }            
            }
        } else {
            throw new Exception("Invalid Position Exception");
        }
        
    }
    /*
    Returns a list object containing elements, including startIndex and
    excluding endIndex. The first parameter indicates the startIndex and the
    second parameter indicates the endIndex. Returns null and print
    "Index Out of Bounds Exception" if any of values start and end are negative
    and also if start is greater than end.
    */
    /**
     * SubList method.
     *
     * @param      start  The start
     * @param      end    The end
     *
     * @return     return sublist array.
     */
    public Solution subList(final int start, final int end) throws Exception {
    // write the logic for subList
        if (start <= 0 || end < 0 || start > end
            || start > size || end > size) {
            throw new Exception("Index Out of Bounds Exception");
            // return null;
        }
        if (start == end && start > size) {
            throw new Exception("Index Out of Bounds Exception");
            // return null;
        }
        Solution list1 = new Solution();
        for (int i = start; i < end; i++) {
            list1.add(list[i]);
        }
        return list1;
    }
    /*
    Returns a boolean indicating whether the parameter i.e a List object is
    exactly matching with the given list or not.
    */
    /**
     * Equals method compare list with another.
     *
     * @param      newlist  The newlist
     *
     * @return     returns boolean value.
     */
    public boolean equals(final Solution newlist) {
    // Replace the code below
        int size1 = newlist.size;
        int f = 0;
        if (size != size1) {
            return false;
        } else {
            for (int i = 0; i < size; i++) {
                if (list[i] != newlist.get(i)) {
                    f = 1;
                }
            }
            if (f == 0) {
                return true;
            }
        return false;
        }
    }
    //     if (Arrays.equals(newlist.list, list)) {
    //         return true;
    //     }
    //     return false;
    /*
    * Removes all the elements from list
    * Think about this case and make the method
    * the simpler.
    */
    /**
     * Clear method clear all the elements in list.
     */
    public void clear() {
    // write the logic for clear.
        for (int i = 0; i < size; i++) {
            list[i] = 0;
        }
        size = 0;
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        Solution l = new Solution();

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
                case "add":
                    if (tokens.length == 2) {
                        String[] t = tokens[1].split(",");
                        if (t.length == 1) {
                            l.add(Integer.parseInt(tokens[1]));
                        }
                    }
                break;
                case "size":
                    System.out.println(l.size());
                break;
                case "print":
                    System.out.println(l);
                break;
                case "remove":
                try {
                    l.remove(Integer.parseInt(tokens[1]));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                //     if (tokens.length == 2) {
                //         l.remove(Integer.parseInt(tokens[1]));
                //     }
                // break;
                case "indexOf":
                    if (tokens.length == 2) {
                        System.out.println(l.indexOf(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "get":
                    if (tokens.length == 2) {
                        System.out.println(l.get(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "contains":
                    if (tokens.length == 2) {
                        System.out.println(l.contains(
                            Integer.parseInt(tokens[1])));
                    }
                break;
                case "count":
                System.out.println(l.count(Integer.parseInt(tokens[1])));
                break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        int[] temp = new int[t1.length];
                        for (int i = 0; i < temp.length; i++) {
                            temp[i] = Integer.parseInt(t1[i]);
                        }
                        l.addAll(temp);
                    }
                break;
                case "removeAll":
                try {
                    if (tokens.length == 2) {
                        String[] t2 = tokens[1].split(",");
                        int[] a = new int[t2.length];
                        for (int i = 0; i < t2.length; i++) {
                            a[i] = Integer.parseInt(t2[i]);
                        }
                        l.removeAll(a);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                case "subList":
                try {
                    if (tokens.length != 2) {
                        break;
                    }
                    String[] arrstring3 = tokens[1].split(",");
                    Solution object = l.subList(Integer.parseInt(arrstring3[0]),
                            Integer.parseInt(arrstring3[1]));
                    if (object != null) {
                        System.out.println(object);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                case "equals":
                    if (tokens.length == 2) {
                        String[] lt = tokens[1].split(",");
                        Solution l2 = new Solution();
                        for (int k = 0; k < lt.length; k++) {
                            l2.add(Integer.parseInt(lt[k]));
                        }
                        System.out.println(l.equals(l2));
                    }
                break;
                case "clear":
                    l.clear();
                break;
                default:
                break;
            }
        }
    }
}






