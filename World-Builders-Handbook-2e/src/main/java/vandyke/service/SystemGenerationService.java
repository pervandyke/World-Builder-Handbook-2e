package vandyke.service;

import org.springframework.stereotype.Service;
import vandyke.data.persistence.StarSystem;
import vandyke.generation.SystemGenerator;

@Service
public class SystemGenerationService {

    public StarSystem generateSystem() {
        StarSystem system = SystemGenerator.GenerateSystem();



        return system;
    }

}
