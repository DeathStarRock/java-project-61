package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Question;
import java.util.Random;

public class EvenGame {
    private static final Random random = new Random();

    public static String getDescription() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    public static Question generateQuestion() {
        int number = random.nextInt(100) + 1;
        String correct = number % 2 == 0 ? "yes" : "no";
        return new Question(String.valueOf(number), correct);
    }

    public static void start() {
        Engine.run(EvenGame.getDescription(), EvenGame::generateQuestion);
    }
}
