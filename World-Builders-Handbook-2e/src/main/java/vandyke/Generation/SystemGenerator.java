package vandyke.Generation;

import org.springframework.stereotype.Service;
import vandyke.DataObjects.StarSystem;

@Service
public class SystemGenerator {

    static PrimaryGeneration primaryGenerator = new PrimaryGeneration();

    static WorldOrbitGenerator worldGenerator = new WorldOrbitGenerator();

    public static StarSystem GenerateSystem() {
        StarSystem system = new StarSystem();

        try {
            system.setPrimaryStar(primaryGenerator.Generate());
            system.setStarCount(CountStars(system));
            worldGenerator.GenerateWorlds(system);
            System.out.println(system);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return system;
    }

    private static Integer CountStars(StarSystem system) {
        int starCount = 1;
        if (system.getPrimaryStar().getCompanion() != null) {
            starCount++;
        }
        if (system.getPrimaryStar().getCloseStar() != null) {
            starCount++;
            if (system.getPrimaryStar().getCloseStar().getCompanion() != null) {
                starCount++;
            }
        }
        if (system.getPrimaryStar().getNearStar() != null) {
            starCount++;
            if (system.getPrimaryStar().getNearStar().getCompanion() != null) {
                starCount++;
            }
        }
        if (system.getPrimaryStar().getFarStar() != null) {
            starCount++;
            if (system.getPrimaryStar().getFarStar().getCompanion() != null) {
                starCount++;
            }
        }
        return starCount;
    }

}
