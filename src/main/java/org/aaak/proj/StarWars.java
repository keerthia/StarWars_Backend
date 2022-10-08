package org.aaak.proj;


import org.aaak.proj.entity.Planet;

import java.io.IOException;
import java.util.List;

public class StarWars {

    public static void main(String [] args) throws IOException {
        try {
            PlanetRestController planetRestController=new PlanetRestController();
            List<Planet> planetList=planetRestController.getAllPlanets();
            System.out.println(planetList.toString());


        }catch(Exception e)
        {
            System.out.println("Exception occurred"+e);
        }
    }
}



