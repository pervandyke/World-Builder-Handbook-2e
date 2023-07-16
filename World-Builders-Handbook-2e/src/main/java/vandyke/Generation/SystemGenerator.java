package vandyke.Generation;

import vandyke.DataObjects.Primary;
import vandyke.DataObjects.SolarSystem;
import vandyke.DataObjects.Star;

public class SystemGenerator {

    static PrimaryGeneration primaryGenerator = new PrimaryGeneration();

    public static SolarSystem GenerateSystem() {
        SolarSystem system = new SolarSystem();

        for (int x = 0; x < 100; x++) {
            try {
                system.setPrimaryStar(primaryGenerator.Generate());
                System.out.println(system);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return system;
    }

}
