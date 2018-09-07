import java.io.BufferedInputStream;
import java.util.Scanner;
//A Class is implemented for Student details
/**
 * Class for student.
 */
class Student {
    /**
     * String name.
     */
    private String name;
    /**
     * Constructs the object.
     *
     * @param      newname  The name
     */
    Student(final String newname) {
    //A constructor used to initialize the instance variables
        this.name = newname;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
    //Getter method which returns the value of instance variable
        return this.name;
    }
    @Override
    public boolean equals(final Object other) {
    //This method is to check if two students names are equal or not
        if (!(other instanceof Student)) {
            return false;
        }
        Student that = (Student) other;
        return this.getName().equals(that.getName());
    }
    /**
     * hashcode function.
     * @return     returns 0.
     */
    public int hashCode() {
        return 0;
    }
    /**
     * Returns a string representation of the object.
     * @return     String representation of the object.
     */
    public String toString() {
        return this.name;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor is used.
    }
    /**
     * integer function.
     *
     * @param      stdin  The stdin
     */
    public static void executeListInteger(final Scanner stdin) {
        List<Integer> l = new List();
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
                    if (tokens.length == 2) {
                        l.remove(Integer.parseInt(tokens[1]));
                    }
                break;
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
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Integer[] temp = new Integer[t1.length];
                        for (int i = 0; i < temp.length; i++) {
                            temp[i] = Integer.parseInt(t1[i]);
                        }
                        l.addAll(temp);
                    }
                break;
                default:
                break;
            }
        }
    }
    /**
     * executedouble.
     * @param      stdin  The stdin
     */
    public static void executeListDouble(final Scanner stdin) {
        List<Double> l = new List();
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
                            l.add(Double.parseDouble(tokens[1]));
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
                    if (tokens.length == 2) {
                        l.remove(Integer.parseInt(tokens[1]));
                    }
                break;
                case "indexOf":
                    if (tokens.length == 2) {
                        System.out.println(l.indexOf(
                            Double.parseDouble(tokens[1])));
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
                            Double.parseDouble(tokens[1])));
                    }
                break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Double[] temp = new Double[t1.length];
                        for (int i = 0; i < temp.length; i++) {
                            temp[i] = Double.parseDouble(t1[i]);
                        }
                        l.addAll(temp);
                    }
                break;
                default:
                break;
            }
        }
    }
    /**
     * executefloat.
     * @param      stdin  The stdin
     */
    public static void executeListFloat(final Scanner stdin) {
        List<Float> l = new List();
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
                            l.add(Float.parseFloat(tokens[1]));
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
                    if (tokens.length == 2) {
                        l.remove(Integer.parseInt(tokens[1]));
                    }
                break;
                case "indexOf":
                    if (tokens.length == 2) {
                        System.out.println(l.indexOf(
                            Float.parseFloat(tokens[1])));
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
                            Float.parseFloat(tokens[1])));
                    }
                break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Float[] temp = new Float[t1.length];
                        for (int i = 0; i < temp.length; i++) {
                            temp[i] = Float.parseFloat(t1[i]);
                        }
                        l.addAll(temp);
                    }
                break;
                default:
                break;
            }
        }
    }
    /**
     * execute list string.
     * @param      stdin  The stdin
     */
    public static void executeListString(final Scanner stdin) {
        List<String> l = new List();
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
                            l.add(tokens[1]);
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
                    if (tokens.length == 2) {
                        l.remove(Integer.parseInt(tokens[1]));
                    }
                break;
                case "indexOf":
                    if (tokens.length == 2) {
                        System.out.println(l.indexOf((tokens[1])));
                    }
                break;
                case "get":
                    if (tokens.length == 2) {
                        System.out.println(l.get(Integer.parseInt(tokens[1])));
                    }
                break;
                case "contains":
                    if (tokens.length == 2) {
                        System.out.println(l.contains((tokens[1])));
                    }
                break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        l.addAll(t1);
                    }
                break;
                default:
                break;
            }
        }
    }
    /**
     * executelist.
     *
     * @param      stdin  The stdin
     */
    public static void executeListStudent(final Scanner stdin) {
        List<Student> l = new List();
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
                            l.add(new Student(tokens[1]));
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
                    if (tokens.length == 2) {
                        l.remove(Integer.parseInt(tokens[1]));
                    }
                break;
                case "indexOf":
                    if (tokens.length == 2) {
                        System.out.println(l.indexOf(new Student(tokens[1])));
                    }
                break;
                case "get":
                    if (tokens.length == 2) {
                        System.out.println(l.get(Integer.parseInt(tokens[1])));
                    }
                break;
                case "contains":
                    if (tokens.length == 2) {
                        System.out.println(l.contains(new Student(tokens[1])));
                    }
                break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Student[] students = new Student[t1.length];
                        for (int i = 0; i < t1.length; i++) {
                            students[i] = new Student(t1[i]);
                        }
                        l.addAll(students);
                    }
                break;
                default:
                break;
            }
        }
    }
    /**
     * main function.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        String objectType = stdin.nextLine();
        switch (objectType) {
            case "S":
            //This case will be executed for String type list
                executeListString(stdin);
            break;
            case "I":
            //This case will be executed for Integer type list
                executeListInteger(stdin);
            break;
            case "F":
            //This case will be executed for Float type list
                executeListFloat(stdin);
            break;
            case "C":
            //This case will be executed for Character type list
                executeListString(stdin);
            break;
            case "D":
            //This case will be executed for Double type list
                executeListDouble(stdin);
            break;
            case "O":
            //This case will be executed for Student type
            // list i.e to store List of Student Objects
                executeListStudent(stdin);
                break;
            default:
            break;
        }
    }
}






