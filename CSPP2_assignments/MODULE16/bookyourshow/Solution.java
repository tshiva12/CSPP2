import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for show.
 * @author     Prasanth...
 */
class BookYourShow {
    /**
     * Patron object.
     */
    private Patron[] patrons;
    /**.
     * Show class Object
     */
    private Show[] shows;
    /**
     * patrons size.
     */
    private int patronSize;
    /**
     * show size.
     */
    private int showSize;
    /**
     * integer variable.
    */
    private static final int TEN = 10;
    /**
     * Constructs the object.
     */
    protected BookYourShow() {
        this.shows = new Show[TEN];
        this.patrons = new Patron[TEN];
        this.patronSize = 0;
        this.showSize = 0;
    }

    /**.
     * { function_description }
     */
    public void showResize() {
        shows = Arrays.copyOf(shows, shows.length * 2);
        // patrons = Arrays.copyOf(patrons, patrons.length * 2);
    }
    /**
     * resize function for patrons.
     */
    public void patronResize() {
        // shows = Arrays.copyOf(shows, shows.length * 2);
        patrons = Arrays.copyOf(patrons, patrons.length * 2);
    }

    /**
     * Adds a show.
     *
     * @param      newShow  The new show
     */
    public void addAShow(final Show newShow) {
        if (showSize == shows.length) {
            showResize();
        }
        shows[showSize++] = newShow;
    }
    /**
     * Adds a patron.
     *
     * @param      newpatron  The newpatron
     */
    public void addAPatron(final Patron newpatron) {
        if (patronSize > patrons.length) {
            patronResize();
        }
        patrons[patronSize++] = newpatron;
    }

    /**
     * Gets a show.
     *
     * @param      moviname  The moviname
     * @param      datetime  The datetime
     *
     * @return     A show.
     */
    public Show getAShow(final String moviname, final String datetime) {
        for (int i = 0; i < showSize; i++) {
            if (shows[i].getMovieName().equals(moviname)
                && shows[i].getDate().equals(datetime)) {
                    return shows[i];
            }
        }
        return null;
    }

    /**
     * to book a show.
     *
     * @param      moviename  The moviename
     * @param      datetime   The datetime
     * @param      p          { parameter_description }
     */
    public void bookAShow(final String moviename,
        final String datetime, final Patron p) {
        addAPatron(p);
        Show avaiableShow = getAShow(moviename, datetime);
        if (avaiableShow != null) {
            String[] seats = avaiableShow.getSeats();
            String[] bookedSeats = p.getBookedSeats();
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < bookedSeats.length; j++) {
                    if (seats[i].equals(bookedSeats[j])
                        && !seats[i].equals("N/A")) {
                        seats[i] = "N/A";
                    }
                }
            }
        } else {
            System.out.println("No show");
        }
    }
    /**
     * Shows all.
     */
    public void showAll() {
        for (int i = 0; i < showSize; i++) {
            System.out.println(shows[i]);
        }
    }
    /**.
     * { function_description }
     *
     * @param      moviename     The moviename
     * @param      datetime      The datetime
     * @param      mobilenumber  The mobilenumber
     */
    public void printTicket(final String moviename,
        final String datetime, final String mobilenumber) {
        Show show = getAShow(moviename, datetime);
        if (show != null) {
            for (int i = 0; i < patronSize; i++) {
                if (patrons[i].getNum().equals(mobilenumber)) {
                    System.out.println(mobilenumber + " "
                        + moviename + " " + datetime);
                    return;
                }
            }
            System.out.println("Invalid");
        } else {
            System.out.println("Invalid");
        }
    }
}
/**
 * Class for show.
 */
class Show {
    /**
     * var for moviename.
     */
    private String movieName;
    /**
     * var for movietime.
     */
    private String movieTime;
    /**
     * var for seats.
     */
    private String[] seats;
    /**
     * Constructs the object for show class.
     *
     * @param      mname   The mname
     * @param      mtime   The mtime
     * @param      nseats  The nseats
     */
    Show(final String mname, final String mtime, final String[] nseats) {
        this.movieName = mname;
        this.movieTime = mtime;
        this.seats = nseats;
    }
    /**
     * Gets the movie name.
     *
     * @return     The movie name.
     */
    public String getMovieName() {
        return this.movieName;
    }
    /**
     * Gets the date.
     *
     * @return     The date.
     */
    public String getDate() {
        return this.movieTime;
    }
    /**
     * Gets the seats.
     *
     * @return     The seats.
     */
    public String[] getSeats() {
        return this.seats;
    }
    /**
     * function for except tickets.
     *
     * @return     { description_of_the_return_value }
     */
    public String ExceptTickets() {
        String s = "";
        s += movieName + "," + movieTime;
        return s;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        s += movieName + "," + movieTime + ",";
        s += Arrays.toString(seats).replace(", ",",");
        return s;
    }
}

/**
 * Class for patron.
 */
class Patron {
    /**
     * var custmoername.
     */
    private String customerName;
    /**
     * var phonenum.
     */
    private String phoneNumber;
    /**
     * var booking seats.
     */
    private String[] bookedSeats;
    /**
     * Constructs the object for Patron class.
     *
     * @param      cname     The cname
     * @param      phonenum  The phonenum
     * @param      bseats    The bseats
     */
    Patron(final String cname,
        final String phonenum, String[] bseats) {
        this.customerName = cname;
        this.phoneNumber = phonenum;
        this.bookedSeats = bseats;
    }
    /**
     * Gets the cname.
     *
     * @return     The cname.
     */
    public String getCname() {
        return this.customerName;
    }
    /**
     * Gets the number.
     *
     * @return     The number.
     */
    public String getNum() {
        return this.phoneNumber;
    }
    /**
     * Gets the booked seats.
     *
     * @return     The booked seats.
     */
    public String[] getBookedSeats() {
        return this.bookedSeats;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        return s;
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

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
                case "add":
                    int k = 2;
                    String[] seats = new String[tokens.length - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

                case "book":
                    k = 2 + 2;
                    seats = new String[tokens.length - 2 - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.bookAShow(check[1], tokens[1],
                        new Patron(tokens[2], tokens[2 + 1], seats));
                break;

                case "get":
                    Show show = bys.getAShow(check[1], tokens[1]);
                    if (show != null) {
                       System.out.println(show.ExceptTickets());
                    } else {
                        System.out.println("No show");
                    }
                break;

                case "print":
                    bys.printTicket(check[1], tokens[1], tokens[2]);
                break;

                case "showAll":
                    bys.showAll();
                break;

                default:
                break;
            }
        }
    }
}
