package vandyke.data.schema;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StarSchema {

    private String name;

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

    private Double habitableZoneCenterOrbit;

    private List<OrbitalBodySchema> bodies;

}
