package org.aaak.proj.controller;

import org.aaak.proj.entity.People;
import org.aaak.proj.entity.Planet;
import org.aaak.proj.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@RestController
public class ControllerStarWars<T> {
    @Autowired
    private ServiceAPI serviceAPI;
    final HashMap<String, String> responseClassName = new HashMap<>();

    private URI uri;

    @GetMapping("/api/{entityName}")
    public <T> T getResponseService(@PathVariable String entityName, String url) throws ClassNotFoundException {
        serviceAPI = new ServiceAPI();
        T response;
        //Initializing the className
        responseClassName.put("planets", "org.aaak.proj.entity.PlanetResponse");
        responseClassName.put("people", "org.aaak.proj.entity.PeopleResponse");
        responseClassName.put("vehicle", "org.aaak.proj.entity.VehicleResponse");

        try {
            uri = new URI(url);
            response = (T) serviceAPI.getAll(Class.forName(responseClassName.get(entityName)), entityName);
            System.out.println((response.getClass().getMethod("getCount", null)));//DeclaredMethod("getCount",null)));
            Method methodGetResults = response.getClass().getMethod("getResults", null);
            Method methodGetCounts = response.getClass().getMethod("getCount", null);

            System.out.println("Get Results for the Response Object     " + methodGetResults.invoke(response, null).toString());
            System.out.println("Get Count for the Response Object     " + methodGetCounts.invoke(response, null).toString());

            getResultList(methodGetResults.invoke(response,null), entityName);
                /*List<T> listResults = null;

                switch (entityName){
                    case "planets":
                       listResults= (List<T>) methodGetResults.invoke(response,null);
                        for(int i=0;i<listResults.size();i++){
                            System.out.println("Planet Name     "+listResults.get(i).getName());
                        }

                        //displayentityDetails(listResults,entityName);
                    case "people":
                        List<People> listResults= (List<People>) methodGetResults.invoke(response,null);

                }
               // List<Planet> planetList= (List<Planet>) methodGetResults.invoke(response,null);
*/
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return (T) response.getClass();


    }

    private void getResultList(Object methodGetResults, String entityName) {

        try {
            switch (entityName) {
                case "planets":
                    List<Planet> planetList = null;
                    planetList = ((List<Planet>) methodGetResults);
                    System.out.println(planetList);
                    for (int i = 0; i < planetList.size(); i++) {
                        System.out.println("Planet Name     " + planetList.get(i).getName());
                    }
                    break;
                case "people":
                    List<People> peopleList = ((List<People>) methodGetResults);
                    for (int i = 0; i < peopleList.size(); i++) {
                        System.out.println("People Name     " + peopleList.get(i).getName());
                    }
                    break;
                case "vehicle":
                    List<Vehicle> vehicleList = (List<Vehicle>) methodGetResults;
                    for (int i = 0; i < vehicleList.size(); i++) {
                        System.out.println("vehicle Name     " + vehicleList.get(i).getName());
                    }
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void display(List<T> planetList) {

    }

}
