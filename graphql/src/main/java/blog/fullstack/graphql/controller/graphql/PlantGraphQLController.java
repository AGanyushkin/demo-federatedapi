package blog.fullstack.graphql.controller.graphql;

import blog.fullstack.graphql.service.apiclient.PlantImageApiClient;
import blog.fullstack.graphql.service.apiclient.PlantPropertyApiClient;
import blog.fullstack.graphql.service.apiclient.PlantSearchApiClient;
import blog.fullstack.shared.plant.PlantImage;
import blog.fullstack.shared.plant.PlantProperty;
import blog.fullstack.shared.plant.PlantTextFragment;
import blog.fullstack.shared.search.PlantSearchResultEntry;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class PlantGraphQLController {

    private final PlantSearchApiClient searchClient;
    private final PlantPropertyApiClient propertyClient;
    private final PlantImageApiClient imageClient;

    @QueryMapping
    public List<PlantSearchResultEntry> search(@Argument String keyword,
                                               @Argument Integer limit) {
        return searchClient.doSearch(keyword, limit);
    }

    @QueryMapping
    public List<PlantProperty> properties(@Argument UUID plantId) {
        return propertyClient.getProperties(plantId);
    }

    @QueryMapping
    public List<PlantImage> images(@Argument UUID plantId, @Argument Integer limit) {
        return imageClient.getImages(plantId, limit);
    }

    @QueryMapping
    public List<PlantTextFragment> description(@Argument UUID plantId, @Argument Integer limit) {
        return propertyClient.getTextFragments(plantId, limit);
    }

    @SchemaMapping
    public List<PlantTextFragment> plantTextFragments(PlantSearchResultEntry searchResultEntry,
                                                      @Argument Integer limit) {
        return propertyClient.getTextFragments(searchResultEntry.getId(), limit);
    }

    @SchemaMapping
    public List<PlantProperty> properties(PlantSearchResultEntry searchResultEntry) {
        return propertyClient.getProperties(searchResultEntry.getId());
    }

    @SchemaMapping
    public List<PlantImage> images(PlantSearchResultEntry searchResultEntry,
                                   @Argument Integer limit) {
        return imageClient.getImages(searchResultEntry.getId(), limit);
    }
}
