package vandyke.utility;

import vandyke.constant.BodyConstants;
import vandyke.data.comparator.DiscreteBodyComparator;
import vandyke.data.persistence.DiscreteBody;
import vandyke.data.persistence.OrbitalBody;

public class NamingUtilities {

    public static String GeneratePlanetName() throws Exception{
        return ElitePlanet.getPlanetName();
    }

    public static void NumberChildren(DiscreteBody parent) {
        parent.getChildren().sort(new DiscreteBodyComparator());
        int planets = 1;
        int belts = 1;
        for (DiscreteBody body : parent.getChildren()) {
            OrbitalBody orbitalBody = (OrbitalBody) body;
            if (!orbitalBody.getOrbitalBodyClass().equals(BodyConstants.ASTEROID_BELT)) {
                body.setName(parent.getName() + " " + ArabicRomanConversion.ArabicToRoman(planets));
                planets++;
            } else {
                body.setName(parent.getName() + " Belt " + ArabicRomanConversion.ArabicToRoman(belts));
                belts++;
            }
        }
    }

}
