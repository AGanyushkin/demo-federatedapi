package blog.fullstack.graphql.service.apiclient;

import blog.fullstack.shared.plant.PlantImage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient(value = "plantImageAPIClient", url = "${downstream.plantimageapi.url}")
public interface PlantImageApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/plant/image")
    List<PlantImage> getImages(@RequestParam UUID plantId,
                               @RequestParam(required = false) Integer limit);
}
