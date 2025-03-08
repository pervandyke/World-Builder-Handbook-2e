package vandyke.utility;

import java.util.Random;

public class DiceRoller {
    private static final Random r = new Random();

    public static Integer RollND6(Integer N) {
        int total = 0;
        for (int i = 0; i < N; i++) {
            total = total + RollDN(6);
        }
        return total;
    }

    public static Integer RollDN(Integer N) {
        return r.nextInt(1, N + 1);
    }

    public static Integer randInt(Integer lower, Integer upper) {
        return r.nextInt(lower, upper);
    }

    public static Double randPercentage(Integer max) {
        return randInt(0, max) / 100d;
    }

    public static Double randVariance(Integer max) {
        double magnitude = randInt(0, max) / 100d;
        double variance;
        if (randInt(1, 100) >= 50) {
            variance = -magnitude;
        } else {
            variance = magnitude;
        }
        return variance;
    }
}
