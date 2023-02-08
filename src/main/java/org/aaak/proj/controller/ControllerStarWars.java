package org.aaak.proj.controller;

import org.aaak.proj.entity.api.APIResponse;
import org.aaak.proj.services.ServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerStarWars {
    @Autowired
    ServiceAPI serviceAPI;

    public <T> List<T> getApiEntities(Class<? extends APIResponse<T>> responseClass, String entityName) {
        try {
            List<T> responseToSend = new ArrayList<>();
            String next;
            do {
                APIResponse<T> response = serviceAPI.getAll(responseClass, entityName);
                responseToSend.addAll(response.getResults());
                next = response.getNext();
                entityName = response.getNext();
            } while (next != null);

            System.out.println("Done returning entites of type " + entityName + " count " + responseToSend.size());
            return responseToSend;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }


}
