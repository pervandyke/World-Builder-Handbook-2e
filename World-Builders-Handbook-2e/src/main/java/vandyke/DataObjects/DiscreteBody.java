package vandyke.DataObjects;

import java.util.ArrayList;

public class DiscreteBody {

    Double orbitNumber;

    Double orbitalPeriod;

    DiscreteBody parent;

    public ArrayList<DiscreteBody> children;

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
