package vandyke.Generation;

import vandyke.DataObjects.Star;
import vandyke.Reference.StarTables;
import vandyke.Utilites.DiceRoller;
import vandyke.Utilites.StarGenerationUtilities;

public class StarGenerator {

    private static final DiceRoller roller = new DiceRoller();

    private static final StarTables starTables = new StarTables();

    public static Star GenerateCompanionStar(Star parent) throws Exception {
        Star companion = new Star();

        boolean companionPresent = CheckForNonPrimaryPresence(parent);

        // Companion present!
        if (companionPresent) {
            //System.out.println("Companion present!");
            Integer companionTypeRoll = roller.RollND6(2);
            if (parent.getStarClass().equals("III") || parent.getStarClass().equals("IV")) {
                companionTypeRoll--;
                if (companionTypeRoll < 2) {
                    companionTypeRoll = 2;
                }
            }

            //System.out.println("Companion Type Roll: " + companionTypeRoll);

            if (companionTypeRoll == 2 || companionTypeRoll == 3) {
                //TODO: Implement Other Table
                GenerateRandomNonPrimary(companion, parent);
            } else if (companionTypeRoll == 4 || companionTypeRoll == 5) {
                GenerateRandomNonPrimary(companion, parent);
            } else if (companionTypeRoll == 6 || companionTypeRoll == 7) {
                GenerateLesserNonPrimary(companion, parent);
            } else if (companionTypeRoll == 8 || companionTypeRoll == 9) {
                GenerateSiblingNonPrimary(companion, parent);
            } else if (companionTypeRoll == 10 || companionTypeRoll == 11 || companionTypeRoll == 12) {
                GenerateTwinNonPrimary(companion, parent);
            }
            companion.setOrbitClass("Companion");
            companion.setParent(parent);
        } else {
            companion = null;
        }
        //System.out.println("Companion Object: " + companion);
        return companion;
    }

    public static Star GenerateSecondaryStar(Star primary, String orbitClass) throws Exception {
        Star secondary = new Star();

        boolean secondaryPresent = CheckForNonPrimaryPresence(primary);

        // Secondary present!
        if (secondaryPresent) {
            //System.out.println("Companion present!");
            Integer secondaryTypeRoll = roller.RollND6(2);
            if (primary.getStarClass().equals("III") || primary.getStarClass().equals("IV")) {
                secondaryTypeRoll--;
                if (secondaryTypeRoll < 2) {
                    secondaryTypeRoll = 2;
                }
            }

            //System.out.println("Companion Type Roll: " + secondaryTypeRoll);

            if (secondaryTypeRoll == 2 || secondaryTypeRoll == 3) {
                //TODO: Implement Other Table
                GenerateRandomNonPrimary(secondary, primary);
            } else if (secondaryTypeRoll == 4 || secondaryTypeRoll == 5 || secondaryTypeRoll == 6) {
                GenerateRandomNonPrimary(secondary, primary);
            } else if (secondaryTypeRoll == 7 || secondaryTypeRoll == 8) {
                GenerateLesserNonPrimary(secondary, primary);
            } else if (secondaryTypeRoll == 9 || secondaryTypeRoll == 10) {
                GenerateSiblingNonPrimary(secondary, primary);
            } else if (secondaryTypeRoll == 11 || secondaryTypeRoll == 12) {
                GenerateTwinNonPrimary(secondary, primary);
            }
            secondary.setOrbitClass("orbitClass");
            secondary.setParent(primary);
            secondary.setCompanion(GenerateCompanionStar(secondary));
        } else {
            secondary = null;
        }
        //System.out.println("Companion Object: " + secondary);
        return secondary;
    }

    private static boolean CheckForNonPrimaryPresence(Star primary) {
        // Check for occurrence of companion
        Integer nonPrimaryRoll = roller.RollND6(2);
        //System.out.println("Raw Companion Roll: " + nonPrimaryRoll);

        String primaryStarClass = primary.getStarClass();
        if (primaryStarClass.equals("Ia") || primaryStarClass.equals("Ib") || primaryStarClass.equals("II")
                || primaryStarClass.equals("III") || primaryStarClass.equals("IV")) {
            nonPrimaryRoll++;
        }
        String primaryStarType = primary.getType();
        if ((primaryStarClass.equals("V") || primaryStarClass.equals("VI"))
                && (primaryStarType.equals("O") || primaryStarType.equals("B") || primaryStarType.equals("A") || primaryStarType.equals("F"))) {
            nonPrimaryRoll++;
        }
        if ((primaryStarClass.equals("V") || primaryStarClass.equals("VI") && primaryStarType.equals("M"))) {
            nonPrimaryRoll--;
        }

        return nonPrimaryRoll >= 10;
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
            newType = starTables.TypeAdjacency.get(starTables.TypeAdjacency.indexOf(primary.getType() + 0) - 2).replaceAll("[0-9]", "");
        } else {
            newType = starTables.TypeAdjacency.get(starTables.TypeAdjacency.indexOf(primary.getType() + 5) - 1).replaceAll("[0-9]", "");
        }

        System.out.println("Secondary Type: " + newType);

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
                newType = starTables.TypeAdjacency.get(starTables.TypeAdjacency.indexOf(primary.getType() + 0) - 2).replaceAll("[0-9]", "");
            } else {
                newType = starTables.TypeAdjacency.get(starTables.TypeAdjacency.indexOf(primary.getType() + 5) - 1).replaceAll("[0-9]", "");
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
