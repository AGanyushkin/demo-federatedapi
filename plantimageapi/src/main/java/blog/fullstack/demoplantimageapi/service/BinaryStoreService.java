package blog.fullstack.demoplantimageapi.service;

import blog.fullstack.shared.plant.PlantImage;

import java.util.List;
import java.util.UUID;

public interface BinaryStoreService {
    List<PlantImage> getImagesForPlant(UUID plantId, int limit);
}
