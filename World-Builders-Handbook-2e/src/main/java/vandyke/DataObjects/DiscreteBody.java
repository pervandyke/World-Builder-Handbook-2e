package vandyke.DataObjects;

import java.util.ArrayList;

public class DiscreteBody {

    private String name;
    private Double orbitNumber;

    private Double orbitalPeriod;

    private DiscreteBody parent;

    public ArrayList<DiscreteBody> children = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getOrbitNumber() {
        return orbitNumber;
    }

    public void setOrbitNumber(Double orbitNumber) {
        this.orbitNumber = orbitNumber;
    }

    public Double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(Double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public DiscreteBody getParent() {
        return parent;
    }

    public void setParent(DiscreteBody parent) {
        this.parent = parent;
    }

}


