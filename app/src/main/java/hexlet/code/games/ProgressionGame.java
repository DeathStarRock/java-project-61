package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Question;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProgressionGame {
    private static final Random random = new Random();
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;

    public static String getDescription() {
        return "What number is missing in the progression?";
    }

    public static Question generateQuestion() {
        int length = random.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH;
        int start = random.nextInt(50) + 1;
        int step = random.nextInt(10) + 1;

        int[] progression = generateProgression(start, step, length);
        int hiddenIndex = random.nextInt(length);
        int hiddenNumber = progression[hiddenIndex];

        String question =
                IntStream.range(0, length)
                        .mapToObj(i -> i == hiddenIndex ? ".." : String.valueOf(progression[i]))
                        .collect(Collectors.joining(" "));

        return new Question(question, String.valueOf(hiddenNumber));
    }

    public static void start(String userName) {
        Engine.run(ProgressionGame.getDescription(), ProgressionGame::generateQuestion, userName);
    }

    private static int[] generateProgression(int start, int step, int length) {
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = start + i * step;
        }
        return progression;
    }
}
