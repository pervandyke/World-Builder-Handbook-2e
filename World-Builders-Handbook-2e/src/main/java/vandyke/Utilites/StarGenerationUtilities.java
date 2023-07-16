package vandyke.Utilites;

import vandyke.DataObjects.Star;
import vandyke.Generation.StarGenerator;
import vandyke.Reference.StarTables;

import java.util.Objects;

public class StarGenerationUtilities {

    private static final DiceRoller roller = new DiceRoller();

    private static final StarTables starTables = new StarTables();
    public static void CalculateMassAndTemperature(Star star) throws Exception{
        // Calculate Mass and Temperature
        Float mass;
        Integer temperature;

        String fullType = star.getType() + star.getSubType();
        //System.out.println("fullType: " + fullType);
        String upperAdjacentType = null;
        String lowerAdjacentType = null;

        if (star.getSubType() == 0 || star.getSubType() == 5 || fullType.equals("M9")) {
            mass = LookupReferenceMass(fullType, star.getStarClass());
            temperature = starTables.Temperature.get(fullType);
        } else {
            if (star.getSubType() < 5) {
                lowerAdjacentType = starTables.TypeAdjacency.get(starTables.TypeAdjacency.indexOf(star.getType() + 5));
                upperAdjacentType = starTables.TypeAdjacency.get(starTables.TypeAdjacency.indexOf(star.getType() + 0));
            } else {
                lowerAdjacentType = starTables.TypeAdjacency.get(starTables.TypeAdjacency.indexOf(star.getType() + 5) - 1);
                upperAdjacentType = starTables.TypeAdjacency.get(starTables.TypeAdjacency.indexOf(star.getType() + 5));
            }

            //System.out.println("Upper Adjacent Type: " + upperAdjacentType);
            //System.out.println("Lower Adjacent Type: " + lowerAdjacentType);

            // Get subTypeFraction
            float subTypeFraction;
            float lowerReferenceSubType = Float.parseFloat(lowerAdjacentType.replaceAll("[A-Za-z]", ""));
            //System.out.println("Lower Reference Sub Type: " + lowerReferenceSubType);
            float upperReferenceSubType = Float.parseFloat(upperAdjacentType.replaceAll("[A-Za-z]", ""));
            //System.out.println("Upper Reference Sub Type: " + upperReferenceSubType);
            float referenceRange;
            if (lowerAdjacentType.endsWith("0")) {
                referenceRange = 10f - upperReferenceSubType;
            } else {
                referenceRange = lowerReferenceSubType - upperReferenceSubType;
            }
            //System.out.println("Reference range: " + referenceRange);

            Float lowerReferenceMass = LookupReferenceMass(lowerAdjacentType, star.getStarClass());
            Float upperReferenceMass = LookupReferenceMass(upperAdjacentType, star.getStarClass());

            if (star.getSubType() > referenceRange) {
                subTypeFraction = (star.getSubType() - referenceRange) / referenceRange;
            } else {
                subTypeFraction = star.getSubType() / referenceRange;
            }

            //System.out.println("Subtype fraction is: " + subTypeFraction);

            if (star.getStarClass().equals("IV") && star.getType().equals("K") && star.getSubType() >= 1) {
                mass = switch (star.getSubType()) {
                    case 1 -> 1.55f;
                    case 2 -> 1.6f;
                    case 3 -> 1.65f;
                    case 4 -> 1.7f;
                    default -> null;
                };
                if (mass == null) {
                    throw new Exception("Mass cannot equal null.");
                }
            } else {
                if (lowerReferenceMass < upperReferenceMass) {
                    mass = lowerReferenceMass + Formulas.Interpolate(subTypeFraction, lowerReferenceMass, upperReferenceMass);
                } else {
                    mass = upperReferenceMass + Formulas.Interpolate(subTypeFraction, upperReferenceMass, lowerReferenceMass);
                }

            }

            Integer upperReferenceTemperature = starTables.Temperature.get(upperAdjacentType);
            //System.out.println("Upper Reference Temperature: " + upperReferenceTemperature);
            Integer lowerReferenceTemperature = starTables.Temperature.get(lowerAdjacentType);
            //System.out.println("Lower Reference Temperature: " + lowerReferenceTemperature);
            temperature = upperReferenceTemperature - Formulas.Interpolate(subTypeFraction, lowerReferenceTemperature.floatValue(), upperReferenceTemperature.floatValue()).intValue();
        }

        // Apply max 20% variance to mass
        mass = mass + (mass * roller.randVariance(20));

        star.setMass(mass);
        star.setTemperature(temperature);
    }

