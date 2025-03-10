package vandyke.generation.utility;

import org.junit.jupiter.api.Test;
import vandyke.utility.NamingUtilities;

public class NamingUtilitiesTest {

    @Test
    public void generateNames() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(NamingUtilities.GeneratePlanetName());
        }
    }


}
