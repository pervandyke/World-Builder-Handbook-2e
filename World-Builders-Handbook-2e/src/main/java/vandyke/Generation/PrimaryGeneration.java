package vandyke.Generation;

import vandyke.DataObjects.Star;
import vandyke.Reference.StarTables;
import vandyke.Utilites.DiceRoller;

public class PrimaryGeneration {

    StarTables starTables = new StarTables();

    DiceRoller roller = new DiceRoller();

    public Star Generate() throws Exception {
        Star primary = new Star();
        // Initial Roll
        Integer typeRoll = rollType(0);
        String type = "Special";//starTables.Type.get(typeRoll);
        String starClass = "V";
        if (type.equals("Special")) {
            String specialResult = starTables.Special.get(roller.RollND6(2));
            if (specialResult.equals("Class VI")) {
                starClass = "VI";
                typeRoll = rollType(1);
                type = starTables.Type.get(typeRoll);
                if (type.equals("Hot")) {
                    type = starTables.Hot.get(roller.RollND6(2));
                }
                if (type.equals("F")) {
                    type = "G";
                } else if (type.equals("A")) {
                    type = "B";
                }
            } else if (specialResult.equals("Class IV")) {
                starClass = "IV";
                typeRoll = rollType(1);
                if (3 >= typeRoll || typeRoll >= 6) {
                    typeRoll = typeRoll + 5;
                }
                type = starTables.Type.get(typeRoll);
                if (type.equals("Hot")) {
                    type = starTables.Hot.get(roller.RollND6(2));
                    if (type.equals("O")) {
                        type = "B";
                    }
                }
            } else if (specialResult.equals("Class III")) {
                starClass = "III";
                typeRoll = rollType(1);
                type = starTables.Type.get(typeRoll);
            } else {
                // Roll of Giants
                Integer giantsRoll = roller.RollND6(2);
                String giantsResult = starTables.Giants.get(giantsRoll);
                starClass = giantsResult.replaceFirst("Class ", "");
            }
        } else if (type.equals("Hot")) {
            type = starTables.Hot.get(roller.RollND6(2));
        }
        primary.setType(type);
        primary.setStarClass(starClass);
        // Set subtype
        Integer subType = roller.randInt(0, 10);
        if (primary.getType().equals("K") && primary.getStarClass().equals("IV") && subType > 4) {
            subType = subType-5;
        }
        primary.setSubType(subType);

        return primary;
    }

    private Integer rollType(Integer modifier) {
        int roll = roller.RollND6(2) + modifier;
        if (roll < 2) {
            roll = 2;
        }
        if (roll > 12) {
            roll = 12;
        }
        return roll;
    }

}
