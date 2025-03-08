package vandyke.data.persistence;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class DiscreteBody {

    private String name;
    private Double orbitNumber;

    private Double orbitalPeriod;

    private DiscreteBody parent;

    private ArrayList<DiscreteBody> children = new ArrayList<>();

    public void addChild(final DiscreteBody child) {
        this.children.add(child);
    }

}


