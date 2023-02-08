package org.aaak.proj.services;

import org.aaak.proj.entity.api.APIEntity;
import org.aaak.proj.entity.api.APIResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;


@Service
public class ServiceAPI {

    public <T> APIResponse<T> getAll(Class<? extends APIResponse<T>> apiResponseClass, String entityName) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI(entityName);
        ResponseEntity<? extends APIResponse<T>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, apiResponseClass);
        return responseEntity.getBody();
    }

    public <T> APIEntity<T> getEntity(Class<? extends APIEntity<T>> apiEntity, String entityName, String id) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://swapi.py4e.com/api/".concat(entityName) + "/".concat(id));
        ResponseEntity<? extends APIEntity<T>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, apiEntity);
        return responseEntity.getBody();
    }

}
