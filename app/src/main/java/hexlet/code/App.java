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

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        String input = scanner.nextLine().trim();
        int userChoice;
        try {
            userChoice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.close();
            return;
        }

        switch (userChoice) {
            case 1:
                Cli.greet();
                break;
            case 2:
                EvenGame.start();
                break;
            case 3:
                CalcGame.start();
                break;
            case 4:
                GcdGame.start();
                break;
            case 5:
                ProgressionGame.start();
                break;
            case 6:
                PrimeGame.start();
                break;
            case 0:
                System.out.println("Goodbye!");
                scanner.close();
                return;
            default:
                System.out.println("Unknown game number. Please try again.");
                System.out.println("Unknown user choice " + userChoice);
                break;
        }
    }
}
