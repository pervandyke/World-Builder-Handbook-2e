package vandyke.Reference;

import java.util.Hashtable;

public class OrbitNumberTable {

    public Hashtable<Integer, Double> DistanceAU = new Hashtable<>();

    public Hashtable<Integer, Double> DifferenceAU = new Hashtable<>();

    public Hashtable<Integer, Integer> MillionKm = new Hashtable<>();

    public OrbitNumberTable () {
        DistanceAU.put(0, 0d);
        DistanceAU.put(1, 0.4d);
        DistanceAU.put(2, 0.7d);
        DistanceAU.put(3, 1.0d);
        DistanceAU.put(4, 1.6d);
        DistanceAU.put(5, 2.8d);
        DistanceAU.put(6, 5.2d);
        DistanceAU.put(7, 10d);
        DistanceAU.put(8, 20d);
        DistanceAU.put(9, 40d);
        DistanceAU.put(10, 77d);
        DistanceAU.put(11, 154d);
        DistanceAU.put(12, 308d);
        DistanceAU.put(13, 615d);
        DistanceAU.put(14, 1230d);
        DistanceAU.put(15, 2500d);
        DistanceAU.put(16, 4900d);
        DistanceAU.put(17, 9800d);
        DistanceAU.put(18, 19500d);
        DistanceAU.put(19, 39500d);
        DistanceAU.put(20, 78700d);

        DifferenceAU.put(0, 0.4d);
        DifferenceAU.put(1, 0.3d);
        DifferenceAU.put(2, 0.3d);
        DifferenceAU.put(3, 0.6d);
        DifferenceAU.put(4, 1.2d);
        DifferenceAU.put(5, 2.4d);
        DifferenceAU.put(6, 4.8d);
        DifferenceAU.put(7, 10d);
        DifferenceAU.put(8, 20d);
        DifferenceAU.put(9, 37d);
        DifferenceAU.put(10, 77d);
        DifferenceAU.put(11, 154d);
        DifferenceAU.put(12, 307d);
        DifferenceAU.put(13, 615d);
        DifferenceAU.put(14, 1270d);
        DifferenceAU.put(15, 2400d);
        DifferenceAU.put(16, 4900d);
        DifferenceAU.put(17, 9700d);
        DifferenceAU.put(18, 20000d);
        DifferenceAU.put(19, 39200d);

        MillionKm.put(0, 0);
        MillionKm.put(1, 60);
        MillionKm.put(2, 105);
        MillionKm.put(3, 150);
        MillionKm.put(4, 240);
        MillionKm.put(5, 420);
        MillionKm.put(6, 780);
        MillionKm.put(7, 1500);
        MillionKm.put(8, 3000);
        MillionKm.put(9, 6000);
        MillionKm.put(10, 11550);
        MillionKm.put(11, 23100);
        MillionKm.put(12, 46200);
        MillionKm.put(13, 92250);
        MillionKm.put(14, 184500);
        MillionKm.put(15, 375000);
        MillionKm.put(16, 735000);
        MillionKm.put(17, 1470000);
        MillionKm.put(18, 2925000);
        MillionKm.put(19, 5925000);
        MillionKm.put(20, 11805000);

    }

}
