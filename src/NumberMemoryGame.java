import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class NumberMemoryGame {

    // Creating a public scanner
    public static Scanner scan = new Scanner(System.in);

    // Creating a lives variables indicating a player's lives remaining
    public static int lives = 3;

    public static void main(String[] args) {

        System.out.println();
        System.out.println("*************************************");
        System.out.println("* Welcome to the Number Memory Game *");
        System.out.println("*************************************");

        System.out.print("\nEnter your name: ");
        String userName = scan.next();

        clearConsole();

        System.out.println("\nWelcome " + userName + "!\n");
        System.out.print("Ready to take on the challenge? ");
        String userResponse = scan.next();

        if(userResponse.equalsIgnoreCase("yes")) {
            clearConsole();
            System.out.println("\nStarting the game...");
            try{
                Thread.sleep(1500);
            } catch(Exception e) {
                System.out.print(e);
            }

            clearConsole();
            game_level_1();

        }else if(userResponse.equalsIgnoreCase("no")){
            System.out.println("\nThat's too bad. Goodbye.");
        } else{
            System.out.println("\nYou think you're funny, huh?");
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

    // Function to check if the game should be over
    public static void gameOver() {
        lives--;
        if(lives == 0) {
            System.out.print("\nGame Over");
            System.exit(0);
        }
    }

    // Function to delay 2.5 seconds
    public static void time_level_1() {
        try{
            Thread.sleep(2500);
        } catch(Exception e) {
            System.out.print(e);
        }
    }

    // Function to delay 1.5 seconds
    public static void time_level_2() {
        try{
            Thread.sleep(1500);
        } catch(Exception e) {
            System.out.print(e);
        }
    }

    public static void game_level_1() {

        // Variable indicating when to stop
        int stop = 10;
        // Variable to be increased at the end of each iteration
        int continueGame = 0;

        // Iterating level 1 for 10 times
        while(continueGame < stop) {

            Random rand = new Random();
            // Numbers to be generated between 0-99
            int upperBound = 100;

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
            System.out.println();
            time_level_1();
            clearConsole();
            System.out.println("\nEnter your answer: ");

            // Storing the user's answer to the array
            int[] answer = new int[3];
            for(int i = 0; i < answer.length; i++) {
                answer[i] = Integer.parseInt(scan.next());
            }

            // Comparing the contents of both arrays
            if (Arrays.equals(numbers, answer)) {
                System.out.println("\nCorrect");
                // Delaying the next console prompt for 1.5 seconds
                try{
                    Thread.sleep(1500);
                } catch(Exception e) {
                    System.out.print(e);
                }
                clearConsole();
            }else {
                System.out.println("\nIncorrect");
                // Delaying the next console prompt for 1.5 seconds
                try{
                    Thread.sleep(1500);
                } catch(Exception e) {
                    System.out.print(e);
                }
                clearConsole();
                gameOver();
            }
            // Incrementing the continueGame variable
            continueGame++;
        }
    }
}
