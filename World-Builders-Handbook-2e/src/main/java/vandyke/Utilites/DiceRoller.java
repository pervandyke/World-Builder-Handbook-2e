package vandyke.Utilites;

import java.util.Random;

public class DiceRoller {
    private final Random r = new Random();

    public Integer RollND6(Integer N) {
        int total = 0;
        for (int i = 0; i < N; i++) {
            total = total + r.nextInt(1,7);
        }
        return total;
    }

    public Integer randInt(Integer lower, Integer upper) {
        return r.nextInt(lower, upper);
    }
}
