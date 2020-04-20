import java.io.IOException;
import java.util.Scanner;
import java.util.Random;


public class NumberMemoryGame {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("*************************************");
        System.out.println("* Welcome to the Number Memory Game *");
        System.out.println("*************************************");

        System.out.print("\nEnter your name: ");
        Scanner scan = new Scanner(System.in);
        String userName = scan.next();

        clearConsole();

        System.out.println("\nWelcome " + userName + "!\n");
        System.out.print("Ready to take on the challenge? ");
        String userResponse = scan.next();

        if(userResponse.equalsIgnoreCase("yes")) {
            System.out.println("\nAlright cool.");
            clearConsole();

            System.out.println("\nStarting the game...");


            game();
        }else if(userResponse.equalsIgnoreCase("no")){
            System.out.println("\nThat's too bad. Goodbye.");
        } else{
            System.out.println("\nYou think you're funny huh?");
            System.out.println("Go waste someone else's life. Lol");
        }
    }

    // Function to clear the console screen
    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch(Exception e){
            System.out.print(e);
        }
    }

    public static void game() {
        Random rand = new Random();
        int upperBound = 26;

        // Generating a random number between 0-25
        int randomNumber = rand.nextInt(upperBound);

        int[] numbers = new int[3];

        // Filling the array with random numbers
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(upperBound);
        }

        System.out.println();

        // Printing the array
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.print("");
    }
}
