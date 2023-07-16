package vandyke.Generation;

import vandyke.DataObjects.Star;
import vandyke.Reference.StarTables;
import vandyke.Utilites.DiceRoller;
import vandyke.Utilites.StarGenerationUtilities;

public class StarGenerator {

    private static final DiceRoller roller = new DiceRoller();

    private static final StarTables starTables = new StarTables();

    public static Star GenerateCompanionStar(Star primary) throws Exception {
        Star companion = new Star();

        // Check for occurrence of companion
        Integer companionRoll = roller.RollND6(2);
        //System.out.println("Raw Companion Roll: " + companionRoll);

        String primaryStarClass = primary.getStarClass();
        if (primaryStarClass.equals("Ia") || primaryStarClass.equals("Ib") || primaryStarClass.equals("II")
                || primaryStarClass.equals("III") || primaryStarClass.equals("IV")) {
            companionRoll++;
        }
        String primaryStarType = primary.getType();
        if ((primaryStarClass.equals("V") || primaryStarClass.equals("VI"))
                && (primaryStarType.equals("O") || primaryStarType.equals("B") || primaryStarType.equals("A") || primaryStarType.equals("F"))) {
            companionRoll++;
        }
        if ((primaryStarClass.equals("V") || primaryStarClass.equals("VI") && primaryStarType.equals("M"))) {
            companionRoll--;
        }

        //System.out.println("Modified Companion Roll: " + companionRoll);

        // Companion present!
        if (companionRoll >= 10) {
            //System.out.println("Companion present!");
            Integer companionTypeRoll = roller.RollND6(2);
            if (primaryStarClass.equals("III") || primaryStarClass.equals("IV")) {
                companionTypeRoll--;
                if (companionTypeRoll < 2) {
                    companionTypeRoll = 2;
                }
            }

            //System.out.println("Companion Type Roll: " + companionTypeRoll);

            if (companionTypeRoll == 2 || companionTypeRoll == 3) {
                //TODO: Implement Other Table
                GenerateRandomNonPrimary(companion, primary);
            } else if (companionTypeRoll == 4 || companionTypeRoll == 5) {
                GenerateRandomNonPrimary(companion, primary);
            } else if (companionTypeRoll == 6 || companionTypeRoll == 7) {
                GenerateLesserNonPrimary(companion, primary);
            } else if (companionTypeRoll == 8 || companionTypeRoll == 9) {
                GenerateSiblingNonPrimary(companion, primary);
            } else if (companionTypeRoll == 10 || companionTypeRoll == 11 || companionTypeRoll == 12) {
                GenerateTwinNonPrimary(companion, primary);
            }
        } else {
            companion = null;
        }
        //System.out.println("Companion Object: " + companion);
        return companion;
    }

    private static void GenerateRandomNonPrimary(Star nonPrimary, Star primary) throws Exception {

        boolean regenerate = true;
        while (regenerate) {
            StarGenerationUtilities.GenerateTypeAndClass(nonPrimary);

            StarGenerationUtilities.CalculateMassAndTemperature(nonPrimary);

            nonPrimary.setColor(starTables.Color.get(nonPrimary.getType()));

            StarGenerationUtilities.CalculateDiameter(nonPrimary);

            nonPrimary.setLuminosity(StarGenerationUtilities.CalculateLuminosity(nonPrimary));

            nonPrimary.setLifespan(StarGenerationUtilities.CalculateLifespan(nonPrimary));

            nonPrimary.setAge(primary.getAge());

            if (nonPrimary.getTemperature() < primary.getTemperature()) {
                regenerate = false;
            }
        }
    }

    private static void GenerateLesserNonPrimary(Star nonPrimary, Star primary) throws Exception {

        String newType;

        if (primary.getSubType() >= 5) {
            newType = starTables.TypeAdjacency.get(starTables.TypeAdjacency.indexOf(primary.getType() + 0) - 2).replaceAll("0-9", "");
        } else {
            newType = starTables.TypeAdjacency.get(starTables.TypeAdjacency.indexOf(primary.getType() + 5) - 1).replaceAll("0-9", "");
        }

        StarGenerationUtilities.GenerateTypeAndClass(nonPrimary, newType, primary.getStarClass());

        StarGenerationUtilities.CalculateMassAndTemperature(nonPrimary);

        nonPrimary.setColor(starTables.Color.get(nonPrimary.getType()));

        StarGenerationUtilities.CalculateDiameter(nonPrimary);

        nonPrimary.setLuminosity(StarGenerationUtilities.CalculateLuminosity(nonPrimary));

        nonPrimary.setLifespan(StarGenerationUtilities.CalculateLifespan(nonPrimary));

        nonPrimary.setAge(primary.getAge());
    }

    private static void GenerateSiblingNonPrimary(Star nonPrimary, Star primary) throws Exception {
        String newType = null;
        int newSubType = primary.getSubType() + roller.RollND6(1);

        if (newSubType > 10) {
            newSubType -= 10;
            if (newSubType >= 5) {
                newType = starTables.TypeAdjacency.get(starTables.TypeAdjacency.indexOf(primary.getType() + 0) - 2).replaceAll("0-9", "");
            } else {
                newType = starTables.TypeAdjacency.get(starTables.TypeAdjacency.indexOf(primary.getType() + 5) - 1).replaceAll("0-9", "");
            }
        }

        if (newType != null) {
            StarGenerationUtilities.GenerateTypeAndClass(nonPrimary, newType, primary.getStarClass());
        } else {
            StarGenerationUtilities.GenerateTypeAndClass(nonPrimary, primary.getType(), primary.getStarClass());
        }

        nonPrimary.setSubType(newSubType);

        StarGenerationUtilities.CalculateMassAndTemperature(nonPrimary);

        nonPrimary.setColor(starTables.Color.get(nonPrimary.getType()));

        StarGenerationUtilities.CalculateDiameter(nonPrimary);

        nonPrimary.setLuminosity(StarGenerationUtilities.CalculateLuminosity(nonPrimary));

        nonPrimary.setLifespan(StarGenerationUtilities.CalculateLifespan(nonPrimary));

        nonPrimary.setAge(primary.getAge());
    }

    private static void GenerateTwinNonPrimary(Star nonPrimary, Star primary) throws Exception {

        StarGenerationUtilities.GenerateTypeAndClass(nonPrimary, primary.getType(), primary.getStarClass());

        nonPrimary.setSubType(primary.getSubType());

        StarGenerationUtilities.CalculateMassAndTemperature(nonPrimary);

        Float randomVariation = 1.0f - ((roller.RollND6(1) - 1) / 100f);

        nonPrimary.setMass(primary.getMass() * randomVariation);
        nonPrimary.setDiameter(primary.getDiameter() * randomVariation);

        nonPrimary.setColor(starTables.Color.get(nonPrimary.getType()));

        StarGenerationUtilities.CalculateDiameter(nonPrimary);

        nonPrimary.setLuminosity(StarGenerationUtilities.CalculateLuminosity(nonPrimary));

        nonPrimary.setLifespan(StarGenerationUtilities.CalculateLifespan(nonPrimary));

        nonPrimary.setAge(primary.getAge());
    }

}
