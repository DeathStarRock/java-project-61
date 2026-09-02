package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Question;
import java.util.Random;

public class GcdGame {
    private static final Random random = new Random();

    public static String getDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    public static Question generateQuestion() {
        int a = random.nextInt(50) + 1;
        int b = random.nextInt(50) + 1;
        int gcd = gcd(a, b);
        String question = a + " " + b;
        return new Question(question, String.valueOf(gcd));
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void start() {
        Engine.run(EvenGame.getDescription(), EvenGame::generateQuestion);
    }
}
