package vandyke.Generation;

import vandyke.DataObjects.SolarSystem;
import vandyke.DataObjects.Star;

public class SystemGenerator {

    static PrimaryGeneration primaryGenerator = new PrimaryGeneration();

    public static SolarSystem GenerateSystem() {
        SolarSystem system = new SolarSystem();

        try {
            Star primary = primaryGenerator.Generate();
            System.out.println(primary.toString());
            if (primary.getCompanion() != null) {
                System.out.println("Companion: ");
                System.out.println(primary.getCompanion().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return system;
    }

}
