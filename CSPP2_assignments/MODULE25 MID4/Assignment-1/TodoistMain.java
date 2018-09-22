import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
class Task {
    private String title;
    private String assignedTo;
    private int timeToComplete;
    private boolean important;
    private boolean urgent;
    private String status;
    Task(String title, String assignedTo, int timeToComplete, boolean important, boolean urgent, String status) {
        this.title = title;
        this.assignedTo = assignedTo;
        this.timeToComplete = timeToComplete;
        this.important = important;
        this.urgent = urgent;
        this.status = status;
    }
    public String getTitle() {
        return this.title;
    }
    public String getassignedTo() {
        return this.assignedTo;
    }
    public int gettimeToComplete() {
        return this.timeToComplete;
    }
    public String getImportant() {
        String str1;
        if (this.important == true) {
            str1 = "Important";
        } else {
            str1 = "Not Important";
        }
        return str1;
    }
    public String getUrgent() {
        String str2;
        if (this.urgent == true) {
            str2 = "Urgent";
        } else {
            str2 = "Not Urgent";
        }
        return str2;
    }
    public String getStatus() {
        return this.status;
    }
    public String toString() {
        String str = "";
        str = getTitle() + ", " + getassignedTo() + ", " + gettimeToComplete() + ", " +
         getImportant() + ", " + getUrgent() + ", " + getStatus();
        return str;
    }
}
class Todoist {
    private Task[] Task1;
    Todoist() {}
    Todoist(Task[] Task1) {
        this.Task1 = Task1;
    }
    public Task[] getTask1() {
        return this.Task1;
    }
    public int getNextTask(String s) {
        return 0;
    }
    public Task[] getNextTask(String s, int n) {
        return Task1;
    }
    public int totalTime4Completion(String s, int n) {
        return 0;
    }
    public void addTask() {

    }
}
/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    System.out.println(todo);
                break;
                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    Task[] tasks = todo.getNextTask(tokens[1], n);
                    System.out.println(Arrays.deepToString(tasks));
                break;
                case "total-time":
                    // System.out.println(todo.totalTime4Completion());
                break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            // todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
