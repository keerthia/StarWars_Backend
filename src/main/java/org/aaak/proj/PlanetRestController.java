package org.aaak.proj;

import org.aaak.proj.entity.People;
import org.aaak.proj.entity.Planet;
import org.aaak.proj.entity.PlanetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class PlanetRestController {

    private PlanetResponse planetResponse;
    @Autowired
    private RestTemplate restTemplate=new RestTemplate();

     @GetMapping("/planet/{planetid}/")
    public List<Planet> getAllPlanets()throws URISyntaxException {
         URI uri = new URI("https://swapi.dev/api/planets/");
         this.planetResponse=new PlanetResponse();
         ResponseEntity<PlanetResponse> planetResponse = restTemplate.getForEntity(uri, PlanetResponse.class);
         return planetResponse.getBody().getResults();
     }


}
