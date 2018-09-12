import java.util.Scanner;
class Show {
	public String moviename;
	public String date;
	public String[] seatnumbers;
	// public Show() {}
	public Show(String moviename, String date, String[] seatnumbers) {
		this.moviename = moviename;
		this.date = date;
		this.seatnumbers = seatnumbers;
	}
}
class Patron {
	public String name;
	public String phonenumber;
	public Patron(String name, String phonenumber) {
		this.name = name;
		this.phonenumber = phonenumber;
	}
}
class BookYourShow {
	public Show[] allshows;
	public int allshowscount;
	public Patron[] allpatrons;
	public int allpatronscount;
	public BookYourShow() {
		allshows = new Show[10];
		allshowscount = 0;
		allpatrons = new Patron[10];
		allpatronscount = 0;
	}
	public void addAShow(Show show) {
		allshows[allshowscount++] = show;
	}
	public Show getAShow(String moviename, String date) {
		for (int i = 0; i < allshowscount; i++) {
			if (allshows[i].moviename.equals(moviename) && allshows[i].date.equals(date)) {
				return allshows[i];
			}
			
		}
		return null;
	}
	public void bookAShow(String moviename, String date, Patron pat, String[] seatnumbers) {
		Show checkshow = getAShow(moviename, date);
		int flag = 0;
		if(allshowscount == 0) {
			System.out.println("No show");
		} else {
			if (checkshow != null) {
				for (int i = 0; i < seatnumbers.length; i++) {
					for (int j = 0; j < checkshow.seatnumbers.length; j++) {
						if(seatnumbers[i].equals(checkshow.seatnumbers[j])) {
							checkshow.seatnumbers[j] = "N/A";
							flag = 1;
						}
					}
				}
				for (int z = 0;z < allshowscount; z++) {
					if(allshows[z].moviename.equals(checkshow.moviename) && allshows[z].date.equals(checkshow.date)) {
						allshows[z] = checkshow;
					}
				}
				if (flag == 1) {
					allpatrons[allpatronscount++] = pat;
				}
			} else {
				System.out.println("No show");
			}
		}
	}
	public void printTicket(String moviename, String date ,String phonenumber) {
		Show checkshow = getAShow(moviename, date);
		if (checkshow != null) {
			int flag = 0;
			for (int i = 0; i < allpatronscount; i++) {
				if (allpatrons[i].phonenumber.equals(phonenumber)) {
					flag = 1;
					break;
				}
			}
			if(flag == 1) {
				System.out.println(phonenumber + " " + moviename + " " + date);
			} else {
				System.out.println("Invalid");
			}
		} else {
			System.out.println("Invalid");
		}

	}
	public void showAll() {
		for (int i = 0; i < allshowscount; i++) {
			String str1 = allshows[i].moviename + "," + allshows[i].date + ",";
			// System.out.println(allshows[i]);
			String remainingseats = "[";
			for (int j = 0; j < allshows[i].seatnumbers.length; j++) {
				remainingseats += allshows[i].seatnumbers[j];
				if (j < allshows[i].seatnumbers.length - 1) {
					remainingseats += ",";
				}
			}
			remainingseats += "]";
			str1 += remainingseats;
			System.out.println(str1);
		}
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
                        new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

                case "get":
                    Show show = bys.getAShow(check[1], tokens[1]);
                    if (show != null) {
                       System.out.println(show.moviename + "," + show.date);
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
