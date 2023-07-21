package vandyke.Utilites;

import vandyke.DataObjects.Comparators.DiscreteBodyComparator;
import vandyke.DataObjects.DiscreteBody;
import vandyke.DataObjects.GasGiant;
import vandyke.DataObjects.Terrestrial;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class NamingUtilities {

    public static String GeneratePlanetName() throws Exception{
        URL url =  NamingUtilities.class.getResource("/Elite/getName.py");
        String namePath = url.getPath().trim().replaceFirst("/", "");
        ProcessBuilder processBuilder = new ProcessBuilder("python", namePath);
        processBuilder.redirectErrorStream(true);

        Process process = processBuilder.start();
        String result = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

        int exitCode = process.waitFor();
        return result;
    }

    public static void NumberChildren(DiscreteBody parent) {
        parent.children.sort(new DiscreteBodyComparator());
        int planets = 1;
        int belts = 1;
        for (DiscreteBody body : parent.children) {
            if (body.getClass() == Terrestrial.class || body.getClass() == GasGiant.class) {
                body.setName(parent.getName() + " " + ArabicRomanConversion.ArabicToRoman(planets));
                planets++;
            } else {
                body.setName(parent.getName() + " Belt " + ArabicRomanConversion.ArabicToRoman(belts));
                belts++;
            }
        }
    }

}
