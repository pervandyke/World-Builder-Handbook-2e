package vandyke.Utilites;

public class Formulas {

    public static Float Interpolate(Float percentage, Float lowerValue, Float upperValue) {
        Float difference = upperValue - lowerValue;
        //System.out.println("difference: " + difference);
        Float interpolatedResult = difference * percentage;
        //System.out.println("interpolated result: " + interpolatedResult);
        return interpolatedResult;
    }
}
