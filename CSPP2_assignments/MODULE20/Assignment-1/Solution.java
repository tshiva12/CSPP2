import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
    /**
     * question text is private.
     */
    private String questiontext;
    /**
     * choces is private.
     */
    private String[] choices;
    /**
     * correct answer is private.
     */
    private int correctAnswer;
    /**
     * maxmarks is private.
     */
    private int maxMarks;
    /**
     * penalty is private.
     */
    private int penalty;
    /**
     * response is private.
     */
    private String response;
    /**
     * Constructs the object.
     */
    Question() {

    }
    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
        final int correctAnswer1, final int maxMarks1, final int penalty1) {
        this.questiontext = question1;
        this.choices = choices1;
        this.correctAnswer = correctAnswer1;
        this.maxMarks = maxMarks1;
        this.penalty = penalty1; 

    }
    /**
     * evaluateResponse is a boolean function.
     *
     * @param      choice  The choice
     *
     * @return     return a boolean value.
     */
    public boolean evaluateResponse(final String choice) {
        if (choice.equals(choices[correctAnswer - 1])) {
            return true;
        }
        return false;
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public int getCorrectAnswer() {
        return this.correctAnswer;
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return this.questiontext;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return this.choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return this.maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return this.penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        this.response = answer;
    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return this.response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        for (int i = 0; i < choices.length - 1; i++ ) {
            s += choices[i] + "\t";
        }
        s += choices[choices.length - 1];
        return s;
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * onehundred is a private.
     */
    private final int onehundred = 100;
    /**
     * questions is private.
     */
    private Question[] questions;
    /**
     * size is private.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Quiz() {
        questions = new Question[onehundred];
        size = 0;
    }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
        questions[size++] = q;
    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        return questions[index];
    }
    /**
     * Shows the report.
     *
     * @return     return a string.
     */
    public String showReport() {
        String s = "";
        int result = 0;
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                System.out.println(questions[i].getQuestionText());
                if (questions[i].evaluateResponse(questions[i].getResponse())) {
                    System.out.println(" Correct Answer! - Marks Awarded: "
                    + questions[i].getMaxMarks());
                    result = result + questions[i].getMaxMarks();
                } else {
                    System.out.println(" Wrong Answer! - Penalty: "
                    + questions[i].getPenalty());
                    result = result + questions[i].getPenalty();
                }
            }
            return "Total Score: " + result;
        } else {
             return s;
        }
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
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        final int five = 5;
        final int four = 4;
        final int two = 2;
        final int three = 3;
        if (q == 0) {
            System.out.println("Quiz does not have questions");
        } else {
            for (int i = 0; i < q; i++) {
                String[] ip = scan.nextLine().split(":");
                String[] choices = ip[1].split(",");
                if (ip.length != five  || ip[0].length() == 0) {
                    System.out.println("Error! Malformed question");
                    return;
                } else if (choices.length < two) {
                    System.out.println(ip[0]
                        + " does not have enough answer choices");
                    return;
                } else if (Integer.parseInt(ip[two]) > choices.length) {
                    System.out.println(
                        "Error! Correct answer choice number is out of range for "
                        + ip[0]);
                    return;
                } else if (!(Integer.parseInt(ip[three]) > 0)) {
                    System.out.println("Invalid max marks for " + ip[0]);
                    return;
                } else if(!(Integer.parseInt(ip[four]) <= 0)) {
                    System.out.println("Invalid penalty for " + ip[0]);
                    return;
                } else {
                    Question question1 = new Question(ip[0], choices,
                    Integer.parseInt(ip[two]), Integer.parseInt(ip[three]),
                    Integer.parseInt(ip[four]));
                    quiz.addQuestion(question1);
                }
            }
            System.out.println(q + " are added to the quiz");
        }
    }
    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        try {
            String answer1;
            for (int i = 0; i < q; i++) {
                Question question_no = quiz.getQuestion(i);
                System.out.println(question_no.getQuestionText() + "(" + question_no.getMaxMarks() + ")");
                System.out.println(question_no.toString());
                System.out.println("");
                answer1 = scan.nextLine();
                question_no.setResponse(answer1);
            }
        } catch (Exception e) {
            return;
        }
    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        System.out.println(quiz.showReport());
    }
}
