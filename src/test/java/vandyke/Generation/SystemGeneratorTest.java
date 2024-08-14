package vandyke.Generation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SystemGeneratorTest {

    @Test
    void TestSystemGen() {
        SystemGenerator.GenerateSystem();
    }
}
