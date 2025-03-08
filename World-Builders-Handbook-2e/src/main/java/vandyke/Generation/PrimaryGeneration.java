package vandyke.generation;

import vandyke.data.persistence.Primary;
import vandyke.reference.StarTables;
import vandyke.utility.NamingUtilities;
import vandyke.utility.StarGenerationUtilities;

public class PrimaryGeneration {

    StarTables starTables = new StarTables();



    public Primary Generate() throws Exception {
        Primary primary = new Primary();

        primary.setName(NamingUtilities.GeneratePlanetName());

        StarGenerationUtilities.GenerateTypeAndClass(primary);

        StarGenerationUtilities.CalculateMassAndTemperature(primary);

        primary.setColor(starTables.Color.get(primary.getType()));

        StarGenerationUtilities.CalculateDiameter(primary);

        primary.setLuminosity(StarGenerationUtilities.CalculateLuminosity(primary));

        primary.setLifespan(StarGenerationUtilities.CalculateLifespan(primary));

        primary.setAge(StarGenerationUtilities.GenerateAge(primary));

        //TODO: Re-enable after clarification on multi-star orbit generation.
        //primary.setCloseStar(StarGenerator.GenerateSecondaryStar(primary, "Close"));

        //primary.setNearStar(StarGenerator.GenerateSecondaryStar(primary, "Near"));

        //primary.setFarStar(StarGenerator.GenerateSecondaryStar(primary, "Far"));

        //primary.setCompanion(StarGenerationUtilities.GenerateCompanions(primary));

        return primary;
    }


}
