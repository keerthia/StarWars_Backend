package org.aaak.proj;


import org.aaak.proj.controller.ControllerStarWars;
import org.aaak.proj.entity.Planet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;

@SpringBootApplication
public class StarWars {
    //private HashMap<String,T> className=new HashMap<>();
    public static void main(String [] args) throws IOException {
        try {
            //SpringApplication.run(StarWars.class, args);

            ControllerStarWars controllerStarWars=new ControllerStarWars();
            //Initializing url
            String url="https://swapi.dev/api/planets/";
            String[] subString=url.split("/");

           controllerStarWars.getResponseService(subString[4],url);


        }catch(Exception e)
        {
            System.out.println("Exception occurred"+e);
        }
    }
}



