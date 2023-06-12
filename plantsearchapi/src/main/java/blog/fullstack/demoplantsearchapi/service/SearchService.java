package blog.fullstack.demoplantsearchapi.service;

import blog.fullstack.shared.search.PlantSearchResultEntry;

import java.util.List;

public interface SearchService {
    List<PlantSearchResultEntry> doSearch(String keyword, int limit);
}
