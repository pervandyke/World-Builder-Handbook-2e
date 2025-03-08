package vandyke.data.schema;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SystemSchema {

    private StarSchema primaryStar;

    private List<StarSchema> secondaryStars;

}
