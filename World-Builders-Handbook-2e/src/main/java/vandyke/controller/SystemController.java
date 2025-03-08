package vandyke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vandyke.data.persistence.StarSystem;
import vandyke.data.schema.SystemSchema;
import vandyke.service.SystemGenerationService;
import vandyke.utility.SchemaConversionUtil;

@RestController
@RequestMapping(path = "/wbh")
public class SystemController {

    private final SystemGenerationService systemService;

    public SystemController (@Autowired SystemGenerationService systemService) {
        this.systemService = systemService;
    }

    @GetMapping(path = "/system")
    public ResponseEntity<SystemSchema> generateStarSystem() {
        StarSystem system = systemService.generateSystem();
        return ResponseEntity.status(HttpStatus.OK).body(SchemaConversionUtil.ConvertSystemToSchema(system));
    }

}
