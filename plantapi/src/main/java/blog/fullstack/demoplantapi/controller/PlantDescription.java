package blog.fullstack.demoplantapi.controller;

import blog.fullstack.demoplantapi.service.TextFragmentsService;
import blog.fullstack.shared.plant.PlantTextFragment;
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
@RequestMapping(path = "/plant/description")
public class PlantDescription {

    private final TextFragmentsService textService;

    @GetMapping
    public ResponseEntity<List<PlantTextFragment>> getPlantDescription(
            @RequestParam UUID plantId,
            @RequestParam(defaultValue = "13") int limit) {
        return ResponseEntity.ok(textService.getFragments(plantId, limit));
    }
}
