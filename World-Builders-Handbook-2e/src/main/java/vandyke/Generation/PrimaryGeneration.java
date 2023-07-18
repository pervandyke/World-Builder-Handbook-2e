package vandyke.Generation;

import com.sun.source.tree.IfTree;
import vandyke.DataObjects.Primary;
import vandyke.DataObjects.Star;
import vandyke.Reference.StarTables;
import vandyke.Utilites.DiceRoller;
import vandyke.Utilites.Formulas;
import vandyke.Utilites.StarGenerationUtilities;

import java.text.Normalizer;

public class PrimaryGeneration {

    StarTables starTables = new StarTables();



    public Primary Generate() throws Exception {
        Primary primary = new Primary();

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
