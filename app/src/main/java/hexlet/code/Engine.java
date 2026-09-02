package hexlet.code;

import java.util.Scanner;
import java.util.function.Supplier;

public class Engine {
    public static final int ROUNDS = 3;

    public static void run(String description, Supplier<Question> questionGenerator) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine().trim();
        System.out.println("Hello, " + name + "!");
        System.out.println(description);

        for (int i = 0; i < ROUNDS; i++) {
            Question q = questionGenerator.get();
            System.out.println("Question: " + q.getQuestion());
            System.out.print("Your answer: ");
            String answer = scanner.nextLine().trim();

            if (answer.equals(q.getCorrectAnswer())) {
                System.out.println("Correct!");
            } else {
                System.out.println(
                        "'"
                                + answer
                                + "' is wrong answer ;(. Correct answer was '"
                                + q.getCorrectAnswer()
                                + "'.");
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }
}
