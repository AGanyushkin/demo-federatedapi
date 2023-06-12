package blog.fullstack.demoplantimageapi.controller;

import blog.fullstack.demoplantimageapi.service.ImageStoreService;
import blog.fullstack.shared.plant.PlantImage;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/plant/image")
public class ImageStore {

    private final ImageStoreService storeService;

    @GetMapping
    public ResponseEntity<List<PlantImage>> getPlantImages(
            @RequestParam UUID plantId,
            @RequestParam(defaultValue = "7") int limit
    ) {
        return ResponseEntity.ok(storeService.getImagesForPlant(plantId, limit));
    }
}

