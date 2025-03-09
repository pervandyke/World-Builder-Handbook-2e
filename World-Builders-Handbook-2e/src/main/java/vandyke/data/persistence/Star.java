package vandyke.data.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Star extends DiscreteBody{

    private String type;

    private Integer subType;

    private Double subTypeFraction;

    @JsonIgnore
    private String upperAdjacentType;

    @JsonIgnore
    private String lowerAdjacentType;

    @JsonIgnore
    private Double referenceRange;

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

    @JsonIgnore
    private Integer assignedOrbitCount;

    public ArrayList<OrbitRange> orbitLegality;

    private Double minimalAllowableOrbit;

    private Double habitableZoneCenterOrbit;

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
                    ", HabitableZoneCenterOrbit=" + habitableZoneCenterOrbit +
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
                    ", HabitableZoneCenterOrbit=" + habitableZoneCenterOrbit +
                    ", OrbitClass=" + orbitClass +
                    '}';
        }
    }
}
