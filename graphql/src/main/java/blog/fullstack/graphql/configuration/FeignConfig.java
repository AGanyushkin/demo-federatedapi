package blog.fullstack.graphql.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "blog.fullstack.graphql.service.apiclient")
public class FeignConfig {
}
