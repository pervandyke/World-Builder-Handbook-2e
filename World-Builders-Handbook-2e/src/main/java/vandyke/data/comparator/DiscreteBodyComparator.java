package vandyke.data.comparator;

import vandyke.data.persistence.DiscreteBody;

public class DiscreteBodyComparator implements java.util.Comparator<DiscreteBody> {

    @Override
    public int compare(DiscreteBody o1, DiscreteBody o2) {
        double diff = o1.getOrbitNumber() - o2.getOrbitNumber();
        if (diff < 0) {
            return -1;
        } else if (diff == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}