package org.aaak.proj.entity.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.aaak.proj.controller.CacheEntities;
import org.aaak.proj.entity.db.DBEntity;
import org.aaak.proj.entity.db.PeopleDB;

import java.util.List;

import static org.aaak.proj.util.NumberParser.safeIntParser;
import static org.aaak.proj.util.NumberParser.urlToId;
//import org.springframework.context.annotation.Bean;

public class People extends APIEntity {
    private String name;
    private String height;
    private String mass;
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("skin_color")

    private String skinColor;
    @JsonProperty("eye_color")

    private String eyeColor;
    @JsonProperty("birth_year")

    private String birthYear;
    private String gender;
    @JsonProperty("homeworld")

    private String homeWorld;
    private List<String> films;
    private List<String> vehicles;
    private List<String> species;
    private List<String> starships;
    private String created;
    private String edited;
    private String url;

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getHomeWorld() {
        return homeWorld;
    }

    public void setHomeWorld(String homeWorld) {
        this.homeWorld = homeWorld;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }

    public List<String> getStarships() {
        return starships;
    }

    public void setStarships(List<String> starShips) {
        this.starships = starShips;
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

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public List<String> getVehicleUrls() {
        if (this.getVehicles() != null)
            return this.getVehicles();
        return null;
    }

    @Override
    public List<String> getPeopleUrls() {

        return null;
    }

    public void mapRelationships(DBEntity dbEntity) {
        PeopleDB peopleDB = (PeopleDB) dbEntity;

        //List<Film> filmList = CacheEntities.retrieveDBEntities(this.getFilms());
        //List<VehicleDB> vehicleDBList = CacheEntities.retrieveDBEntities(this.getVehicles());
        //List<SpeciesDB> speciesDBList = CacheEntities.retrieveDBEntities(this.getSpecies());
        //List<StarshipsDB> starshipsDBList = CacheEntities.retrieveDBEntities(this.getStarships());

        //peopleDB.setFilms(filmList);

        //peopleDB.setVehicles(vehicleDBList);
        //peopleDB.setSpecies(speciesDBList);
//        peopleDB.setStarShips(starshipsDBList);
        /*System.out.println(peopleDB.getPeopleId()+" URL     "+peopleDB.getUrl());
        for (Film film:filmList
             ) {
            System.out.println(film.getFilmId()+"   URL     "+film.getUrl());
        }*/
    }


    @Override
    public PeopleDB asDBEntity(boolean mapRelationships) {
        CacheEntities apiCache = new CacheEntities();
        PeopleDB peopleDB = new PeopleDB();
        if ((this.getBirthYear() != null) && (!this.getBirthYear().equals("unknown")))
            peopleDB.setBirthYear(safeIntParser(this.getBirthYear().replace("year", "")));
        peopleDB.setGender(this.gender);
        peopleDB.setName(this.name);
        peopleDB.setEyeColor(this.getEyeColor());
        peopleDB.setHairColor(this.getHairColor());
        peopleDB.setHomeWorld(this.getHomeWorld());
        peopleDB.setSkinColor(this.getSkinColor());
        peopleDB.setUrl(this.getUrl());
        if (this.getUrl() != null)
            peopleDB.setPeopleId(urlToId(this.getUrl()));
        return peopleDB;
    }
}

