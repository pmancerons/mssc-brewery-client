package curso.microservices.msscbreweryclient.web.client;

import curso.microservices.msscbreweryclient.web.model.BeerDTO;
import curso.microservices.msscbreweryclient.web.model.CustomerDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "curso.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer";

    public final String CUSTOMER_PATH_V1 = "/api/v1/customer";

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private String apiHost;

    public BeerDTO getBeerById(UUID id){
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + "/" + id.toString(), BeerDTO.class);
    }

    public URI saveNewBeer(BeerDTO beerDTO){
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1 , beerDTO);
    }

    public void updateBeer(UUID id, BeerDTO beerDTO){
        restTemplate.put(apiHost + BEER_PATH_V1 + "/" + id.toString(), beerDTO);
    }

    public void deleteBeer(UUID id){
        restTemplate.delete(apiHost + BEER_PATH_V1 + "/" + id.toString());
    }


    public CustomerDTO getCustomerById(UUID id){
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + "/" + id.toString(), CustomerDTO.class);
    }

    public URI saveNewCustomer(CustomerDTO customerDTO){
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1 , customerDTO);
    }

    public void updateCustomer(UUID id, CustomerDTO customerDTO){
        restTemplate.put(apiHost + CUSTOMER_PATH_V1 + "/" + id.toString(), customerDTO);
    }

    public void deleteCustomer(UUID id){
        restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + "/" + id.toString());
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
