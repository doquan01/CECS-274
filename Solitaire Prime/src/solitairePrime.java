/*
 Quan Do
 CECS 274, Steve Gold
 Program 2, Solitaireprime
 3/3/2020
*/

import java.util.Scanner;

public class solitairePrime {
    public static void main(String[] args) {

        int input;
        Deck D = new Deck();
        do{
            input = menu();
            if (input == 1){
                D = new Deck();
                System.out.println("New deck is created.\n");
            }
            else if (input == 2){
                D.display();
                System.out.println("Deck displayed.");
            }
            else if (input == 3){
                D.shuffle();
                System.out.println("Deck shuffled.\n");
            }
            else if (input == 4){
                playSolitaire(D);
            }
            else if (input == 5){
                System.out.println("Exiting the game, bye.");
            }
            else if (input == 6){
                int win = 0;
                int lose = 0;
                for (int i = 0; i < 1000; i++){
                    D = new Deck();
                    D.shuffle();
                    if (playBolean(D)){
                        win++;
                    }
                    else{
                        lose++;
                    }
                }
                System.out.println("In 1000 games, you won " + win + " times, and you lost " + lose + " times\n");
            }
            else{
                System.out.println("Please input a number option from the menu.\n");
            }
        }while(input != 5);


    }
    public static boolean isPrime(int x){
        if (x == 1 || x == 0){
            return false;
        }
        for (int i = 2; i <= Math.floor(Math.sqrt(x)); i++){
            if (x % i == 0){
                return false;
            }
        }
        return true;
    }
    public static int menu(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Welcome to Solitaire Prime!\n1) New Deck\n" +
                "2) Display Deck\n3) Shuffle Deck\n4) Play Solitaire Prime\n5) Exit\n" +
                "6)Simulate 1000 Games\nPlease enter a number option\n");
        int x = scan.nextInt();
        return x;
    }
    public static void playSolitaire(Deck d){
        if(d.cardsLeft() == 0) {
            d = new Deck();
            d.shuffle();
        }
        System.out.println("\nPlaying Solitaire Prime!!!");
        int pileValue = 0;
        int pileCounter = 0;
        for (int i = 0; i < 52; i++) {
            Card C1 = d.deal();
            C1.display();
            System.out.print(", ");
            pileValue += C1.getValue();
            if (isPrime(pileValue)) {
                System.out.println("Prime: " + pileValue);
                pileValue = 0;
                pileCounter++;
            }
        }
        if (d.cardsLeft() == 0 && pileValue == 0){
            System.out.println("Winner in " + pileCounter + " piles!\n\n");
        }
        else{
            System.out.println("Loser\n\n");
        }
    }
    public static boolean playBolean(Deck d){
            d = new Deck();
            d.shuffle();
        int pileValue = 0;
        for (int i = 0; i < 52; i++) {
            Card C1 = d.deal();
            pileValue += C1.getValue();
            if (isPrime(pileValue)) {
                pileValue = 0;
            }
        }
        if (d.cardsLeft() == 0 && pileValue == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
