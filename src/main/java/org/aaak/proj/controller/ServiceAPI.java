package org.aaak.proj.controller;

import org.aaak.proj.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


@Service
public class ServiceAPI {

    public <T> T getAll(Class<T> className, String entityName) throws URISyntaxException{
        RestTemplate restTemplate=new RestTemplate();
        URI uri = new URI("https://swapi.dev/api/".concat(entityName));
        ResponseEntity<T> responseEntity = restTemplate.exchange(uri,HttpMethod.GET,null, className);
        System.out.println(responseEntity.getBody());
        System.out.println("Class Name"+responseEntity.getBody().getClass().getName());
        return responseEntity.getBody();
    }



}
