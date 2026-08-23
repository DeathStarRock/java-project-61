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
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    Cli.greet(name);
                    break;
                case 2:
                    Engine.run(EvenGame.getDescription(), EvenGame::generateQuestion, name);
                    break;
                case 3:
                    Engine.run(CalcGame.getDescription(), CalcGame::generateQuestion, name);
                    break;
                case 4:
                    Engine.run(GcdGame.getDescription(), GcdGame::generateQuestion, name);
                    break;
                case 5:
                    Engine.run(
                            ProgressionGame.getDescription(),
                            ProgressionGame::generateQuestion,
                            name);
                    break;
                case 6:
                    Engine.run(PrimeGame.getDescription(), PrimeGame::generateQuestion, name);
                    break;
                case 0:
                    System.out.println("Goodbye, " + name + "!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown game number. Please try again.");
                    break;
            }
        }
    }
}
