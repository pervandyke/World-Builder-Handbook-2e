package vandyke.utility;

import org.apache.commons.lang3.ClassUtils;
import org.springframework.beans.BeanUtils;
import vandyke.data.persistence.DiscreteBody;
import vandyke.data.persistence.Planet;
import vandyke.data.persistence.Star;
import vandyke.data.persistence.StarSystem;
import vandyke.data.schema.AsteroidBeltSchema;
import vandyke.data.schema.OrbitalBodySchema;
import vandyke.data.schema.StarSchema;
import vandyke.data.schema.SystemSchema;

import java.util.ArrayList;
import java.util.List;

public class SchemaConversionUtil {

    public static SystemSchema ConvertSystemToSchema(final StarSystem system) {
        SystemSchema schema = new SystemSchema();
        schema.setPrimaryStar(ConvertStarToSchema(system.getPrimaryStar()));
        return schema;
    }

    public static StarSchema ConvertStarToSchema(final Star star) {
        StarSchema schema = new StarSchema();

        BeanUtils.copyProperties(star, schema);

        List<OrbitalBodySchema> planets = new ArrayList<>();
        List<AsteroidBeltSchema> belts = new ArrayList<>();

        star.getChildren().stream().forEach(child -> {
            if (child instanceof Planet) {
                planets.add(ConvertPlanetToSchema(child));
            }
        });




        return schema;
    }

    public static OrbitalBodySchema ConvertPlanetToSchema(final DiscreteBody body) {
        OrbitalBodySchema schema = new OrbitalBodySchema();



        return schema;
    }





}
