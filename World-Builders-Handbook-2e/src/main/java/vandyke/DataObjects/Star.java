package vandyke.DataObjects;

public class Star extends DiscreteBody{

    private String type;

    private Integer subType;

    private String starClass;

    private String color;

    private Double mass;

    private Integer temperature;

    private Double diameter;

    private Double luminosity;

    private Double lifespan;

    private Double age;

    private Star companion;

    private String orbitClass;

    private Double minimalAllowableOrbit;

    private Double HabitableZoneCenterOrbit;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    public Double getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(Double luminosity) {
        this.luminosity = luminosity;
    }

    public Double getLifespan() {
        return lifespan;
    }

    public void setLifespan(Double lifespan) {
        this.lifespan = lifespan;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public String getOrbitClass() {
        return orbitClass;
    }

    public void setOrbitClass(String orbitClass) {
        this.orbitClass = orbitClass;
    }

    public Star getCompanion() {
        return companion;
    }

    public void setCompanion(Star companion) {
        this.companion = companion;
    }

    public Double getMinimalAllowableOrbit() {
        return minimalAllowableOrbit;
    }

    public void setMinimalAllowableOrbit(Double minimalAllowableOrbit) {
        this.minimalAllowableOrbit = minimalAllowableOrbit;
    }

    public Double getHabitableZoneCenterOrbit() {
        return HabitableZoneCenterOrbit;
    }

    public void setHabitableZoneCenterOrbit(Double habitableZoneCenterOrbit) {
        HabitableZoneCenterOrbit = habitableZoneCenterOrbit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public String getStarClass() {
        return starClass;
    }

    public void setStarClass(String starClass) {
        this.starClass = starClass;
    }

    @Override
    public String toString() {
        if (companion != null) {
            return "Star{" +
                    "\n type='" + type + '\'' +
                    ", subType=" + subType +
                    ", starClass='" + starClass + '\'' +
                    ", color='" + color + '\'' +
                    ",\n mass=" + mass +
                    ", temperature=" + temperature +
                    ", diameter=" + diameter +
                    ", luminosity=" + luminosity +
                    ",\n lifespan=" + lifespan +
                    ", age=" + age +
                    ",\n companion=" + companion.getType() + companion.getSubType() + companion.getStarClass() +
                    ",\n minimalAllowableOrbit=" + minimalAllowableOrbit +
                    ", HabitableZoneCenterOrbit=" + HabitableZoneCenterOrbit +
                    ", OrbitClass=" + orbitClass +
                    '}';
        } else {
            return "Star{" +
                    "\n type='" + type + '\'' +
                    ", subType=" + subType +
                    ", starClass='" + starClass + '\'' +
                    ", color='" + color + '\'' +
                    ",\n mass=" + mass +
                    ", temperature=" + temperature +
                    ", diameter=" + diameter +
                    ", luminosity=" + luminosity +
                    ",\n lifespan=" + lifespan +
                    ", age=" + age +
                    ",\n minimalAllowableOrbit=" + minimalAllowableOrbit +
                    ", HabitableZoneCenterOrbit=" + HabitableZoneCenterOrbit +
                    ", OrbitClass=" + orbitClass +
                    '}';
        }
    }
}
