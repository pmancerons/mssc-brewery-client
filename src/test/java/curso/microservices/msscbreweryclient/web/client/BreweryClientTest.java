package curso.microservices.msscbreweryclient.web.client;

import curso.microservices.msscbreweryclient.web.model.BeerDTO;
import curso.microservices.msscbreweryclient.web.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDTO beerDTO = client.getBeerById(UUID.randomUUID());

        assertNotNull(beerDTO);
    }


    @Test
    void saveBeer() {
        BeerDTO beerDTO = BeerDTO.builder().beerName("new beer").build();

        URI uri = client.saveNewBeer(beerDTO);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }


    @Test
    void updateBeer() {
        BeerDTO beerDTO = BeerDTO.builder().beerName("new beer").build();

        client.updateBeer(UUID.randomUUID(),beerDTO);
    }

    @Test
    void deleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }


    @Test
    void getCustomerById() {
        CustomerDTO customerDTO = client.getCustomerById(UUID.randomUUID());

        assertNotNull(customerDTO);
    }


    @Test
    void saveCustomer() {
        CustomerDTO customerDTO = CustomerDTO.builder().customerName("new customer").build();

        URI uri = client.saveNewCustomer(customerDTO);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }


    @Test
    void updateCustomer() {
        CustomerDTO customerDTO = CustomerDTO.builder().customerName("new customer").build();

        client.updateCustomer(UUID.randomUUID(),customerDTO);
    }

    @Test
    void deleteCustomer(){
        client.deleteCustomer(UUID.randomUUID());
    }
}