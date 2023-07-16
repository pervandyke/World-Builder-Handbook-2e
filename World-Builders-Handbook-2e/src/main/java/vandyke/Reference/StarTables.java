package vandyke.Reference;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class StarTables {

    public Hashtable<Integer, String> Type = new Hashtable<>();

    public Hashtable<Integer, String> Hot = new Hashtable<>();

    public Hashtable<Integer, String> Special = new Hashtable<>();

    public Hashtable<Integer, String> Unusual = new Hashtable<>();

    public Hashtable<Integer, String> Giants = new Hashtable<>();

    public Hashtable<Integer, String> Peculiar = new Hashtable<>();

    public Hashtable<String, String> Color = new Hashtable<>();

    public Hashtable<String, Double> Ia = new Hashtable<>();

    public Hashtable<String, Double> Ib = new Hashtable<>();

    public Hashtable<String, Double> II = new Hashtable<>();

    public Hashtable<String, Double> III = new Hashtable<>();

    public Hashtable<String, Double> IV = new Hashtable<>();

    public Hashtable<String, Double> V = new Hashtable<>();

    public Hashtable<String, Double> VI = new Hashtable<>();

    public Hashtable<String, Double> IaDiameter = new Hashtable<>();

    public Hashtable<String, Double> IbDiameter = new Hashtable<>();

    public Hashtable<String, Double> IIDiameter = new Hashtable<>();

    public Hashtable<String, Double> IIIDiameter = new Hashtable<>();

    public Hashtable<String, Double> IVDiameter = new Hashtable<>();

    public Hashtable<String, Double> VDiameter = new Hashtable<>();

    public Hashtable<String, Double> VIDiameter = new Hashtable<>();

    public Hashtable<String, Integer> Temperature = new Hashtable<>();

    public ArrayList<String> TypeAdjacency = new ArrayList<>();

    public Hashtable<Integer, String> NonPrimaryCompanion = new Hashtable<>();

    public StarTables() {
        // Populate Type table
        Type.put(2, "Special");
        Type.put(3, "M");
        Type.put(4, "M");
        Type.put(5, "M");
        Type.put(6, "M");
        Type.put(7, "K");
        Type.put(8, "K");
        Type.put(9, "G");
        Type.put(10, "G");
        Type.put(11, "F");
        Type.put(12, "Hot");

        // Populate Hot Table
        Hot.put(2, "A");
        Hot.put(3, "A");
        Hot.put(4, "A");
        Hot.put(5, "A");
        Hot.put(6, "A");
        Hot.put(7, "A");
        Hot.put(8, "A");
        Hot.put(9, "A");
        Hot.put(10, "B");
        Hot.put(11, "B");
        Hot.put(12, "O");

        // Populate Special Table
        Special.put(2, "Class VI");
        Special.put(3, "Class VI");
        Special.put(4, "Class VI");
        Special.put(5, "Class VI");
        Special.put(6, "Class IV");
        Special.put(7, "Class IV");
        Special.put(8, "Class IV");
        Special.put(9, "Class III");
        Special.put(10, "Class III");
        Special.put(11, "Giants");
        Special.put(12, "Giants");

        Unusual.put(2, "Peculiar");
        Unusual.put(3, "Class VI");
        Unusual.put(4, "Class IV");
        Unusual.put(5, "BD");
        Unusual.put(6, "BD");
        Unusual.put(7, "BD");
        Unusual.put(8, "D");
        Unusual.put(9, "D");
        Unusual.put(10, "D");
        Unusual.put(11, "Class III");
        Unusual.put(12, "Giants");

        // Populate Giants Table
        Giants.put(2, "Class III");
        Giants.put(3, "Class III");
        Giants.put(4, "Class III");
        Giants.put(5, "Class III");
        Giants.put(6, "Class III");
        Giants.put(7, "Class III");
        Giants.put(8, "Class III");
        Giants.put(9, "Class II");
        Giants.put(10, "Class II");
        Giants.put(11, "Class Ib");
        Giants.put(12, "Class Ia");

        // Populate Peculiar Table
        Peculiar.put(2, "Black Hole");
        Peculiar.put(3, "Pulsar");
        Peculiar.put(4, "Neutron Star");
        Peculiar.put(5, "Nebula");
        Peculiar.put(6, "Nebula");
        Peculiar.put(7, "Protostar");
        Peculiar.put(8, "Protostar");
        Peculiar.put(9, "Protostar");
        Peculiar.put(10, "Star Cluster");
        Peculiar.put(11, "Anomaly");
        Peculiar.put(12, "Anomaly");

        // Populate Color Table
        Color.put("M", "Orange Red");
        Color.put("K", "Light Orange");
        Color.put("G", "Yellow");
        Color.put("F", "Yellow White");
        Color.put("A", "White");
        Color.put("B", "Blue White");
        Color.put("O", "Blue");

        TypeAdjacency.add("M9");
        TypeAdjacency.add("M5");
        TypeAdjacency.add("M0");
        TypeAdjacency.add("K5");
        TypeAdjacency.add("K0");
        TypeAdjacency.add("G5");
        TypeAdjacency.add("G0");
        TypeAdjacency.add("F5");
        TypeAdjacency.add("F0");
        TypeAdjacency.add("A5");
        TypeAdjacency.add("A0");
        TypeAdjacency.add("B5");
        TypeAdjacency.add("B0");
        TypeAdjacency.add("O5");
        TypeAdjacency.add("O0");

        Ia.put("M9", 30d);
        Ia.put("M5", 25d);
        Ia.put("M0", 20d);
        Ia.put("K5", 18d);
        Ia.put("K0", 14d);
        Ia.put("G5", 13d);
        Ia.put("G0", 12d);
        Ia.put("F5", 12d);
        Ia.put("F0", 13d);
        Ia.put("A5", 15d);
        Ia.put("A0", 20d);
        Ia.put("B5", 30d);
        Ia.put("B0", 60d);
        Ia.put("O5", 80d);
        Ia.put("O0", 200d);


        Ib.put("M9", 25d);
        Ib.put("M5", 20d);
        Ib.put("M0", 15d);
        Ib.put("K5", 13d);
        Ib.put("K0", 12d);
        Ib.put("G5", 11d);
        Ib.put("G0", 10d);
        Ib.put("F5", 10d);
        Ib.put("F0", 12d);
        Ib.put("A5", 13d);
        Ib.put("A0", 15d);
        Ib.put("B5", 25d);
        Ib.put("B0", 40d);
        Ib.put("O5", 60d);
        Ib.put("O0", 150d);


        II.put("M9", 18d);
        II.put("M5", 16d);
        II.put("M0", 14d);
        II.put("K5", 12d);
        II.put("K0", 10d);
        II.put("G5", 10d);
        II.put("G0", 8d);
        II.put("F5", 8d);
        II.put("F0", 10d);
        II.put("A5", 11d);
        II.put("A0", 14d);
        II.put("B5", 20d);
        II.put("B0", 30d);
        II.put("O5", 40d);
        II.put("O0", 130d);

        III.put("M9", 8d);
        III.put("M5", 2.4d);
        III.put("M0", 1.8d);
        III.put("K5", 1.5d);
        III.put("K0", 1.1d);
        III.put("G5", 2.4d);
        III.put("G0", 2.5d);
        III.put("F5", 3d);
        III.put("F0", 4d);
        III.put("A5", 6d);
        III.put("A0", 8d);
        III.put("B5", 10d);
        III.put("B0", 20d);
        III.put("O5", 30d);
        III.put("O0", 110d);


        IV.put("K0", 1.5d);
        IV.put("G5", 1.2d);
        IV.put("G0", 1.7d);
        IV.put("F5", 1.5d);
        IV.put("F0", 2d);
        IV.put("A5", 2.3d);
        IV.put("A0", 4d);
        IV.put("B5", 10d);
        IV.put("B0", 20d);

        V.put("M9", 0.08d);
        V.put("M5", 0.16d);
        V.put("M0", 0.5d);
        V.put("K5", 0.7d);
        V.put("K0", 0.8d);
        V.put("G5", 0.9d);
        V.put("G0", 1.1d);
        V.put("F5", 1.3d);
        V.put("F0", 1.5d);
        V.put("A5", 1.8d);
        V.put("A0", 2.2d);
        V.put("B5", 5d);
        V.put("B0", 18d);
        V.put("O5", 60d);
        V.put("O0", 90d);

        VI.put("M9", 0.075d);
        VI.put("M5", 0.12d);
        VI.put("M0", 0.4d);
        VI.put("K5", 0.5d);
        VI.put("K0", 0.6d);
        VI.put("G5", 0.7d);
        VI.put("G0", 0.8d);
        VI.put("B5", 0.4d);
        VI.put("B0", 0.5d);
        VI.put("O5", 1.5d);
        VI.put("O0", 2d);

        Temperature.put("M9", 2400);
        Temperature.put("M5", 3000);
        Temperature.put("M0", 3700);
        Temperature.put("K5", 4400);
        Temperature.put("K0", 5200);
        Temperature.put("G5", 5600);
        Temperature.put("G0", 6000);
        Temperature.put("F5", 6500);
        Temperature.put("F0", 7500);
        Temperature.put("A5", 8000);
        Temperature.put("A0", 10000);
        Temperature.put("B5", 15000);
        Temperature.put("B0", 30000);
        Temperature.put("O5", 40000);
        Temperature.put("O0", 50000);

        IaDiameter.put("M9", 1800d);
        IaDiameter.put("M5", 1200d);
        IaDiameter.put("M0", 900d);
        IaDiameter.put("K5", 600d);
        IaDiameter.put("K0", 420d);
        IaDiameter.put("G5", 360d);
        IaDiameter.put("G0", 330d);
        IaDiameter.put("F5", 280d);
        IaDiameter.put("F0", 210d);
        IaDiameter.put("A5", 180d);
        IaDiameter.put("A0", 120d);
        IaDiameter.put("B5", 60d);
        IaDiameter.put("B0", 20d);
        IaDiameter.put("O5", 22d);
        IaDiameter.put("O0", 25d);


        IbDiameter.put("M9", 800d);
        IbDiameter.put("M5", 600d);
        IbDiameter.put("M0", 380d);
        IbDiameter.put("K5", 260d);
        IbDiameter.put("K0", 180d);
        IbDiameter.put("G5", 150d);
        IbDiameter.put("G0", 135d);
        IbDiameter.put("F5", 115d);
        IbDiameter.put("F0", 85d);
        IbDiameter.put("A5", 75d);
        IbDiameter.put("A0", 50d);
        IbDiameter.put("B5", 25d);
        IbDiameter.put("B0", 14d);
        IbDiameter.put("O5", 20d);
        IbDiameter.put("O0", 24d);


        IIDiameter.put("M9", 500d);
        IIDiameter.put("M5", 350d);
        IIDiameter.put("M0", 230d);
        IIDiameter.put("K5", 160d);
        IIDiameter.put("K0", 110d);
        IIDiameter.put("G5", 90d);
        IIDiameter.put("G0", 77d);
        IIDiameter.put("F5", 66d);
        IIDiameter.put("F0", 50d);
        IIDiameter.put("A5", 45d);
        IIDiameter.put("A0", 30d);
        IIDiameter.put("B5", 14d);
        IIDiameter.put("B0", 12d);
        IIDiameter.put("O5", 18d);
        IIDiameter.put("O0", 22d);

        IIIDiameter.put("M9", 200d);
        IIIDiameter.put("M5", 100d);
        IIIDiameter.put("M0", 60d);
        IIIDiameter.put("K5", 40d);
        IIIDiameter.put("K0", 20d);
        IIIDiameter.put("G5", 15d);
        IIIDiameter.put("G0", 10d);
        IIIDiameter.put("F5", 5d);
        IIIDiameter.put("F0", 5d);
        IIIDiameter.put("A5", 5d);
        IIIDiameter.put("A0", 5d);
        IIIDiameter.put("B5", 6d);
        IIIDiameter.put("B0", 10d);
        IIIDiameter.put("O5", 15d);
        IIIDiameter.put("O0", 21d);


        IVDiameter.put("K0", 6d);
        IVDiameter.put("G5", 4d);
        IVDiameter.put("G0", 3d);
        IVDiameter.put("F5", 2d);
        IVDiameter.put("F0", 3d);
        IVDiameter.put("A5", 3d);
        IVDiameter.put("A0", 4d);
        IVDiameter.put("B5", 5d);
        IVDiameter.put("B0", 8d);

        VDiameter.put("M9", 0.1d);
        VDiameter.put("M5", 0.2d);
        VDiameter.put("M0", 0.7d);
        VDiameter.put("K5", 0.8d);
        VDiameter.put("K0", 0.9d);
        VDiameter.put("G5", 0.95d);
        VDiameter.put("G0", 1.1d);
        VDiameter.put("F5", 1.5d);
        VDiameter.put("F0", 1.7d);
        VDiameter.put("A5", 2d);
        VDiameter.put("A0", 2.2d);
        VDiameter.put("B5", 3.5d);
        VDiameter.put("B0", 7d);
        VDiameter.put("O5", 12d);
        VDiameter.put("O0", 20d);

        VIDiameter.put("M9", 0.08d);
        VIDiameter.put("M5", 0.1d);
        VIDiameter.put("M0", 0.4d);
        VIDiameter.put("K5", 0.5d);
        VIDiameter.put("K0", 0.6d);
        VIDiameter.put("G5", 0.7d);
        VIDiameter.put("G0", 0.8d);
        VIDiameter.put("B5", 0.5d);
        VIDiameter.put("B0", 0.2d);
        VIDiameter.put("O5", 0.18d);
        VIDiameter.put("O0", 0.18d);

        NonPrimaryCompanion.put(2, "Other");
        NonPrimaryCompanion.put(3, "Other");
        NonPrimaryCompanion.put(4, "Random");
        NonPrimaryCompanion.put(5, "Random");
        NonPrimaryCompanion.put(6, "Lesser");
        NonPrimaryCompanion.put(7, "Lesser");
        NonPrimaryCompanion.put(8, "Sibling");
        NonPrimaryCompanion.put(9, "Sibling");
        NonPrimaryCompanion.put(10, "Twin");
        NonPrimaryCompanion.put(11, "Twin");
        NonPrimaryCompanion.put(12, "Twin");
    }


}
