package vandyke.Generation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vandyke.DataObjects.OrbitRange;
import vandyke.DataObjects.Primary;
import vandyke.DataObjects.SolarSystem;
import vandyke.Reference.MAOTables;
import vandyke.Reference.MinimumAllowableOrbit;
import vandyke.Reference.StarTables;
import vandyke.Repositories.MinimumAllowableOrbitRepository;
import vandyke.Utilites.ConversionUtilites;
import vandyke.Utilites.DiceRoller;
import vandyke.Utilites.Formulas;

import java.util.ArrayList;

@Service
public class WorldOrbitGenerator {

    private static final StarTables starTables = new StarTables();

    private static final MAOTables maoTables = new MAOTables();

    public void GenerateWorlds(SolarSystem system) throws Exception{
        GenerateBodyCount(system);
        AssignOrbits(system);
    }
    public void GenerateBodyCount(SolarSystem system) {
        // Gas Giants exist on 9 or less
        if (DiceRoller.RollND6(2) < 10) {
            int gasGiantRoll = DiceRoller.RollND6(2);
            if (system.getStarCount() == 1 && system.getPrimaryStar().getStarClass().equals("V")) {
                gasGiantRoll++;
            }
            if (system.getPrimaryStar().getType().equals("BD")) {
                gasGiantRoll -= 2;
            }
            //TODO: Implement properly when post stellar objects are added
            if (system.getPrimaryStar().getType().equals("POST STELLAR OBJECT")) {
                gasGiantRoll -= 2;
            }
            if (system.getPrimaryStar().getType().equals("POST STELLAR OBJECT COUNT")) {
                gasGiantRoll -= 1;
            }

            if (system.getStarCount() >= 4) {
                gasGiantRoll -= 1;
            }

            if (gasGiantRoll <= 4) {
                system.setGasGiants(1);
            } else if (gasGiantRoll <= 6) {
                system.setGasGiants(2);
            } else if (gasGiantRoll <= 8) {
                system.setGasGiants(3);
            } else if (gasGiantRoll <= 11) {
                system.setGasGiants(4);
            } else if (gasGiantRoll == 12) {
                system.setGasGiants(5);
            } else {
                system.setGasGiants(6);
            }
        } else {
            system.setGasGiants(0);
        }

        if (DiceRoller.RollND6(2) >= 8) {
            int beltRoll = DiceRoller.RollND6(2);
            if (system.getGasGiants() >= 1) {
                beltRoll++;
            }
            //TODO: Protostars, Primordial, Post Stellar Object

            if (system.getStarCount() >= 2) {
                beltRoll++;
            }

            if (beltRoll <= 6) {
                system.setPlanetoidBelts(1);
            } else if (beltRoll <= 11) {
                system.setPlanetoidBelts(2);
            } else {
                system.setPlanetoidBelts(3);
            }
        } else {
            system.setPlanetoidBelts(0);
        }

        int planetRoll = DiceRoller.RollND6(2) - 2;

        //TODO: Post Stellar Objects
        if (planetRoll < 3) {
            planetRoll = DiceRoller.RollDN(3) + 2;
        } else {
            planetRoll = planetRoll + DiceRoller.RollDN(3) - 1;
        }
        system.setTerrestrialPlanets(planetRoll);

        int emptyOrbits = DiceRoller.RollND6(2);
        if (emptyOrbits <= 9) {
            system.setEmptyOrbits(0);
        } else if (emptyOrbits == 10) {
            system.setEmptyOrbits(1);
        } else if (emptyOrbits == 11) {
            system.setEmptyOrbits(2);
        } else {
            system.setEmptyOrbits(3);
        }

        system.setOrbitSlots(system.getGasGiants() + system.getPlanetoidBelts() + system.getTerrestrialPlanets() + system.getEmptyOrbits());
    }

