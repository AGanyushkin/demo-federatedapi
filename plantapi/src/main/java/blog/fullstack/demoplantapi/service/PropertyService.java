package blog.fullstack.demoplantapi.service;

import blog.fullstack.shared.plant.PlantProperty;

import java.util.List;
import java.util.UUID;

public interface PropertyService {

    List<PlantProperty> getProperties(UUID plantId);
}
