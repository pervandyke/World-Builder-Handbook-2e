package vandyke.DataObjects;

public class SolarSystem {

    private Star primaryStar;

    private Integer systemBaselineNumber;

    private Float systemBaselineOrbitNumber;

    private Integer emptyOrbits;

    private Float systemSpread;

    public Star getPrimaryStar() {
        return primaryStar;
    }

    public void setPrimaryStar(Star primaryStar) {
        this.primaryStar = primaryStar;
    }

    public Integer getSystemBaselineNumber() {
        return systemBaselineNumber;
    }

    public void setSystemBaselineNumber(Integer systemBaselineNumber) {
        this.systemBaselineNumber = systemBaselineNumber;
    }

    public Float getSystemBaselineOrbitNumber() {
        return systemBaselineOrbitNumber;
    }

    public void setSystemBaselineOrbitNumber(Float systemBaselineOrbitNumber) {
        this.systemBaselineOrbitNumber = systemBaselineOrbitNumber;
    }

    public Integer getEmptyOrbits() {
        return emptyOrbits;
    }

    public void setEmptyOrbits(Integer emptyOrbits) {
        this.emptyOrbits = emptyOrbits;
    }

    public Float getSystemSpread() {
        return systemSpread;
    }

    public void setSystemSpread(Float systemSpread) {
        this.systemSpread = systemSpread;
    }
}