    private void AssignOrbits(SolarSystem system) throws Exception{
        //Calculate MAO
        Double minimumAllowableOrbit;

        // Use reference table
        Primary primary = system.getPrimaryStar();
        String type = system.getPrimaryStar().getType();
        Integer subType = system.getPrimaryStar().getSubType();
        String starClass = system.getPrimaryStar().getStarClass();
        String fullType = type + subType;

        if (system.getStarCount() == 1) {
            if (subType == 0 || subType == 5 || fullType.equals("M9")) {
                minimumAllowableOrbit = LookupReferenceMAO(fullType, starClass);
            } else {
                Double lowerReferenceMAO = LookupReferenceMAO(primary.getLowerAdjacentType(), starClass);
                Double upperReferenceMAO = LookupReferenceMAO(primary.getUpperAdjacentType(), starClass);

                if (starClass.equals("IV") && type.equals("K") && subType >= 1) {
                    //FIXME: fix these values
                    minimumAllowableOrbit = switch (subType) {
                        case 1 -> 1.55d;
                        case 2 -> 1.6d;
                        case 3 -> 1.65d;
                        case 4 -> 1.7d;
                        default -> null;
                    };
                    if (minimumAllowableOrbit == null) {
                        throw new Exception("MAO cannot equal null.");
                    }
                } else {
                    if (lowerReferenceMAO < upperReferenceMAO) {
                        minimumAllowableOrbit = lowerReferenceMAO + Formulas.Interpolate(primary.getSubTypeFraction(), lowerReferenceMAO, upperReferenceMAO);
                    } else {
                        minimumAllowableOrbit = upperReferenceMAO + Formulas.Interpolate(primary.getSubTypeFraction(), upperReferenceMAO, lowerReferenceMAO);
                    }
                }
            }

            primary.setMinimalAllowableOrbit(minimumAllowableOrbit);
            //primary.orbitLegality.add(new OrbitRange(false, 0.0, minimumAllowableOrbit));
            //primary.orbitLegality.add(new OrbitRange(true, minimumAllowableOrbit, 20.0));
        } else {
            // Pain

        }

        Double HZCO_AU = Math.sqrt(primary.getLuminosity());
        Double HZCO_OrbitNumber = ConversionUtilites.AUToOrbitNumber(HZCO_AU);

        ArrayList<Double> availableOrbits = new ArrayList<>();



    }

    public static void GenerateOrbitSlots(SolarSystem system) {

    }

    public static Double LookupReferenceMAO(String fullType, String starClass) {
        Double starMass = null;
        switch (starClass) {
            case "Ia" -> starMass = maoTables.Ia.get(fullType);
            case "Ib" -> starMass = maoTables.Ib.get(fullType);
            case "II" -> starMass = maoTables.II.get(fullType);
            case "III" -> starMass = maoTables.III.get(fullType);
            case "IV" -> starMass = maoTables.IV.get(fullType);
            case "V" -> starMass = maoTables.V.get(fullType);
            case "VI" -> starMass = maoTables.VI.get(fullType);
        }
        return starMass;
    }


    // Revisit this later if going with real DB lookups
    public static Double LookupReferenceMAO(String fullType, String starClass, MinimumAllowableOrbit MAO) {
        Double starMAO = null;
        switch (starClass) {
            case "Ia" -> starMAO = MAO.getIa();
            case "Ib" -> starMAO = MAO.getIb();
            case "II" -> starMAO = MAO.getII();
            case "III" -> starMAO = MAO.getIII();
            case "IV" -> starMAO = MAO.getIV();
            case "V" -> starMAO = MAO.getV();
            case "VI" -> starMAO = MAO.getVI();
        }
        return starMAO;
    }

    private Double LookupMAOByClass(MinimumAllowableOrbit MAO, String starClass) {
        Double result = null;
        switch (starClass) {
            case "Ia":
                result = MAO.getIa();
            case "Ib":
                result = MAO.getIb();
            case "II":
                result = MAO.getII();
            case "III":
                result = MAO.getIII();
            case "IV":
                result = MAO.getIV();
            case "V":
                result = MAO.getV();
            case "VI":
                result = MAO.getVI();
        }
        return result;
    }
}