    public static void CalculateDiameter(Star star) throws Exception{
        // Calculate Mass and Temperature
        Float diameter;

        String fullType = star.getType() + star.getSubType();
        //System.out.println("fullType: " + fullType);
        String upperAdjacentType = null;
        String lowerAdjacentType = null;

        if (star.getSubType() == 0 || star.getSubType() == 5 || fullType.equals("M9")) {
            diameter = LookupReferenceDiameter(fullType, star.getStarClass());
        } else {
            if (star.getSubType() < 5) {
                lowerAdjacentType = starTables.TypeAdjacency.get(starTables.TypeAdjacency.indexOf(star.getType() + 5));
                upperAdjacentType = starTables.TypeAdjacency.get(starTables.TypeAdjacency.indexOf(star.getType() + 0));
            } else {
                lowerAdjacentType = starTables.TypeAdjacency.get(starTables.TypeAdjacency.indexOf(star.getType() + 5) - 1);
                upperAdjacentType = starTables.TypeAdjacency.get(starTables.TypeAdjacency.indexOf(star.getType() + 5));
            }

            //System.out.println("Upper Adjacent Type: " + upperAdjacentType);
            //System.out.println("Lower Adjacent Type: " + lowerAdjacentType);

            // Get subTypeFraction
            float subTypeFraction;
            float lowerReferenceSubType = Float.parseFloat(lowerAdjacentType.replaceAll("[A-Za-z]", ""));
            //System.out.println("Lower Reference Sub Type: " + lowerReferenceSubType);
            float upperReferenceSubType = Float.parseFloat(upperAdjacentType.replaceAll("[A-Za-z]", ""));
            //System.out.println("Upper Reference Sub Type: " + upperReferenceSubType);
            float referenceRange;
            if (lowerAdjacentType.endsWith("0")) {
                referenceRange = 10f - upperReferenceSubType;
            } else {
                referenceRange = lowerReferenceSubType - upperReferenceSubType;
            }
            //System.out.println("Reference range: " + referenceRange);

            Float lowerReferenceDiameter = LookupReferenceDiameter(lowerAdjacentType, star.getStarClass());
            Float upperReferenceDiameter = LookupReferenceDiameter(upperAdjacentType, star.getStarClass());

            if (star.getSubType() > referenceRange) {
                subTypeFraction = (star.getSubType() - referenceRange) / referenceRange;
            } else {
                subTypeFraction = star.getSubType() / referenceRange;
            }

            //System.out.println("Subtype fraction is: " + subTypeFraction);

            if (star.getStarClass().equals("IV") && star.getType().equals("K") && star.getSubType() >= 1) {
                diameter = switch (star.getSubType()) {
                    //FIXME: THESE VALUES ARE GUESS VALUES, FIX ASAP
                    case 1 -> 6.8f;
                    case 2 -> 7.5f;
                    case 3 -> 8.3f;
                    case 4 -> 9f;
                    default -> null;
                };
                if (diameter == null) {
                    throw new Exception("Diameter cannot equal null.");
                }
            } else {
                if (lowerReferenceDiameter < upperReferenceDiameter) {
                    diameter = lowerReferenceDiameter + Formulas.Interpolate(subTypeFraction, lowerReferenceDiameter, upperReferenceDiameter);
                } else {
                    diameter = upperReferenceDiameter + Formulas.Interpolate(subTypeFraction, upperReferenceDiameter, lowerReferenceDiameter);
                }
            }
        }
        star.setDiameter(diameter);
    }
    public static Float CalculateLuminosity(Star star) {
        return (float)(Math.pow(star.getDiameter(), 2d) * Math.pow(star.getTemperature() / 5772d, 4d));
    }

    public static Float CalculateLifespan(Star star) {
        //TODO: Implement Giant and Sub-Giant lifespan calculation
        return (float)(10/Math.pow(star.getMass(), 2.5d));
    }

