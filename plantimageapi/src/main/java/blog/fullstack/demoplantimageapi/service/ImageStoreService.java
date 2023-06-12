package blog.fullstack.demoplantimageapi.service;

import blog.fullstack.shared.plant.PlantImage;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
public class ImageStoreService implements BinaryStoreService {

    @Override
    public List<PlantImage> getImagesForPlant(UUID plantId, int limit) {
        return IntStream.range(0, limit)
                .mapToObj(this::buildImage)
                .toList();
    }

    private PlantImage buildImage(int i) {
        var faker = new Faker();
        return PlantImage.builder()
                .id(UUID.randomUUID())
                .width(faker.random().nextInt(600, 2000))
                .height(faker.random().nextInt(600, 2000))
                .url(faker.internet().url())
                .build();
    }
}
