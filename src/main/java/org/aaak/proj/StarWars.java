package org.aaak.proj;


import org.aaak.proj.controller.CacheEntities;
import org.aaak.proj.controller.ControllerStarWars;
import org.aaak.proj.entity.db.DBEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Map;


@EnableJpaRepositories
@EnableAutoConfiguration
@SpringBootApplication
public class StarWars {
    private static Map<String, DBEntity> filmToAllMap;
    @Autowired
    ControllerStarWars controllerStarWars;
    @Autowired
    CacheEntities cacheEntities;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StarWars.class, args);


    }


    public void run(String... args) throws Exception {
        try {
            //System.setProperty("server.port", "8080");
            //SpringApplication.run(StarWars.class);


         /*   String url = "https://swapi.py4e.com/api/";
            List<Films> filmEntities = controllerStarWars.getApiEntities(FilmsResponse.class, url.concat("films"));
            List<People> peopleEntities = controllerStarWars.getApiEntities(PeopleResponse.class, url.concat("people"));
            List<Planet> planetsEntities = controllerStarWars.getApiEntities(PlanetResponse.class, url.concat("planets"));
            List<Vehicle> vehicleEntities = controllerStarWars.getApiEntities(VehicleResponse.class, url.concat("vehicles"));
            List<Starship> starshipEntities = controllerStarWars.getApiEntities(StarshipResponse.class, url.concat("starships"));
            List<Species> speciesEntities = controllerStarWars.getApiEntities(SpeciesResponse.class, url.concat("species"));


            //filmEntities.forEach( (obj) -> {System.out.println(obj.getTitle() + " " + obj.getReleaseDate());});

            cacheEntities.createCacheMap(filmEntities);
            cacheEntities.createCacheMap(peopleEntities);
            cacheEntities.createCacheMap(planetsEntities);
            cacheEntities.createCacheMap(vehicleEntities);
            cacheEntities.createCacheMap(starshipEntities);
            cacheEntities.createCacheMap(speciesEntities);


            //cacheEntities.displayCache();
            filmToAllMap = new HashMap<>();
            filmToAllMap = cacheEntities.createApiEntitiesToDBMapping();
            cacheEntities.createNestedDBMapping();
            //cacheEntities.addToPeopleDB
            cacheEntities.displayDBMap();
            cacheEntities.addDBEntityToTable();

//            cacheEntities.addInTable();
*/

        } catch (Exception e) {
            System.out.println("Exception occurred" + e);
        }
        System.exit(0);
    }


}



