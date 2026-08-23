package hexlet.code.games;

import hexlet.code.Question;
import java.util.Random;

public class ProgressionGame {
    private static final Random random = new Random();
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;

    public static String getDescription() {
        return "What number is missing in the progression?";
    }

    public static Question generateQuestion() {
        int length = random.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH; // от 5 до 10
        int start = random.nextInt(50) + 1;
        int step = random.nextInt(10) + 1;

        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = start + i * step;
        }

        int hiddenIndex = random.nextInt(length);
        int hiddenNumber = progression[hiddenIndex];

        StringBuilder questionBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (i == hiddenIndex) {
                questionBuilder.append("..");
            } else {
                questionBuilder.append(progression[i]);
            }
            if (i < length - 1) {
                questionBuilder.append(" ");
            }
        }

        return new Question(questionBuilder.toString(), String.valueOf(hiddenNumber));
    }
}
