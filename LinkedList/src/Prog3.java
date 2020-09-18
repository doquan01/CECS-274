//Quan Do
//CECS 274 Sec 5
//Program 3 Linked List
//March 26, 2020
import java.util.Random;
import java.util.Scanner;

public class Prog3 {
    public static void main(String[] args) {
        Random rand = new Random();
        LinkedList L = new LinkedList();

        for(int i = 0; i < 100; i++){
            L.add(randWord());
        }
        System.out.println();
        L.display();
        String input;
        do{
            input = menu(L);
            if(input.compareToIgnoreCase("A") == 0){ //add
                String word = randWord();
                L.add(word);
                System.out.println();
                L.display();
                System.out.println("\n\n" + word + " added at location " + L.findLocation(word));
            }
            else if(input.compareToIgnoreCase("D") == 0){ //delete
                if(L.getSize() != 1) {
                    int randomNum = (1 + rand.nextInt(L.getSize() - 1));
                    L.delete(randomNum, L);
                    }
                else{
                    L.display();
                    System.out.println("\nThere are no more nodes to delete");
                    }
            }
            else if(input.compareToIgnoreCase("F") == 0){ //find
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter a word you want to find");
                String input2 = scan.next();

                if(L.findBoolean(input2)){
                    System.out.println();
                    L.display();
                    System.out.println("\n\n" + input2 + " found at location " + L.findLocation(input2));
                }else if(!L.findBoolean(input2)){
                    System.out.println();
                    L.display();
                    System.out.println("\n\n" + input2 + " not found");
                }
            }
            else if(input.compareToIgnoreCase("q") == 0){ //quit
                System.out.println("Exiting the program");
            }
            else{
                System.out.println("Please enter a letter input without spaces");
            }
        }while(input.compareToIgnoreCase("Q") != 0);
    }
    public static String randWord(){
        Random rand = new Random();
        String [] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String [] vowel = {"a","e","i","o","u"};

        String firL = alpha[rand.nextInt(26)];
        String secL = vowel[rand.nextInt(5)];
        String thiL = alpha[rand.nextInt(26)];
        String fouL = alpha[rand.nextInt(26)];

        String rWord = firL + secL + thiL + fouL;
        return rWord;
    }
    public static String menu(LinkedList y){
        Scanner scan = new Scanner(System.in);

        System.out.printf("\n(A)dd, (D)elete, (F)ind, (Q)uit, List Size: %s\n", y.getSize());
        String x = scan.next();
        return x;
    }
}
