import java.util.Scanner;
class Log {
    private Foodlog[] foodlog;
    private Waterlog[] waterlog;
    private Activity[] act;
    private Weight[] weigh;
    private Sleep[] sleep;
    private int foodsize, watersize, actsize, weightsize, sleepsize;
    private final int ten = 10;

    Log() {
        foodlog = new Foodlog[ten];
        waterlog = new Waterlog[ten];
        act = new Activity[ten];
        weigh = new Weight[ten];
        sleep = new Sleep[ten];
        foodsize = 0;
        watersize = 0;
        actsize = 0;
        weightsize = 0;
        sleepsize = 0;
    }

    public void Food(String fooditem, String quantity, String date, String time) {
        Foodlog f = new Foodlog(fooditem, quantity, date, time);
        foodlog[foodsize++] = f;
    }

    public void Water(int consumed) {
        Waterlog w = new Waterlog(consumed);
        waterlog[watersize++] = w;
    }

    public void PhysicalActivity(String name, String date, String starttime, String endtime, String notes) {
        Activity a = new Activity(name, date, starttime, endtime, notes);
        act[actsize++] = a;
    }

    public void Weight(double weight, double fat, String date) {
        Weight w = new Weight(weight, fat, date);
        weigh[weightsize++] = w;
    }

    public void Sleep(int begin, int end) {
        Sleep s = new Sleep(begin, end);
        sleep[sleepsize++] = s; 
    }
    public void printdetails() {

        for (int i = 0; i < foodsize; i++) {
            System.out.println(foodlog[i].getFoodItem() + "\n" + foodlog[i].getQuantity() + "\n" + foodlog[i].getDate() + "\n" + foodlog[i].getTime());
        }

        for (int j = 0; j < watersize; j++) {
            System.out.println(waterlog[j].getConsumption() + "ml");
        }

        for (int k = 0; k < actsize; k++) {
            System.out.println(act[k].getName() + "\n" + act[k].getDate() + "\n" + act[k].getStarttime() + "\n" + act[k].getEndtime() + "\n" + act[k].getNotes());            
        }

        for (int x = 0; x < weightsize; x++) {
            System.out.println(weigh[x].getWeight() + "kgs" + "\n" + weigh[x].getFat() + "%" + "\n" + weigh[x].getDate());
        }

        for (int y = 0; y < sleepsize; y++) {
            System.out.println(sleep[y].getStarttime() + "\n" + sleep[y].getEndtime() + "\n" + sleep[y].gethoursSlept());
        }

    }
}

public final class FitByte {
    public static void main(String[] args) {
        Log l = new Log();
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            String line = s.nextLine();
            String[] tokens = line.split(" ", 2);
            switch(tokens[0]) {
                case "addfood":
                String[] tokens1 = tokens[1].split(",");
                l.addfoodLog(tokens1[0], tokens1[1], tokens1[2], tokens1[3]);
                break;
                case "addwater":
                l.addwaterLog(Integer.parseInt(tokens[1]));
                break;
                case "addactivity":
                String[] tokens2 = tokens[1].split(",");
                l.addactivityLog(tokens2[0], tokens2[1], tokens2[2], tokens2[3], tokens2[4]);
                break;
                case "addweight":
                String[] tokens3 = tokens[1].split(",");
                l.addweightLog(Double.parseDouble(tokens3[0]), Double.parseDouble(tokens3[1]), tokens3[2]);
                break;
                case "sleep":
                String[] tokens4 = tokens[1].split(",");
                l.addsleepLog(Integer.parseInt(tokens4[0]), Integer.parseInt(tokens4[1]));
                break;
                // case "daylog":
                case "print":
                l.printdetails();
                default:
                break;
            }
        }

    }
}
