package org.aaak.proj.entity.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.aaak.proj.controller.CacheEntities;
import org.aaak.proj.entity.db.DBEntity;
import org.aaak.proj.entity.db.PeopleDB;
import org.aaak.proj.entity.db.StarshipsDB;

import java.util.List;

import static org.aaak.proj.util.NumberParser.*;

public class Starship extends APIEntity {

    List<String> pilots;
    List<String> films;
    private String name;
    private String model;
    private String manufacturer;
    @JsonProperty("cost_in_credits")
    private String costInCredits;
    private String length;
    @JsonProperty("max_atmosphering_speed")

    private String maxAtmospheringSpeed;
    private String crew;
    private String passengers;
    @JsonProperty("cargo_capacity")

    private String cargoCapacity;
    private String consumables;
    @JsonProperty("hyperdrive_rating")
    private String hyperdriveRating;
    private String MGLT;
    @JsonProperty("starship_class")
    private String starshipClass;
    private String created;
    private String edited;
    private String url;

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

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
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

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    public void setHyperdriveRating(String hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    public String getMGLT() {
        return MGLT;
    }

    public void setMGLT(String MGLT) {
        this.MGLT = MGLT;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    public List<String> getPilots() {
        return pilots;
    }

    public void setPilots(List<String> pilots) {
        this.pilots = pilots;
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        StarshipsDB starshipsDB = (StarshipsDB) dbEntity;

        List<PeopleDB> peopleDBList = CacheEntities.retrieveDBEntities(this.getPilots());
        //List<Film> filmList = CacheEntities.retrieveDBEntities(this.getFilms());

        starshipsDB.setPilots(peopleDBList);
        //starshipsDB.setFilms(filmList);*/
    }

    @Override
    public StarshipsDB asDBEntity(boolean mapRelationships) {
        CacheEntities apiCache = new CacheEntities();
        StarshipsDB starshipsDB = new StarshipsDB();
        starshipsDB.setConsumables(this.getConsumables());
        starshipsDB.setCargoCapacity(this.getCargoCapacity());
        starshipsDB.setCreated(this.getCreated());
        starshipsDB.setCrew(this.getCrew());
        starshipsDB.setEdited(this.getEdited());
        starshipsDB.setHyperdriveRating(this.getHyperdriveRating());
        starshipsDB.setManufacturer(this.getManufacturer());
        starshipsDB.setModel(this.getModel());
        starshipsDB.setName(this.getName());
        starshipsDB.setUrl(this.getUrl());
        starshipsDB.setStarshipClass(this.getStarshipClass());
        starshipsDB.setUrl(this.getUrl());
        if (this.getUrl() != null)
            starshipsDB.setId(urlToId(this.getUrl()));
        if (this.getLength() != null && (!this.getLength().equals("unkown")))
            starshipsDB.setLength(safeDoubleParser(this.getLength().replace(",", "")));

        return starshipsDB;
    }
}
