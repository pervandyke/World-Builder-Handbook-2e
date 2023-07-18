package vandyke.Generation;

import org.springframework.stereotype.Service;
import vandyke.DataObjects.*;
import vandyke.DataObjects.Comparators.DiscreteBodyComparator;
import vandyke.Reference.MAOTables;
import vandyke.Reference.MinimumAllowableOrbit;
import vandyke.Reference.StarTables;
import vandyke.Utilites.ConversionUtilites;
import vandyke.Utilites.DiceRoller;
import vandyke.Utilites.Formulas;
import vandyke.Utilites.NamingUtilities;

import java.util.ArrayList;

@Service
public class WorldOrbitGenerator {

    private static final StarTables starTables = new StarTables();

    private static final MAOTables maoTables = new MAOTables();

    public void GenerateWorlds(StarSystem system) throws Exception{
        GenerateBodyCount(system);
        AssignOrbits(system);
    }
    public void GenerateBodyCount(StarSystem system) {
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

    private void AssignOrbits(StarSystem system) throws Exception{
        //Calculate MAO
        Double minimumAllowableOrbit = null;

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

        // Determine System Baseline Number
        //TODO: check if HZCO is legal orbit
        int totalWorlds = system.getPlanetoidBelts() + system.getGasGiants() + system.getTerrestrialPlanets();

        if (true) {
            int baselineRoll = DiceRoller.RollND6(2);
            if (primary.getCompanion() != null) {
                baselineRoll -= 2;
            }
            switch (primary.getStarClass()) {
                case "Ia", "Ib", "II" -> baselineRoll += 3;
                case "III" -> baselineRoll += 2;
                case "IV" -> baselineRoll += 1;
                case "VI" -> baselineRoll -= 1;
            }
            //TODO: post stellar objects

            if (totalWorlds < 6) {
                baselineRoll -= 4;
            } else if (totalWorlds < 9) {
                baselineRoll -= 3;
            } else if (totalWorlds < 12) {
                baselineRoll -= 2;
            } else if (totalWorlds < 15) {
                baselineRoll -= 1;
            } else if (totalWorlds < 20) {
                baselineRoll += 1;
            } else {
                baselineRoll += 2;
            }
            system.setSystemBaselineNumber(baselineRoll);
        }

        int baselineNumber = system.getSystemBaselineNumber();
        double baselineOrbitNumber;
        // Calculate Baseline Orbit #
        if (baselineNumber > 1 && baselineNumber < totalWorlds) {
            if (HZCO_OrbitNumber >= 1) {
                baselineOrbitNumber = HZCO_OrbitNumber + ((double)(DiceRoller.RollND6(2) - 7) / 10);
            } else {
                baselineOrbitNumber = HZCO_OrbitNumber + ((double)(DiceRoller.RollND6(2) - 7) / 100);
            }
        } else if (baselineNumber < 1) {
            if (minimumAllowableOrbit >= 1) {
                baselineOrbitNumber = HZCO_OrbitNumber - baselineNumber + totalWorlds + ((double)(DiceRoller.RollND6(2) - 2) / 10);
            } else {
                baselineOrbitNumber = minimumAllowableOrbit - ((double)baselineNumber/10) + ((double)(DiceRoller.RollND6(2) - 2) / 100);
            }
        } else {
            if (HZCO_OrbitNumber - baselineNumber + totalWorlds >= 1) {
                baselineOrbitNumber = HZCO_OrbitNumber - baselineNumber + totalWorlds + ((double)(DiceRoller.RollND6(2) - 7) / 5);
            } else {
                baselineOrbitNumber = HZCO_OrbitNumber - (baselineNumber + totalWorlds + ((double)(DiceRoller.RollND6(2) - 7) / 5) / 10);
                if (baselineOrbitNumber < 0) {
                    baselineOrbitNumber = HZCO_OrbitNumber - 0.1;
                    double lowerBound = primary.getMinimalAllowableOrbit() + totalWorlds * 0.01;
                    if (baselineOrbitNumber < lowerBound) {
                        baselineOrbitNumber = lowerBound;
                    }
                }
            }
        }

        system.setSystemBaselineOrbitNumber(baselineOrbitNumber);

        double spread = (baselineOrbitNumber - minimumAllowableOrbit) / baselineNumber;

        // This calculation only works for single stars
        if (minimumAllowableOrbit + (spread * (totalWorlds + system.getEmptyOrbits())) > 20) {
            spread = (20 - minimumAllowableOrbit) / (totalWorlds + system.getEmptyOrbits() + 1);
        }

        ArrayList<Double> availableOrbits = new ArrayList<>();

        availableOrbits.add((minimumAllowableOrbit + spread) + (((DiceRoller.RollND6(2) - 7) * spread) / 10));
        for (int i = 1; i < totalWorlds + system.getEmptyOrbits(); i++) {
            availableOrbits.add((availableOrbits.get(i-1) + spread) + (((DiceRoller.RollND6(2) - 7) * spread) / 10));
        }
        // TODO: figure out anomalous orbits

        //TODO: modularize so can be applied to secondaries
        for (int i = 0; i < totalWorlds + system.getEmptyOrbits(); i++) {
            if (system.getEmptyOrbits() > 0) {
                availableOrbits.remove(DiceRoller.randInt(0, availableOrbits.size()).intValue());
                system.setEmptyOrbits(system.getEmptyOrbits()-1);
                continue;
            }
            if (system.getGasGiants() > 0) {
                double orbitNumber = availableOrbits.remove(DiceRoller.randInt(0, availableOrbits.size()).intValue());
                GasGiant newGasGiant = new GasGiant();
                newGasGiant.setOrbitNumber(orbitNumber);
                primary.children.add(newGasGiant);
                system.setGasGiants(system.getGasGiants()-1);
                continue;
            }
            if (system.getPlanetoidBelts() > 0) {
                double orbitNumber = availableOrbits.remove(DiceRoller.randInt(0, availableOrbits.size()).intValue());
                PlanetoidBelt newBelt = new PlanetoidBelt();
                newBelt.setOrbitNumber(orbitNumber);
                primary.children.add(newBelt);
                system.setPlanetoidBelts(system.getPlanetoidBelts()-1);
                continue;
            }
            if (system.getTerrestrialPlanets() > 0) {
                double orbitNumber = availableOrbits.remove(DiceRoller.randInt(0, availableOrbits.size()).intValue());
                Terrestrial newPlanet = new Terrestrial();
                newPlanet.setOrbitNumber(orbitNumber);
                primary.children.add(newPlanet);
                system.setTerrestrialPlanets(system.getTerrestrialPlanets()-1);
            }
        }

        primary.children.sort(new DiscreteBodyComparator());
        for (int i = 1; i < primary.children.size()+1; i++) {
            primary.children.get(i-1).setName(primary.getName() + " " + i);
        }
    }

    public static void GenerateOrbitSlots(StarSystem system) {

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
