import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
class Task {
    /**
     * private title.
     */
    private String title;
    /**
     * private assignedTo.
     */
    private String assignedTo;
    /**
     * private timeToComplete.
     */
    private int timeToComplete;
    /**
     * private important.
     */
    private boolean important;
    /**
     * private urgent.
     */
    private boolean urgent;
    /**
     * private status.
     */
    private String status;
    /**
     * Constructs the object.
     *
     * @param      title           The title
     * @param      assignedTo      The assigned to
     * @param      timeToComplete  The time to complete
     * @param      important       The important
     * @param      urgent          The urgent
     * @param      status          The status
     */
    Task(String title, String assignedTo, int timeToComplete, boolean important, boolean urgent, String status) {
        this.title = title;
        this.assignedTo = assignedTo;
        this.timeToComplete = timeToComplete;
        this.important = important;
        this.urgent = urgent;
        this.status = status;
    }
    /**
     * Gets the title.
     *
     * @return     The title.
     */
    public String getTitle() {
        return this.title;
    }
    /**
     * Gets the assignedTo.
     *
     * @return     return assigned to.
     */
    public String getassignedTo() {
        return this.assignedTo;
    }
    /**
     * Gets the time to complete the task.
     *
     * @return     return time to complete the task.
     */
    public int gettimeToComplete() {
        return this.timeToComplete;
    }

    /**
     * Gets the important.
     *
     * @return     The important.
     */
    public String getImportant() {
        String str1;
        if (this.important == true) {
            str1 = "Important";
        } else {
            str1 = "Not Important";
        }
        return str1;
    }
    /**
     * Gets the urgent.
     *
     * @return     The urgent.
     */
    public String getUrgent() {
        String str2;
        if (this.urgent == true) {
            str2 = "Urgent";
        } else {
            str2 = "Not Urgent";
        }
        return str2;
    }
    /**
     * Gets the status.
     *
     * @return     The status.
     */
    public String getStatus() {
        return this.status;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        str = getTitle() + ", " + getassignedTo() + ", " + gettimeToComplete() + ", " +
         getImportant() + ", " + getUrgent() + ", " + getStatus();
        return str;
    }
}
/**
 * Class for todoist.
 */
class Todoist {
    /**
     * private task.
     */
    private Task[] Task1;
    /**
     * Constructs the object.
     */
    Todoist() {}
    /**
     * Constructs the object.
     *
     * @param      Task1  The task 1
     */
    Todoist(Task[] Task1) {
        this.Task1 = Task1;
    }
    /**
     * Gets the task 1.
     *
     * @return     The task 1.
     */
    public Task[] getTask1() {
        return this.Task1;
    }
    /**
     * Gets the next task.
     *
     * @param      s     string s.
     *
     * @return     The next task.
     */
    public int getNextTask(String s) {
        return 0;
    }
    /**
     * Gets the next task.
     *
     * @param      s     string s.
     * @param      n     int n.
     *
     * @return     The next task.
     */
    public Task[] getNextTask(String s, int n) {
        return Task1;
    }
    /**
     * total time for completion.
     *
     * @return     return total time.
     */
    public int totalTime4Completion() {
        return 0;
    }
    /**
     * Adds a task.
     */
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
                    System.out.println(todo.totalTime4Completion());
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
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[three]);
        boolean important = tokens[four].equals("y");
        boolean urgent = tokens[five].equals("y");
        String status = tokens[six];
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
