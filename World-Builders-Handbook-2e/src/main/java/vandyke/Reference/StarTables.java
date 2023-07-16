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

    public Hashtable<String, Float> Ia = new Hashtable<>();

    public Hashtable<String, Float> Ib = new Hashtable<>();

    public Hashtable<String, Float> II = new Hashtable<>();

    public Hashtable<String, Float> III = new Hashtable<>();

    public Hashtable<String, Float> IV = new Hashtable<>();

    public Hashtable<String, Float> V = new Hashtable<>();

    public Hashtable<String, Float> VI = new Hashtable<>();

    public Hashtable<String, Float> IaDiameter = new Hashtable<>();

    public Hashtable<String, Float> IbDiameter = new Hashtable<>();

    public Hashtable<String, Float> IIDiameter = new Hashtable<>();

    public Hashtable<String, Float> IIIDiameter = new Hashtable<>();

    public Hashtable<String, Float> IVDiameter = new Hashtable<>();

    public Hashtable<String, Float> VDiameter = new Hashtable<>();

    public Hashtable<String, Float> VIDiameter = new Hashtable<>();

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

        Ia.put("M9", 30f);
        Ia.put("M5", 25f);
        Ia.put("M0", 20f);
        Ia.put("K5", 18f);
        Ia.put("K0", 14f);
        Ia.put("G5", 13f);
        Ia.put("G0", 12f);
        Ia.put("F5", 12f);
        Ia.put("F0", 13f);
        Ia.put("A5", 15f);
        Ia.put("A0", 20f);
        Ia.put("B5", 30f);
        Ia.put("B0", 60f);
        Ia.put("O5", 80f);
        Ia.put("O0", 200f);


        Ib.put("M9", 25f);
        Ib.put("M5", 20f);
        Ib.put("M0", 15f);
        Ib.put("K5", 13f);
        Ib.put("K0", 12f);
        Ib.put("G5", 11f);
        Ib.put("G0", 10f);
        Ib.put("F5", 10f);
        Ib.put("F0", 12f);
        Ib.put("A5", 13f);
        Ib.put("A0", 15f);
        Ib.put("B5", 25f);
        Ib.put("B0", 40f);
        Ib.put("O5", 60f);
        Ib.put("O0", 150f);


        II.put("M9", 18f);
        II.put("M5", 16f);
        II.put("M0", 14f);
        II.put("K5", 12f);
        II.put("K0", 10f);
        II.put("G5", 10f);
        II.put("G0", 8f);
        II.put("F5", 8f);
        II.put("F0", 10f);
        II.put("A5", 11f);
        II.put("A0", 14f);
        II.put("B5", 20f);
        II.put("B0", 30f);
        II.put("O5", 40f);
        II.put("O0", 130f);

        III.put("M9", 8f);
        III.put("M5", 2.4f);
        III.put("M0", 1.8f);
        III.put("K5", 1.5f);
        III.put("K0", 1.1f);
        III.put("G5", 2.4f);
        III.put("G0", 2.5f);
        III.put("F5", 3f);
        III.put("F0", 4f);
        III.put("A5", 6f);
        III.put("A0", 8f);
        III.put("B5", 10f);
        III.put("B0", 20f);
        III.put("O5", 30f);
        III.put("O0", 110f);


        IV.put("K0", 1.5f);
        IV.put("G5", 1.2f);
        IV.put("G0", 1.7f);
        IV.put("F5", 1.5f);
        IV.put("F0", 2f);
        IV.put("A5", 2.3f);
        IV.put("A0", 4f);
        IV.put("B5", 10f);
        IV.put("B0", 20f);

        V.put("M9", 0.08f);
        V.put("M5", 0.16f);
        V.put("M0", 0.5f);
        V.put("K5", 0.7f);
        V.put("K0", 0.8f);
        V.put("G5", 0.9f);
        V.put("G0", 1.1f);
        V.put("F5", 1.3f);
        V.put("F0", 1.5f);
        V.put("A5", 1.8f);
        V.put("A0", 2.2f);
        V.put("B5", 5f);
        V.put("B0", 18f);
        V.put("O5", 60f);
        V.put("O0", 90f);

        VI.put("M9", 0.075f);
        VI.put("M5", 0.12f);
        VI.put("M0", 0.4f);
        VI.put("K5", 0.5f);
        VI.put("K0", 0.6f);
        VI.put("G5", 0.7f);
        VI.put("G0", 0.8f);
        VI.put("B5", 0.4f);
        VI.put("B0", 0.5f);
        VI.put("O5", 1.5f);
        VI.put("O0", 2f);

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

        IaDiameter.put("M9", 1800f);
        IaDiameter.put("M5", 1200f);
        IaDiameter.put("M0", 900f);
        IaDiameter.put("K5", 600f);
        IaDiameter.put("K0", 420f);
        IaDiameter.put("G5", 360f);
        IaDiameter.put("G0", 330f);
        IaDiameter.put("F5", 280f);
        IaDiameter.put("F0", 210f);
        IaDiameter.put("A5", 180f);
        IaDiameter.put("A0", 120f);
        IaDiameter.put("B5", 60f);
        IaDiameter.put("B0", 20f);
        IaDiameter.put("O5", 22f);
        IaDiameter.put("O0", 25f);


        IbDiameter.put("M9", 800f);
        IbDiameter.put("M5", 600f);
        IbDiameter.put("M0", 380f);
        IbDiameter.put("K5", 260f);
        IbDiameter.put("K0", 180f);
        IbDiameter.put("G5", 150f);
        IbDiameter.put("G0", 135f);
        IbDiameter.put("F5", 115f);
        IbDiameter.put("F0", 85f);
        IbDiameter.put("A5", 75f);
        IbDiameter.put("A0", 50f);
        IbDiameter.put("B5", 25f);
        IbDiameter.put("B0", 14f);
        IbDiameter.put("O5", 20f);
        IbDiameter.put("O0", 24f);


        IIDiameter.put("M9", 500f);
        IIDiameter.put("M5", 350f);
        IIDiameter.put("M0", 230f);
        IIDiameter.put("K5", 160f);
        IIDiameter.put("K0", 110f);
        IIDiameter.put("G5", 90f);
        IIDiameter.put("G0", 77f);
        IIDiameter.put("F5", 66f);
        IIDiameter.put("F0", 50f);
        IIDiameter.put("A5", 45f);
        IIDiameter.put("A0", 30f);
        IIDiameter.put("B5", 14f);
        IIDiameter.put("B0", 12f);
        IIDiameter.put("O5", 18f);
        IIDiameter.put("O0", 22f);

        IIIDiameter.put("M9", 200f);
        IIIDiameter.put("M5", 100f);
        IIIDiameter.put("M0", 60f);
        IIIDiameter.put("K5", 40f);
        IIIDiameter.put("K0", 20f);
        IIIDiameter.put("G5", 15f);
        IIIDiameter.put("G0", 10f);
        IIIDiameter.put("F5", 5f);
        IIIDiameter.put("F0", 5f);
        IIIDiameter.put("A5", 5f);
        IIIDiameter.put("A0", 5f);
        IIIDiameter.put("B5", 6f);
        IIIDiameter.put("B0", 10f);
        IIIDiameter.put("O5", 15f);
        IIIDiameter.put("O0", 21f);


        IVDiameter.put("K0", 6f);
        IVDiameter.put("G5", 4f);
        IVDiameter.put("G0", 3f);
        IVDiameter.put("F5", 2f);
        IVDiameter.put("F0", 3f);
        IVDiameter.put("A5", 3f);
        IVDiameter.put("A0", 4f);
        IVDiameter.put("B5", 5f);
        IVDiameter.put("B0", 8f);

        VDiameter.put("M9", 0.1f);
        VDiameter.put("M5", 0.2f);
        VDiameter.put("M0", 0.7f);
        VDiameter.put("K5", 0.8f);
        VDiameter.put("K0", 0.9f);
        VDiameter.put("G5", 0.95f);
        VDiameter.put("G0", 1.1f);
        VDiameter.put("F5", 1.5f);
        VDiameter.put("F0", 1.7f);
        VDiameter.put("A5", 2f);
        VDiameter.put("A0", 2.2f);
        VDiameter.put("B5", 3.5f);
        VDiameter.put("B0", 7f);
        VDiameter.put("O5", 12f);
        VDiameter.put("O0", 20f);

        VIDiameter.put("M9", 0.08f);
        VIDiameter.put("M5", 0.1f);
        VIDiameter.put("M0", 0.4f);
        VIDiameter.put("K5", 0.5f);
        VIDiameter.put("K0", 0.6f);
        VIDiameter.put("G5", 0.7f);
        VIDiameter.put("G0", 0.8f);
        VIDiameter.put("B5", 0.5f);
        VIDiameter.put("B0", 0.2f);
        VIDiameter.put("O5", 0.18f);
        VIDiameter.put("O0", 0.18f);

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
