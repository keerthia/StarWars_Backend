package org.aaak.proj;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class ClassTest {
    public static void main(String [] args) throws IOException {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://swapi.dev/api/people/")).GET().build();
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println("REsponse"+response.body());

                //Response to JsonObject
                String s=response.body().toString();
                Object obj= JsonParser.parseString(s);
                JsonObject jsonObject = (JsonObject)obj;
                //Planets planets=new Planets();
                String jsonString=jsonObject.toString();
                for (String key : jsonObject.keySet()) {

                   // planets.setName(key);
                    System.out.println(key + "    " + jsonObject.get(key));
                    }


        }catch(Exception e)
        {
            System.out.println("Exception occurred"+e);
        }
    }
}



