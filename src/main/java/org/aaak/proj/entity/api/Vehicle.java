package org.aaak.proj.entity.api;

import org.aaak.proj.controller.CacheEntities;
import org.aaak.proj.entity.db.DBEntity;
import org.aaak.proj.entity.db.PeopleDB;
import org.aaak.proj.entity.db.VehicleDB;

import java.util.List;

import static org.aaak.proj.util.NumberParser.*;

public class Vehicle extends APIEntity {

    private String name;
    private String model;
    private String manufacturer;
    private String costInCredits;
    private String length;
    private String maxAtmospheringSpeed;
    private String crew;
    private String passengers;
    private String cargoCapacity;


    private String consumables;
    private String vehicleClass;
    private List<String> pilots;
    private List<String> films;
    private String created;
    private String edited;
    private String url;

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public List<String> getPilots() {
        return pilots;
    }

    public void setPilots(List<String> pilots) {
        this.pilots = pilots;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }


    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    @Override
    public List<String> getVehicleUrls() {

        return null;
    }

    @Override
    public List<String> getPeopleUrls() {
        if (this.getPilots() != null)
            return this.getPilots();
        return null;
    }


    public void mapRelationships(DBEntity dbEntity) {
           VehicleDB vehicleDB = (VehicleDB) dbEntity;

            List<PeopleDB> peopleDBList = CacheEntities.retrieveDBEntities(this.getPilots());
           // List<Film> filmList = CacheEntities.retrieveDBEntities(this.getFilms());

            //vehicleDB.setFilms(filmList);
            vehicleDB.setPilots(peopleDBList);
    }

    @Override
    public VehicleDB asDBEntity(boolean mapRelationships) {
        VehicleDB vehicleDB = new VehicleDB();
        CacheEntities apiCache = new CacheEntities();
        //vehicleDB.setFilms();
        vehicleDB.setConsumables(this.consumables);
        vehicleDB.setCrew(this.crew);
        vehicleDB.setCreated(this.created);
        if (this.getCargoCapacity() != null && (!this.getCargoCapacity().equals("unknown")))
            vehicleDB.setCargoCapacity(safeIntParser(this.cargoCapacity));
        if ((this.getCostInCredits() != null) && (!this.getCostInCredits().equals("unknown")))
            vehicleDB.setCostInCredits(safeDoubleParser(this.getCostInCredits()));
        if (this.getLength() != null && (!this.getLength().equals("unknown")))
            vehicleDB.setLength(safeDoubleParser(this.getLength().replace(",", "")));
        vehicleDB.setEdited(this.edited);

        vehicleDB.setManufacturer(this.manufacturer);
        vehicleDB.setModel(this.model);
        vehicleDB.setPassengers(this.passengers);
        vehicleDB.setVehicleClass(this.vehicleClass);
        vehicleDB.setUrl(this.url);
        vehicleDB.setName(this.getName());
        vehicleDB.setId(urlToId(this.getUrl()));
        return vehicleDB;
    }
}
