package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Question;
import java.util.Random;

public class PrimeGame {
    private static final Random random = new Random();
    private static final int MAX_NUMBER = 100; // числа до 100

    public static String getDescription() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    public static Question generateQuestion() {
        int number = random.nextInt(MAX_NUMBER - 1) + 2; // от 2 до 100
        String correct = isPrime(number) ? "yes" : "no";
        return new Question(String.valueOf(number), correct);
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void start() {
        Engine.run(EvenGame.getDescription(), EvenGame::generateQuestion);
    }
}
