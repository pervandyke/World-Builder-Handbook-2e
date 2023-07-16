package vandyke.Generation;

import vandyke.DataObjects.Primary;
import vandyke.DataObjects.SolarSystem;
import vandyke.DataObjects.Star;

public class SystemGenerator {

    static PrimaryGeneration primaryGenerator = new PrimaryGeneration();

    public static SolarSystem GenerateSystem() {
        SolarSystem system = new SolarSystem();

        try {
            system.setPrimaryStar(primaryGenerator.Generate());
            System.out.println(system.getPrimaryStar().toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return system;
    }

}
