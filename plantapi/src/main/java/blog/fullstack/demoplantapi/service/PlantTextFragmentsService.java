package blog.fullstack.demoplantapi.service;

import net.datafaker.Faker;
import blog.fullstack.shared.plant.PlantTextFragment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
public class PlantTextFragmentsService implements TextFragmentsService {

    @Override
    public List<PlantTextFragment> getFragments(UUID plantId, int limit) {
        return IntStream.range(0, limit)
                .mapToObj(this::buildTextFragment)
                .toList();
    }

    private PlantTextFragment buildTextFragment(int i) {
        var faker = new Faker();
        return PlantTextFragment.builder()
                .id(UUID.randomUUID())
                .text(faker.bigBangTheory().quote())
                .build();
    }
}
