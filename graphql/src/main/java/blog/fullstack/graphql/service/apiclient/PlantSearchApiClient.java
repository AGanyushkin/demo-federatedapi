package blog.fullstack.graphql.service.apiclient;

import blog.fullstack.shared.search.PlantSearchResultEntry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "searchAPIClient", url = "${downstream.searchapi.url}")
public interface PlantSearchApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    List<PlantSearchResultEntry> doSearch(@RequestParam String keyword,
                                          @RequestParam(required = false) Integer limit);
}
