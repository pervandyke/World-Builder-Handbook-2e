package vandyke.data.persistence;

public class OrbitRange {

    private boolean legal;

    private Double max;

    private Double min;

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public boolean isLegal() {
        return legal;
    }

    public void setLegal(boolean legal) {
        this.legal = legal;
    }

    public OrbitRange(boolean legal, Double min, Double max) {
        this.legal = legal;
        this.max = max;
        this.min = min;
    }
}
