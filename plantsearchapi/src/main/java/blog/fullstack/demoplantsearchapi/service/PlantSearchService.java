package blog.fullstack.demoplantsearchapi.service;

import blog.fullstack.shared.search.PlantSearchResultEntry;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
public class PlantSearchService implements SearchService {

    @Override
    public List<PlantSearchResultEntry> doSearch(String keyword, int limit) {
        return IntStream.range(0, limit)
                .mapToObj(this::createEntry)
                .sorted(Comparator.comparingDouble(PlantSearchResultEntry::getScore))
                .toList();
    }

    private PlantSearchResultEntry createEntry(int i) {
        return PlantSearchResultEntry.builder()
                .id(UUID.randomUUID())
                .score(new Random().nextDouble())
                .build();
    }
}
