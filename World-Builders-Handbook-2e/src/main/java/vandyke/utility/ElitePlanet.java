package vandyke.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * This random name generator is a Java adaptation of the Elite Planet Name Generator found here: https://github.com/jabbalaci/Elite
 */
public class ElitePlanet {

    private static final String pairs0  = "ABOUSEITILETSTONLONUTHNO";
    private static final String pairs = "..LEXEGEZACEBISOUSESARMAINDIREA.ERATENBERALAVETIEDORQUANTEISRION";
    private static final String pairs1 = pairs0 + pairs;
    private static final Random r = new Random();

    public static String getPlanetName() {
        return makePlanet();
    }

    private static int size16Num(int value) {
        int mask = (1 << 16) - 1;
        return value & mask;
    }

    private static String makePlanet() {
        Seed seed = new Seed();

        int longNameFlag = seed.w0 & 64;

        int pair1 = 2 * ((seed.w2 >> 8) & 31);
        seed.shuffle();
        int pair2 = 2 * ((seed.w2 >> 8) & 31);
        seed.shuffle();
        int pair3 = 2 * ((seed.w2 >> 8) & 31);
        seed.shuffle();
        int pair4 = 2 * ((seed.w2 >> 8) & 31);
        seed.shuffle();

        List<Character> name = new ArrayList<>();
        name.add(pairs.charAt(pair1));
        name.add(pairs.charAt(pair1 + 1));
        name.add(pairs.charAt(pair2));
        name.add(pairs.charAt(pair2 + 1));
        name.add(pairs.charAt(pair3));
        name.add(pairs.charAt(pair3 + 1));

        if (longNameFlag != 0) {
            name.add(pairs.charAt(pair4));
            name.add(pairs.charAt(pair4 + 1));
        }

        String planetName = name.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        return planetName.replace(".", "").toUpperCase();

    }

    private static class Seed {
        int w0;
        int w1;
        int w2;

        public Seed() {
            this.w0 = r.nextInt();
            this.w1 = r.nextInt();
            this.w2 = r.nextInt();
        }

        public void shuffle() {
            int temp = size16Num(this.w0 + this.w1 + this.w2);
            this.w0 = this.w1;
            this.w1 = this.w2;
            this.w2 = temp;
        }
    }


}
