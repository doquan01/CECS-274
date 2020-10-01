import java.util.Scanner;

public class MainLink {

    public static final String INITIAL_CONTENT = "Java";
    public static void main(String[] args) {

        System.out.println("--------------------------------------------------\n" +
                "Menu Options:\nfirst or f: Move cursor to front\n" +
                "next or n: Move cursor to the right\ninsert space or is: insert space next to cursor position\n" +
                "insert or i: insert character before cursor position\nquit or q: end program\n" +
                "--------------------------------------------------");
        LinkedCharacters text = new LinkedCharacters(INITIAL_CONTENT);
        System.out.println(text);
        boolean done = false;

        Scanner scan = new Scanner(System.in);
        String commandWithOptions;

        while (!done && scan.hasNext()) {
            commandWithOptions = scan.nextLine();
            switch (commandWithOptions.toLowerCase()) {
                case "f": case "first":
                    text.first();
                    break;
                case "n": case "next":
                    if (text.hasNext())
                        text.next();
                    else
                        System.out.println("Already at the end, there's no next");
                    break;
                case "is": case "insert space":
                    text.insert(' ');
                    break;
                case "i": case "insert":
                    System.out.println("Enter a character");
                    Character c = scan.next().charAt(0);
                    text.insert(c);
                    break;
                case "quit": case "q":
                    done = true;
                    break;
                default:
                    System.out.println("Not a command, try again");
            }
            System.out.println("--------------------------------------------------\n" +
                    "Options:\nfirst or f: Move cursor to front\n" +
                    "next or n: Move cursor to the right\ninsert or i: insert character next to cursor position\n" +
                    "insert or i: insert character before to cursor position\nquit: end program\n" +
                    "--------------------------------------------------");
            System.out.printf("Text = :%s:\n", text);
        }
    }
}