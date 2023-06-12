package blog.fullstack.graphql.service.apiclient;

import blog.fullstack.shared.plant.PlantProperty;
import blog.fullstack.shared.plant.PlantTextFragment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient(value = "plantPropertyAPIClient", url = "${downstream.plantpropertyapi.url}")
public interface PlantPropertyApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/plant/property")
    List<PlantProperty> getProperties(@RequestParam UUID plantId);

    @RequestMapping(method = RequestMethod.GET, value = "/plant/description")
    List<PlantTextFragment> getTextFragments(@RequestParam UUID plantId,
                                             @RequestParam(required = false) Integer limit);
}
