package vandyke;

import vandyke.DataObjects.Star;
import vandyke.Generation.PrimaryGeneration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Generating System!");
        PrimaryGeneration primaryGenerator = new PrimaryGeneration();
        try {
            Star primary = primaryGenerator.Generate();
            System.out.println(primary.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}