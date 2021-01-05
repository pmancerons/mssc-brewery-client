package curso.microservices.msscbreweryclient.web.client;

import curso.microservices.msscbreweryclient.web.model.BeerDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
@ConfigurationProperties(value = "curso.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer";

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private String apiHost;

    public BeerDTO getBeerById(UUID id){
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + "/" + id.toString(), BeerDTO.class);
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
