package vandyke.data.persistence;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor()
public class OrbitalBody extends DiscreteBody {

    @NonNull
    private String orbitalBodyClass;

    private TerrestrialInfo terrestrialInfo;

    private GasGiantInfo gasGiantInfo;

    private AsteroidBeltInfo beltInfo;

}
