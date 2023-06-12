package blog.fullstack.demoplantapi.service;

import blog.fullstack.shared.plant.PlantTextFragment;

import java.util.List;
import java.util.UUID;

public interface TextFragmentsService {
    List<PlantTextFragment> getFragments(UUID plantId, int limit);
}
