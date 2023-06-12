package blog.fullstack.demoplantapi.service;

import blog.fullstack.shared.plant.PlantProperty;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlantPropertyService implements PropertyService {

    @Override
    public List<PlantProperty> getProperties(UUID plantId) {
        var faker = new Faker();
        return List.of(
                PlantProperty.builder()
                        .id(UUID.randomUUID())
                        .type(PlantProperty.PropertyType.COLOR)
                        .name("leaf color")
                        .value(faker.color().name())
                        .build(),
                PlantProperty.builder()
                        .id(UUID.randomUUID())
                        .type(PlantProperty.PropertyType.COLOR)
                        .name("root color")
                        .value(faker.color().name())
                        .build(),
                PlantProperty.builder()
                        .id(UUID.randomUUID())
                        .type(PlantProperty.PropertyType.HEIGHT)
                        .name("max height")
                        .value(Double.toString(faker.random().nextDouble(3, 20)))
                        .build()
        );
    }
}
