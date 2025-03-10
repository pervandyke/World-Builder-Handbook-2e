package vandyke.generation;

import vandyke.constant.BodyConstants;
import vandyke.data.persistence.*;
import vandyke.reference.MAOTables;
import vandyke.reference.StarTables;
import vandyke.utility.UnitConversionUtil;
import vandyke.utility.DiceRoller;
import vandyke.utility.Formulas;
import vandyke.utility.NamingUtilities;

import java.util.ArrayList;

public class WorldGenerator {

    private static final StarTables starTables = new StarTables();

    private static final MAOTables maoTables = new MAOTables();

    public void GenerateWorlds(StarSystem system){
        generateBodyCount(system);
        assignOrbits(system);
        generateWorldDetails(system);
    }
    public void generateBodyCount(StarSystem system) {
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

    private void assignOrbits(StarSystem system) {
        //Calculate MAO
        Double minimumAllowableOrbit = null;

        // Use reference table
        Primary primary = system.getPrimaryStar();
        String type = system.getPrimaryStar().getType();
        Integer subType = system.getPrimaryStar().getSubType();
        String starClass = system.getPrimaryStar().getStarClass();
        String fullType = type + subType;

        if (true || system.getStarCount() == 1) {
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
                        throw new IllegalStateException("MAO cannot equal null.");
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

        double HZCO_AU = Math.sqrt(primary.getLuminosity());
        double HZCO_OrbitNumber = UnitConversionUtil.AUToOrbitNumber(HZCO_AU);

        primary.setHabitableZoneCenterOrbit(HZCO_OrbitNumber);

        // Determine System Baseline Number
        //TODO: check if HZCO is legal orbit
        int totalWorlds = system.getPlanetoidBelts() + system.getGasGiants() + system.getTerrestrialPlanets();

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

        system.setSystemSpread(spread);

        ArrayList<Double> availableOrbits = new ArrayList<>();

        availableOrbits.add((minimumAllowableOrbit + spread) + (((DiceRoller.RollND6(2) - 7) * spread) / 10));
        for (int i = 1; i < totalWorlds + system.getEmptyOrbits(); i++) {
            availableOrbits.add((availableOrbits.get(i-1) + spread) + (((DiceRoller.RollND6(2) - 7) * spread) / 10));
        }
        // TODO: figure out anomalous orbits

        initializeWorlds(system, totalWorlds, availableOrbits, primary);

        NamingUtilities.NumberChildren(primary);
    }

    private static void generateWorldDetails(StarSystem system) {
        // Set planet sizes / orbital periods for all children
        for (DiscreteBody body : system.getPrimaryStar().getChildren()) {
            OrbitalBody orbitalBody = (OrbitalBody) body;
            WorldCharacteristicsGenerator.setBasicPlanetSize(orbitalBody, system);
            WorldCharacteristicsGenerator.calculateOrbitalPeriod(orbitalBody, system);
            WorldCharacteristicsGenerator.generateMoonsAndRings(orbitalBody);
        }
    }

    private static void initializeWorlds(StarSystem system, int totalWorlds, ArrayList<Double> availableOrbits, Primary primary) {
        for (int i = 0; i < totalWorlds + system.getEmptyOrbits(); i++) {
            if (system.getEmptyOrbits() > 0) {
                availableOrbits.remove(DiceRoller.randInt(0, availableOrbits.size()).intValue());
                system.setEmptyOrbits(system.getEmptyOrbits()-1);
                continue;
            }
            if (system.getGasGiants() > 0) {
                double orbitNumber = availableOrbits.remove(DiceRoller.randInt(0, availableOrbits.size()).intValue());
                OrbitalBody newGasGiant = new OrbitalBody(BodyConstants.GAS_GIANT);
                newGasGiant.setOrbitNumber(orbitNumber);
                newGasGiant.setGasGiantInfo(new GasGiantInfo());
                primary.addChild(newGasGiant);
                system.setGasGiants(system.getGasGiants()-1);
                continue;
            }
            if (system.getPlanetoidBelts() > 0) {
                double orbitNumber = availableOrbits.remove(DiceRoller.randInt(0, availableOrbits.size()).intValue());
                OrbitalBody newBelt = new OrbitalBody(BodyConstants.ASTEROID_BELT);
                newBelt.setOrbitNumber(orbitNumber);
                newBelt.setBeltInfo(new AsteroidBeltInfo());
                primary.addChild(newBelt);
                system.setPlanetoidBelts(system.getPlanetoidBelts()-1);
                continue;
            }
            if (system.getTerrestrialPlanets() > 0) {
                double orbitNumber = availableOrbits.remove(DiceRoller.randInt(0, availableOrbits.size()).intValue());
                OrbitalBody newPlanet = new OrbitalBody(BodyConstants.TERRESTRIAL);
                newPlanet.setOrbitNumber(orbitNumber);
                newPlanet.setTerrestrialInfo(new TerrestrialInfo());
                primary.addChild(newPlanet);
                system.setTerrestrialPlanets(system.getTerrestrialPlanets()-1);
            }
        }
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
}
