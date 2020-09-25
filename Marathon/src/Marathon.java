//Quan Do
//CECS274 Sec 05
//Prog1 - Marathon
//February 11, 2020
import java.util.Scanner;


public class Marathon {
    public static void main(String[] args) {
        String name;
        int hours, minutes, seconds;
        double miles;

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Los Angeles Marathon Training Program");
        System.out.print("Please enter your first name? ");
        name = scan.next();
        System.out.print("Please enter your distance: ");
        miles = scan.nextDouble();
        System.out.print("How many hours: ");
        hours = scan.nextInt();
        System.out.print("How many minutes: ");
        minutes = scan.nextInt();
        System.out.print("How many seconds: ");
        seconds = scan.nextInt();

        paceTable(name, hours, minutes, seconds, miles);
    }
    public static void paceTable (String n, int h, int m, int s, double mil){
        String wrldRecrunner = "Eliud";
        int wrldMhour = 1;
        int wrldMmin = 59;
        int wrldMsec = 40;
        double wrldRecpace = ((wrldMhour * 3600) + (wrldMmin * 60) + wrldMsec) / (26 + (385 / 1760.0));

        double yourPace = ((h * 3600) + (m * 60) + s) / mil;
        int paceMin = (int)(yourPace / 60);
        int paceSec = (int)(yourPace - (paceMin * 60));
        System.out.printf("\nHi %s\nYour pace is: %d : %02d\n", n, paceMin, paceSec);

        int fyHour = (int)(((26 + (385/1760.0)) * yourPace) / 3600);
        int fyMin = (int)((((26 + (385/1760.0)) * yourPace) - (fyHour * 3600)) / 60);
        int fySec = (int)(((26 + (385/1760.0)) *yourPace) - ((fyHour * 3600) + (fyMin * 60)));
        System.out.printf("At this rate your marathon time would be %01d : %02d : %02d\n", fyHour, fyMin, fySec);
        System.out.println("Good luck with your training!" + "\n");

        System.out.printf("Pace Table\nMile\t\t%s\t\t\t\t%s\n", n, wrldRecrunner);
        int i = 1;
        while (i <= 26) {
            int recHour = (int) ((i * wrldRecpace) / 3600);
            int recMin = (int) (((i * wrldRecpace) - (recHour * 3600)) / 60);
            int recSec = (int) ((i * wrldRecpace) - ((recHour * 3600) + (recMin * 60)));

            int yourHours = (int)((i * yourPace) / 3600);
            int yourMin = (int)(((i * yourPace) - (yourHours * 3600)) / 60);
            int yourSec = (int)((i * yourPace) - ((yourHours * 3600) + (yourMin * 60)));
            System.out.printf("%d\t\t\t%01d : %02d : %02d\t\t\t%01d : %02d : %02d\n", i, recHour, recMin, recSec, yourHours, yourMin, yourSec);

            i++;
            if (i == 27){
                int fRechour = (int)(((26 + (385/1760.0)) * wrldRecpace) / 3600);
                int fRecmin = (int)((((26 + (385/1760.0)) * wrldRecpace) - (fRechour * 3600)) / 60);
                int fRecsec = (int)(((26 + (385/1760.0)) * wrldRecpace) - ((fRechour * 3600) + (fRecmin * 60)));

                System.out.printf("26m, 385y\t%01d : %02d : %02d\t\t\t%01d : %02d : %02d\n", fRechour, fRecmin, fRecsec, fyHour, fyMin, fySec);
            }
        }

    }
}