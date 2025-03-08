package vandyke.utility;

import vandyke.constant.BodyConstants;
import vandyke.data.comparator.DiscreteBodyComparator;
import vandyke.data.persistence.DiscreteBody;
import vandyke.data.persistence.Planet;

import java.net.URL;
import java.nio.charset.StandardCharsets;

public class NamingUtilities {

    public static String GeneratePlanetName() throws Exception{
        /*URL url =  NamingUtilities.class.getResource("/Elite/getName.py");
        String namePath = url.getPath().trim().replaceFirst("/", "");
        ProcessBuilder processBuilder;
        if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) {
            processBuilder = new ProcessBuilder("python", namePath);
        } else {
            processBuilder = new ProcessBuilder("python3", namePath);
        }

        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        String result = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

        int exitCode = process.waitFor();
        return result;*/

        return ElitePlanets.getPlanetName();
    }

    public static void NumberChildren(DiscreteBody parent) {
        parent.getChildren().sort(new DiscreteBodyComparator());
        int planets = 1;
        int belts = 1;
        for (DiscreteBody body : parent.getChildren()) {
            Planet planet = (Planet) body;
            if (!planet.getPlanetClass().equals(BodyConstants.ASTEROID_BELT)) {
                body.setName(parent.getName() + " " + ArabicRomanConversion.ArabicToRoman(planets));
                planets++;
            } else {
                body.setName(parent.getName() + " Belt " + ArabicRomanConversion.ArabicToRoman(belts));
                belts++;
            }
        }
    }

}
