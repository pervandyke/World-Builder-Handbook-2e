package vandyke.utility;

import org.springframework.beans.BeanUtils;
import vandyke.constant.BodyConstants;
import vandyke.data.persistence.DiscreteBody;
import vandyke.data.persistence.Planet;
import vandyke.data.persistence.Star;
import vandyke.data.persistence.StarSystem;
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

        List<OrbitalBodySchema> bodies = new ArrayList<>();

        star.getChildren().forEach(child -> {
            bodies.add(ConvertBodyToSchema(child));
        });

        schema.setBodies(bodies);

        return schema;
    }

    public static OrbitalBodySchema ConvertBodyToSchema(final DiscreteBody body) {
        OrbitalBodySchema schema = new OrbitalBodySchema();
        Planet planet = (Planet) body;
        BeanUtils.copyProperties(planet, schema);
        return schema;
    }
}
