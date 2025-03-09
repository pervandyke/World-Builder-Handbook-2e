package vandyke.generation;

import vandyke.constant.BodyConstants;
import vandyke.data.persistence.OrbitalBody;
import vandyke.data.persistence.StarSystem;
import vandyke.utility.DiceRoller;
import vandyke.utility.UnitConversionUtil;

public class WorldCharacteristicsGenerator {

    public static void setBasicPlanetSize(final OrbitalBody orbitalBody, final StarSystem system) {
        if (orbitalBody.getOrbitalBodyClass().equals(BodyConstants.TERRESTRIAL)) {
            // First roll
            int rollOne = DiceRoller.RollND6(1);
            int sizeRoll;
            if (rollOne <= 2) {
                sizeRoll = DiceRoller.RollND6(1);
            } else if (rollOne <= 4) {
                sizeRoll = DiceRoller.RollND6(2);
            } else {
                sizeRoll = DiceRoller.RollND6(2) + 3;
            }
            orbitalBody.getTerrestrialInfo().setTerrestrialWorldSize(sizeRoll);
        } else if (orbitalBody.getOrbitalBodyClass().equals(BodyConstants.GAS_GIANT)) {
            // Determine diameter in gas giant diameters (1 = 8*Earth's Diameter)
            int modifier = 0;
            if (system.getSystemSpread() < 0.1d) {
                modifier--;
            }
            if (system.getPrimaryStar().getType().equals("BD") || (system.getPrimaryStar().getType().equals("M") && system.getPrimaryStar().getStarClass().equals("V")) || system.getPrimaryStar().getStarClass().equals("VI")) {
                modifier--;
            }

            int basicSize = DiceRoller.RollND6(1) - modifier;
            int diameter;
            int mass;
            if (basicSize <= 2) {
                diameter = DiceRoller.RollXDN(2, 3);
                mass = (DiceRoller.RollND6(1) + 1) * 5;
            } else if (basicSize <= 4) {
                diameter = DiceRoller.RollND6(1) + 6;
                mass = (DiceRoller.RollND6(3) - 1) * 20;
            } else {
                diameter = DiceRoller.RollND6(2) + 6;
                mass = DiceRoller.RollDN(3) * 50 * (DiceRoller.RollND6(3) + 4);
                if (mass >= 3000) {
                    mass = 4000 - ((DiceRoller.RollND6(2) - 2) * 200);
                }
            }
            orbitalBody.getGasGiantInfo().setGasGiantDiameter(diameter);
            orbitalBody.getGasGiantInfo().setGasGiantMass(mass);
        }
    }

    public static void calculateOrbitalPeriod(final OrbitalBody body, final StarSystem system) {
        //TODO: Make work with multiple stars

        // Set orbital Period in Days
        body.setOrbitalPeriod(Math.sqrt(Math.pow(UnitConversionUtil.OrbitNumberToAU(body.getOrbitNumber()), 3) / system.getPrimaryStar().getMass()) * 365.25);

        /* This was causing gas giants on interior orbits to have longer periods than planets on exterior orbits
        if (!(body.getOrbitalBodyClass().equals(BodyConstants.GAS_GIANT) && body.getGasGiantMass() > 350)) {
            body.setOrbitalPeriod(Math.sqrt(Math.pow(UnitConversionUtil.OrbitNumberToAU(body.getOrbitNumber()), 3) / system.getPrimaryStar().getMass()) * 365.25);
            return;
        }
        body.setOrbitalPeriod(Math.sqrt(Math.pow(UnitConversionUtil.OrbitNumberToAU(body.getOrbitNumber()), 3) / system.getPrimaryStar().getMass() + (body.getGasGiantMass() * 0.000003d)) * 365.25);
        */
    }

}
