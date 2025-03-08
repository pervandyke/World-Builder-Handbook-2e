package vandyke.utility;

import vandyke.reference.OrbitNumberTable;

public class UnitConversionUtil {

    private static final OrbitNumberTable orbitTable = new OrbitNumberTable();

    public static Double OrbitNumberToAU(Double orbitNumber) {
        Integer wholeOrbitNumber = Integer.parseInt(orbitNumber.toString().substring(0, orbitNumber.toString().indexOf(".")));
        Double fractionalOrbitNumber = Double.parseDouble(orbitNumber.toString().substring(orbitNumber.toString().indexOf(".")));
        return orbitTable.DistanceAU.get(wholeOrbitNumber) + (orbitTable.DifferenceAU.get(wholeOrbitNumber) * fractionalOrbitNumber);
    }

    public static Double AUToOrbitNumber(Double AU) {
        int largestWholeOrbitNumber = 0;
        for (int x = 0; x < 21; x++) {
            if (orbitTable.DistanceAU.get(x) < AU) {
                largestWholeOrbitNumber = x;
            } else {
                break;
            }
        }
        return largestWholeOrbitNumber + ((AU - orbitTable.DistanceAU.get(largestWholeOrbitNumber)) / orbitTable.DifferenceAU.get(largestWholeOrbitNumber));
    }
}
