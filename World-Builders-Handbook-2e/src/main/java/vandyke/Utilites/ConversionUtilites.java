package vandyke.Utilites;

import vandyke.Reference.OrbitNumberTable;

public class ConversionUtilites {

    private static final OrbitNumberTable orbitTable = new OrbitNumberTable();

    public static Double OrbitNumberToAU(Double orbitNumber) {
        Integer wholeOrbitNumber = Integer.parseInt(orbitNumber.toString().substring(0, orbitNumber.toString().indexOf(".")));
        Double fractionalOrbitNumber = Double.parseDouble(orbitNumber.toString().substring(orbitNumber.toString().indexOf(".")));
        return (Double) (orbitTable.DistanceAU.get(wholeOrbitNumber) + (orbitTable.DifferenceAU.get(wholeOrbitNumber) * fractionalOrbitNumber));
    }
}
