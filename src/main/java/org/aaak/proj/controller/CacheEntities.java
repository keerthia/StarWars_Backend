package org.aaak.proj.controller;

import org.aaak.proj.entity.api.APIEntity;
import org.aaak.proj.entity.db.DBEntity;
import org.aaak.proj.entity.db.aaak;
import org.aaak.proj.entity.db.aaakForeignTable;
import org.aaak.proj.services.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CacheEntities {
    public static Map<String, DBEntity> urlToDbEntityMap = new HashMap<>();
    static Map<String, APIEntity> urlToApiEntityMap = new HashMap<>();
    @Autowired
    RepoService repoService;

    public static <T extends DBEntity> List<T> retrieveDBEntities(List<String> relatedEntities) {
        return relatedEntities
                .stream()
                .map((url) -> (T) CacheEntities.urlToDbEntityMap.get(url))
                .collect(Collectors.toList());
    }


    public void createCacheMap(List<? extends APIEntity> entityList) throws NoSuchFieldException {
        for (APIEntity entity : entityList) {
            String entityHash = entity.getUrl();
            urlToApiEntityMap.put(entityHash, entity);
        }
    }


    public void displayCache() {
        urlToApiEntityMap.forEach((key, value)
                -> System.out.println(key + " : "
                + (value.getUrl())));
    }

    public Map<String, DBEntity> createApiEntitiesToDBMapping() {
        //TODO: merge createFilmToAllMapping and createPeopleToAllMapping - done for now
        for (Map.Entry<String, APIEntity> entry : urlToApiEntityMap.entrySet()) {
            urlToDbEntityMap.put(entry.getValue().getUrl(), entry.getValue().asDBEntity(false));
        }
        return urlToDbEntityMap;
    }

    public void createNestedDBMapping() {
        for (Map.Entry<String, DBEntity> entry : urlToDbEntityMap.entrySet()) {
            DBEntity dbEntity = entry.getValue();
            APIEntity apiEntity = urlToApiEntityMap.get(entry.getKey());
            if (apiEntity != null) {
                apiEntity.mapRelationships(dbEntity);
            }


            //Retrieving the Object from APIEntity
                /*if(urlToApiEntities.containsKey(entry.getKey())) {
                    APIEntity apiEntity = urlToApiEntities.get(entry.getKey());
                    //Retrieving all the vehicle Urls String
                    List<String> vehicleUrls=apiEntity.getVehicleUrls();
                    List<String> peopleUrls=apiEntity.getPeopleUrls();
                    if(vehicleUrls!=null){
                        //setDBEntity(vehicleUrls,dbEntity);

                        //Retrieving DB Objects from DBEntityMap
                        List<VehicleDB> vehicleDBList = new ArrayList<>();
                        for (String vehicleUrlToFetch:vehicleUrls
                             ) {
                                vehicleDBList.add((VehicleDB) urlToDbEntities.get(vehicleUrlToFetch));
                                }
                        dbEntity.setVehicleList(vehicleDBList);
                    }
                }*/

        }
    }


    private void setDBEntity(List<String> vehicleUrls, DBEntity dbEntity) {


    }


    public void displayDBMap() {
        System.out.println("Display DB Map");
        urlToDbEntityMap.forEach((key, value)
                -> System.out.println(key + " : "
                + (value.toString())));
    }


    public List<? extends APIEntity> getEntities(String filmUrl, List<String> entityList) {
        List<APIEntity> entityListForFilm = new ArrayList<>();
        for (int i = 0; i < entityList.size(); i++) {
            entityListForFilm.add(urlToApiEntityMap.get(entityList.get(i)));
        }
        return entityListForFilm;
    }

    public void addInTable() {
        aaak aaakObj = new aaak();
        aaakForeignTable aaakForeignTable = new aaakForeignTable();
        aaakObj.setName("Ashok");
        //planetService.addAAAK(aaakObj);
        aaakForeignTable.setAaakObj(aaakObj);
        //planetService.addAAAKForeignTable(aaakForeignTable);
        //planetService.addAAAK(aaakObj);

    }

    public void addDBEntityToTable() {
        for (Map.Entry<String, DBEntity> entry : urlToDbEntityMap.entrySet()) {
            if (entry.getValue().getUrl().contains("species"))
               repoService.addToSpeciesTable(entry.getValue());
            else if (entry.getValue().getUrl().contains("starships"))
                repoService.addToStarShipTable(entry.getValue());
            else if (entry.getValue().getUrl().contains("vehicle")) {
                repoService.addToVehicleTable(entry.getValue());
            }
            else if (entry.getValue().getUrl().contains("people"))
                repoService.addToPeopleTable(entry.getValue());

        else if (entry.getValue().getUrl().contains("film"))
            repoService.addToFilmTable(entry.getValue());
            else if (entry.getValue().getUrl().contains("planet"))
                repoService.addToPlanetTable(entry.getValue());
        }
    }
}

