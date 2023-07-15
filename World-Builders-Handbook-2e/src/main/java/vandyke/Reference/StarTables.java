package vandyke.Reference;

import java.util.Dictionary;
import java.util.Hashtable;

public class StarTables {

    public Hashtable<Integer, String> Type = new Hashtable<>();

    public Hashtable<Integer, String> Hot = new Hashtable<>();

    public Hashtable<Integer, String> Special = new Hashtable<>();

    public Hashtable<Integer, String> Unusual = new Hashtable<>();

    public Hashtable<Integer, String> Giants = new Hashtable<>();

    public Hashtable<Integer, String> Peculiar = new Hashtable<>();

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
    }


}
