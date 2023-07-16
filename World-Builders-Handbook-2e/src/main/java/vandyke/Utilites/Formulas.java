package vandyke.Utilites;

public class Formulas {

    public static Double Interpolate(Double percentage, Double lowerValue, Double upperValue) {
        Double difference = upperValue - lowerValue;
        //System.out.println("difference: " + difference);
        Double interpolatedResult = difference * percentage;
        //System.out.println("interpolated result: " + interpolatedResult);
        return interpolatedResult;
    }
}
