/*Quan Do
CECS 274 Sec 5
Program 4 Human Pyramid
April 21, 2020*/
import java.util.ArrayList;
import java.util.Scanner;

public class HumanPyramid {
    public static void main(String[] args) {
        String input = "y";
        Scanner scan = new Scanner(System.in);
        do {
            if(input.compareToIgnoreCase("y") == 0) {
                int max;
                ArrayList<Integer> test = new ArrayList<>();
                System.out.print("\nHow tall is your pyramid? (Enter number of rows): ");
                max = scan.nextInt();
                System.out.println("\nHere is the graph of your pyramid showing the weight each person is holding:\n");
                for (int row = 1; row <= max; row++) {
                    for (int col = 1; col <= row; col++) {
                        test.add((int) weightOnBack(row, col));
                    }
                }
                display(max, test);
                System.out.print("\nDo you want to run again? (y/n) ");
                input = scan.next();
            }
            else if(input.compareToIgnoreCase("y") != 0 && input.compareToIgnoreCase("n") != 0){
                System.out.print("Please input a valid response. Do you want to run again? (y/n) ");
                input = scan.next();
            }
        }while(input.compareToIgnoreCase("n") != 0);
    }
    public static double weightOnBack(int row, int col){
        if(row == 1 && col == 1){ //base case
            return 0;
        }
        else if(col == 1){ //base case
            return(75 + (weightOnBack(row - 1, col)/2));
        }
        else if (col == row){ //base case
            return(75 + (weightOnBack(row - 1, col - 1)/2));
        }
        else{ //general case
            return (((150 + weightOnBack(row - 1, col - 1))/2) + ((150 + weightOnBack(row - 1, col))/2));
        }
    }
    public static void display(int rows, ArrayList<Integer> x){
        int arryIdx = 0;
        for(int i=1; i <= rows; i++){
            for(int j=0; j < (rows-i) ; j++){
                System.out.print("   ");
            }
            for(int j=0; j<i; j++){
                System.out.printf("(%4d)", x.get(arryIdx++));
            }
            System.out.println();
        }
    }
}