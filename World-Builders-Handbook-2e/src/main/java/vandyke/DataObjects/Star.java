package vandyke.DataObjects;

public class Star extends DiscreteBody{

    private String type;

    private Integer subType;

    private String starClass;

    private String color;

    private Float mass;

    private Integer temperature;

    private Float luminosity;

    private Float age;

    private Float minimalAllowableOrbit;

    private Float HabitableZoneCenterOrbit;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getMass() {
        return mass;
    }

    public void setMass(Float mass) {
        this.mass = mass;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Float getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(Float luminosity) {
        this.luminosity = luminosity;
    }

    public Float getAge() {
        return age;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    public Float getMinimalAllowableOrbit() {
        return minimalAllowableOrbit;
    }

    public void setMinimalAllowableOrbit(Float minimalAllowableOrbit) {
        this.minimalAllowableOrbit = minimalAllowableOrbit;
    }

    public Float getHabitableZoneCenterOrbit() {
        return HabitableZoneCenterOrbit;
    }

    public void setHabitableZoneCenterOrbit(Float habitableZoneCenterOrbit) {
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
        return "Star{" +
                "type='" + type + '\'' +
                ", subType=" + subType +
                ", starClass='" + starClass + '\'' +
                ", color='" + color + '\'' +
                ", mass=" + mass +
                ", temperature=" + temperature +
                ", luminosity=" + luminosity +
                ", age=" + age +
                ", minimalAllowableOrbit=" + minimalAllowableOrbit +
                ", HabitableZoneCenterOrbit=" + HabitableZoneCenterOrbit +
                ", OrbitNumber=" + OrbitNumber +
                '}';
    }
}
