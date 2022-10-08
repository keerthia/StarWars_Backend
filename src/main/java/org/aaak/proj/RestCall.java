package org.aaak.proj;

import org.aaak.proj.entity.Planet;
import org.aaak.proj.entity.PlanetResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class RestCall {
    private RestTemplate restTemplate;

    public void makeRestCall() throws URISyntaxException {
        URI uri = new URI("https://swapi.dev/api/planets/");
        HttpHeaders headers = new HttpHeaders();
        //this.restTemplate=new RestTemplate();
        PlanetResponse planetResponse=new PlanetResponse();

        PlanetRestController planetRestController=new PlanetRestController();
        //Using ResponseEntity class and getForEntity Method
        //Using getForEntity instead of getForObject as this contains Header and the body of the message - to retrieve status code and the resource as an object
        //List<Planet> planetList = planetRestController.getPlanet(planetResponse,uri);
        /*System.out.println("Status Code     "+planetList.getStatusCode().toString());
        System.out.println("ContentType     "+planetResponseEntity.getHeaders().getContentType().toString());
        System.out.println("Planet Count   "+planetResponseEntity.getBody().getCount());
        System.out.println("Previous    "+planetResponseEntity.getBody().getPrevious());
        System.out.println("Next     "+planetResponseEntity.getBody().getNext());*/
        //System.out.println("Results     "+planetList);

    }

}
