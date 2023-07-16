package vandyke.DataObjects;

public class DiscreteBody {

    Float orbitNumber;

    DiscreteBody parent;

    public Float getOrbitNumber() {
        return orbitNumber;
    }

    public void setOrbitNumber(Float orbitNumber) {
        this.orbitNumber = orbitNumber;
    }

    public DiscreteBody getParent() {
        return parent;
    }

    public void setParent(DiscreteBody parent) {
        this.parent = parent;
    }
}
