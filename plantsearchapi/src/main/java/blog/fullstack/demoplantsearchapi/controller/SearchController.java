package blog.fullstack.demoplantsearchapi.controller;

import blog.fullstack.demoplantsearchapi.service.SearchService;
import blog.fullstack.shared.search.PlantSearchResultEntry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/search")
public class SearchController {

    private final SearchService searchService;

    @GetMapping
    public ResponseEntity<List<PlantSearchResultEntry>> searchPlantsByKeyword(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "7")int limit) {
        return ResponseEntity.ok(searchService.doSearch(keyword, limit));
    }
}
