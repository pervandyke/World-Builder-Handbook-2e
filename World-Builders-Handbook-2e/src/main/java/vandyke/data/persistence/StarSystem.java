package vandyke.data.persistence;

import lombok.Getter;
import lombok.Setter;
import vandyke.data.comparator.DiscreteBodyComparator;
import vandyke.utility.UnitConversionUtil;

import java.util.ArrayList;

@Getter
@Setter
public class StarSystem {

    private Primary primaryStar;

    private Integer starCount;

    public ArrayList<DiscreteBody> bodies = new ArrayList<>();

    private Integer orbitSlots;

    private Integer gasGiants;

    private Integer planetoidBelts;

    private Integer terrestrialPlanets;

    private Integer emptyOrbits;

    private Integer systemBaselineNumber;

    private Double systemBaselineOrbitNumber;

    private Double systemSpread;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Primary: " + this.primaryStar.getName() + ", " + this.getPrimaryStar().getType() + this.getPrimaryStar().getSubType() + this.getPrimaryStar().getStarClass()
                + ", Minimum Allowable Orbit: " + primaryStar.getMinimalAllowableOrbit() + "\n");
        if (this.getPrimaryStar().getCompanion() != null) {
            sb.append(" Companion: " + this.getPrimaryStar().getCompanion().getType()
                    + this.getPrimaryStar().getCompanion().getSubType() + this.getPrimaryStar().getCompanion().getStarClass()
                    + ", Orbit#: " + this.getPrimaryStar().getCompanion().getOrbitNumber()
                    + ", Orbital Period: " + this.getPrimaryStar().getCompanion().getOrbitalPeriod().toString() + " Standard Years\n");
        }
        this.primaryStar.getChildren().sort(new DiscreteBodyComparator());
        for (DiscreteBody body : this.getPrimaryStar().getChildren()) {
            Planet planet = (Planet) body;
            sb.append(" " + body.getName() + ", Class: " + planet.getPlanetClass() + ", Orbit#: " + body.getOrbitNumber().floatValue() + ", " + UnitConversionUtil.OrbitNumberToAU(body.getOrbitNumber()).floatValue() + " AU\n");
        }
        if (this.getPrimaryStar().getCloseStar() != null) {
            sb.append(" Close: " + this.getPrimaryStar(). getCloseStar().getType() + this.getPrimaryStar().getCloseStar().getSubType()
                    + this.getPrimaryStar().getCloseStar().getStarClass() + ", Orbit#: " + this.getPrimaryStar().getCloseStar().getOrbitNumber()
                    + ", Orbital Period: " + this.getPrimaryStar().getCloseStar().getOrbitalPeriod().toString() + " Standard Years\n");
            if (this.getPrimaryStar().getCloseStar().getCompanion() != null) {
                sb.append("  Companion: " + this.getPrimaryStar().getCloseStar().getCompanion().getType()
                        + this.getPrimaryStar().getCloseStar().getCompanion().getSubType() + this.getPrimaryStar().getCloseStar().getCompanion().getStarClass()
                        + ", Orbit#: " + this.getPrimaryStar().getCloseStar().getCompanion().getOrbitNumber()
                        + ", Orbital Period: " + this.getPrimaryStar().getCloseStar().getCompanion().getOrbitalPeriod().toString() + " Standard Years\n");
            }
        }
        if (this.getPrimaryStar().getNearStar() != null) {
            sb.append(" Near: " + this.getPrimaryStar().getNearStar().getType() + this.getPrimaryStar().getNearStar().getSubType()
                    + this.getPrimaryStar().getNearStar().getStarClass() + ", Orbit#: " + this.getPrimaryStar().getNearStar().getOrbitNumber()
                    + ", Orbital Period: " + this.getPrimaryStar().getNearStar().getOrbitalPeriod().toString() + " Standard Years\n");
            if (this.getPrimaryStar().getNearStar().getCompanion() != null) {
                sb.append("  Companion: " + this.getPrimaryStar().getNearStar().getCompanion().getType()
                        + this.getPrimaryStar().getNearStar().getCompanion().getSubType() + this.getPrimaryStar().getNearStar().getCompanion().getStarClass()
                        + ", Orbit#: " + this.getPrimaryStar().getNearStar().getCompanion().getOrbitNumber()
                        + ", Orbital Period: " + this.getPrimaryStar().getNearStar().getCompanion().getOrbitalPeriod().toString() + " Standard Years\n");
            }
        }
        if (this.getPrimaryStar().getFarStar() != null) {
            sb.append(" Far: " + this.getPrimaryStar().getFarStar().getType() + this.getPrimaryStar().getFarStar().getSubType()
                    + this.getPrimaryStar().getFarStar().getStarClass() + ", Orbit#: " + this.getPrimaryStar().getFarStar().getOrbitNumber()
                    + ", Orbital Period: " + this.getPrimaryStar().getFarStar().getOrbitalPeriod().toString() + " Standard Years\n");
            if (this.getPrimaryStar().getFarStar().getCompanion() != null) {
                sb.append("  Companion: " + this.getPrimaryStar().getFarStar().getCompanion().getType()
                        + this.getPrimaryStar().getFarStar().getCompanion().getSubType() + this.getPrimaryStar().getFarStar().getCompanion().getStarClass()
                        + ", Orbit#: " + this.getPrimaryStar().getFarStar().getCompanion().getOrbitNumber()
                        + ", Orbital Period: " + this.getPrimaryStar().getFarStar().getCompanion().getOrbitalPeriod().toString() + " Standard Years\n");
            }
        }

        return sb.toString();
    }
}
