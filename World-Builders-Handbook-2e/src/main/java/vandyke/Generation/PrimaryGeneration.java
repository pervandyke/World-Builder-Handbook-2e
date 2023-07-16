package vandyke.Generation;

import com.sun.source.tree.IfTree;
import vandyke.DataObjects.Star;
import vandyke.Reference.StarTables;
import vandyke.Utilites.DiceRoller;
import vandyke.Utilites.Formulas;
import vandyke.Utilites.StarGenerationUtilities;

import java.text.Normalizer;

public class PrimaryGeneration {

    StarTables starTables = new StarTables();



    public Star Generate() throws Exception {
        Star primary = new Star();

        StarGenerationUtilities.GenerateTypeAndClass(primary);

        StarGenerationUtilities.CalculateMassAndTemperature(primary);

        primary.setColor(starTables.Color.get(primary.getType()));

        StarGenerationUtilities.CalculateDiameter(primary);

        primary.setLuminosity(StarGenerationUtilities.CalculateLuminosity(primary));

        primary.setLifespan(StarGenerationUtilities.CalculateLifespan(primary));

        primary.setAge(StarGenerationUtilities.GenerateAge(primary));

        primary.setCompanion(StarGenerationUtilities.GenerateCompanions(primary));

        return primary;
    }


}
