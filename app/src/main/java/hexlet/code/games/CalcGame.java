package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Question;
import java.util.Random;

public class CalcGame {
    private static final Random random = new Random();

    public static String getDescription() {
        return "What is the result of the expression?";
    }

    public static Question generateQuestion() {
        int a = random.nextInt(20) + 1;
        int b = random.nextInt(20) + 1;
        char operator = getRandomOperator();
        String question = a + " " + operator + " " + b;
        int result = calculate(a, b, operator);
        return new Question(question, String.valueOf(result));
    }

    private static char getRandomOperator() {
        char[] ops = {'+', '-', '*'};
        return ops[random.nextInt(ops.length)];
    }

    private static int calculate(int a, int b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                throw new RuntimeException("Unknown operator " + operator);
        }
    }

    public static void start() {
        Engine.run(CalcGame.getDescription(), CalcGame::generateQuestion);
    }
}