    public static Star GenerateCompanions(Star primary) throws Exception {
        return StarGenerator.GenerateCompanionStar(primary);
    }

    public static void GenerateTypeAndClass(Star star) {
        GenerateTypeAndClass(star, null, null);
    }

    public static void GenerateTypeAndClass(Star star, String type) {
        GenerateTypeAndClass(star, type, null);
    }

    public static void GenerateTypeAndClass(Star star, String setType, String setClass) {
        // Generate star type, class, and subclass
        Integer typeRoll = rollType(0);

        String type = Objects.requireNonNullElse(setType, starTables.Type.get(typeRoll));
        String starClass = Objects.requireNonNullElse(setClass, "V");

        if (type.equals("Special")) {
            String specialResult = starTables.Special.get(roller.RollND6(2));
            switch (specialResult) {
                case "Class VI" -> {
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
                }
                case "Class IV" -> {
                    starClass = "IV";
                    typeRoll = rollType(1);
                    if (3 >= typeRoll || typeRoll <= 6) {
                        typeRoll = typeRoll + 5;
                    }
                    type = starTables.Type.get(typeRoll);
                    if (type.equals("Hot")) {
                        type = starTables.Hot.get(roller.RollND6(2));
                        if (type.equals("O")) {
                            type = "B";
                        }
                    }
                }
                case "Class III" -> {
                    starClass = "III";
                    typeRoll = rollType(1);
                    type = starTables.Type.get(typeRoll);
                    if (type.equals("Hot")) {
                        type = starTables.Hot.get(roller.RollND6(2));
                    }
                }
                default -> {
                    // Roll on Giants
                    Integer giantsRoll = roller.RollND6(2);
                    String giantsResult = starTables.Giants.get(giantsRoll);
                    starClass = giantsResult.replaceFirst("Class ", "");
                    typeRoll = rollType(1);
                    type = starTables.Type.get(typeRoll);
                }
            }
        } else if (type.equals("Hot")) {
            type = starTables.Hot.get(roller.RollND6(2));
        }
        star.setType(type);
        star.setStarClass(starClass);
        //System.out.println("Star Class: " + star.getStarClass());
        // Set subtype
        Integer subType = roller.randInt(0, 10);
        if (star.getType().equals("K") && star.getStarClass().equals("IV") && subType > 4) {
            subType = subType-5;
        }
        star.setSubType(subType);
    }

    public static Float GenerateAge(Star star) {
        float age;

        if (star.getMass() >= 0.9f) {
            age = star.getLifespan() * ((roller.RollDN(100)/100f));
        } else {
            age = roller.RollDN(6) * 2f + roller.RollDN(3) - 2f + (roller.RollDN(10)/10f);
        }
        //TODO: Implement Giant and Sub-Giant age generation
        return age;
    }

    public static Float LookupReferenceDiameter(String fullType, String starClass) {
        Float diameter = null;
        switch (starClass) {
            case "Ia" -> diameter = starTables.IaDiameter.get(fullType);
            case "Ib" -> diameter = starTables.IbDiameter.get(fullType);
            case "II" -> diameter = starTables.IIDiameter.get(fullType);
            case "III" -> diameter = starTables.IIIDiameter.get(fullType);
            case "IV" -> diameter = starTables.IVDiameter.get(fullType);
            case "V" -> diameter = starTables.VDiameter.get(fullType);
            case "VI" -> diameter = starTables.VIDiameter.get(fullType);
        }
        return diameter;
    }

    public static Float LookupReferenceMass(String fullType, String starClass) {
        Float starMass = null;
        switch (starClass) {
            case "Ia" -> starMass = starTables.Ia.get(fullType);
            case "Ib" -> starMass = starTables.Ib.get(fullType);
            case "II" -> starMass = starTables.II.get(fullType);
            case "III" -> starMass = starTables.III.get(fullType);
            case "IV" -> starMass = starTables.IV.get(fullType);
            case "V" -> starMass = starTables.V.get(fullType);
            case "VI" -> starMass = starTables.VI.get(fullType);
        }
        return starMass;
    }

    public static Integer rollType(Integer modifier) {
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
