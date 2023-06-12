package blog.fullstack.demoplantapi.controller;

import blog.fullstack.demoplantapi.service.PropertyService;
import blog.fullstack.shared.plant.PlantProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/plant/property")
public class PlantProperties {

    private final PropertyService propertyService;

    @GetMapping
    public ResponseEntity<List<PlantProperty>> getPlantProperty(
            @RequestParam UUID plantId) {
        return ResponseEntity.ok(propertyService.getProperties(plantId));
    }
}
