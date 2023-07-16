package vandyke.DataObjects;

public class Primary extends Star {

    Star closeStar;

    Star nearStar;

    Star farStar;

    public Star getCloseStar() {
        return closeStar;
    }

    public void setCloseStar(Star closeStar) {
        this.closeStar = closeStar;
    }

    public Star getNearStar() {
        return nearStar;
    }

    public void setNearStar(Star nearStar) {
        this.nearStar = nearStar;
    }

    public Star getFarStar() {
        return farStar;
    }

    public void setFarStar(Star farStar) {
        this.farStar = farStar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Primary " + this.getType() + this.getSubType() + this.getStarClass() + ":\n");
        sb.append(" Color: " + this.getColor() + "\n");
        sb.append(" Mass: " + this.getMass() + "Sols, Temperature: " + this.getTemperature() +"K, Diameter: "
                + this.getDiameter() +" Sols, Luminosity: " + this.getLuminosity() + "Sols\n");
        sb.append(" Lifespan: " + this.getLifespan() + "Gyr, Age: " + this.getAge() + "Gyr\n");
        sb.append(" Minimal Allowable Orbit: " + this.getMinimalAllowableOrbit() + ", Habitable Zone Center Orbit: " + this.getHabitableZoneCenterOrbit() + "\n");

        if (this.getCompanion() != null) {
            sb.append(" Companion: " + this.getCompanion().getType() + this.getCompanion().getSubType() + this.getCompanion().getStarClass()+ "\n");
        }
        if (this.getCloseStar() != null) {
            sb.append(" Close: " + this.getCloseStar().getType() + this.getCloseStar().getSubType() + this.getCloseStar().getStarClass()+ "\n");
            if (this.getCloseStar().getCompanion() != null) {
                sb.append("  Companion: " + this.getCloseStar().getCompanion().getType()
                        + this.getCloseStar().getCompanion().getSubType() + this.getCloseStar().getCompanion().getStarClass()+ "\n");
            }
        }
        if (this.getNearStar() != null) {
            sb.append(" Near: " + this.getNearStar().getType() + this.getNearStar().getSubType() + this.getNearStar().getStarClass()+ "\n");
            if (this.getNearStar().getCompanion() != null) {
                sb.append("  Companion: " + this.getNearStar().getCompanion().getType()
                        + this.getNearStar().getCompanion().getSubType() + this.getNearStar().getCompanion().getStarClass()+ "\n");
            }
        }
        if (this.getFarStar() != null) {
            sb.append(" Far: " + this.getFarStar().getType() + this.getFarStar().getSubType() + this.getFarStar().getStarClass()+ "\n");
            if (this.getFarStar().getCompanion() != null) {
                sb.append("  Companion: " + this.getFarStar().getCompanion().getType()
                        + this.getFarStar().getCompanion().getSubType() + this.getFarStar().getCompanion().getStarClass()+ "\n");
            }
        }

        return sb.toString();
    }
}
