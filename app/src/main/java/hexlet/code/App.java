package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.ProgressionGame;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine().trim();
        System.out.println("Hello, " + name + "!");

        while (true) {
            System.out.println("\nPlease enter the game number and press Enter.");
            System.out.println("1 - Greet");
            System.out.println("2 - Even");
            System.out.println("3 - Calc");
            System.out.println("4 - GCD");
            System.out.println("5 - Progression");
            System.out.println("6 - Prime");
            System.out.println("0 - Exit");
            System.out.print("Your choice: ");

            String input = scanner.nextLine().trim();
            int userChoise;
            try {
                userChoise = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (userChoise) {
                case 1:
                    Cli.greet(name);
                    break;
                case 2:
                    EvenGame.start(name);
                    break;
                case 3:
                    CalcGame.start(name);
                    break;
                case 4:
                    GcdGame.start(name);
                    break;
                case 5:
                    ProgressionGame.start(name);
                    break;
                case 6:
                    PrimeGame.start(name);
                    break;
                case 0:
                    System.out.println("Goodbye, " + name + "!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown game number. Please try again.");
                    System.out.println("Unknown user choice " + userChoise);
                    break;
            }
        }
    }
}
