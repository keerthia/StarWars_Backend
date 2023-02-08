package org.aaak.proj.entity.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.aaak.proj.controller.CacheEntities;
import org.aaak.proj.entity.db.DBEntity;
import org.aaak.proj.entity.db.PeopleDB;
import org.aaak.proj.entity.db.SpeciesDB;

import java.util.List;

import static org.aaak.proj.util.NumberParser.urlToId;

public class Species extends APIEntity {

    private String name;
    private String classification;
    private String designation;
    @JsonProperty("average_height")
    private String averageHeight;
    @JsonProperty("skin_color")

    private String skinColors;
    @JsonProperty("hair_color")

    private String hairColors;
    @JsonProperty("eye_color")

    private String eyeColors;
    @JsonProperty("average_lifespan")

    private String averageLifespan;


    @JsonProperty("homeworld")

    private String homeWorld;
    private String language;
    private List<String> people;
    private List<String> films;
    private String created;
    private String edited;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getHomeWorld() {
        return homeWorld;
    }

    public void setHomeWorld(String homeWorld) {
        this.homeWorld = homeWorld;
    }

    public String getAverageHeight() {
        return averageHeight;
    }

    public void setAverageHeight(String averageHeight) {
        this.averageHeight = averageHeight;
    }

    public String getSkinColors() {
        return skinColors;
    }

    public void setSkinColors(String skinColors) {
        this.skinColors = skinColors;
    }

    public String getHairColors() {
        return hairColors;
    }

    public void setHairColors(String hairColors) {
        this.hairColors = hairColors;
    }

    public String getEyeColors() {
        return eyeColors;
    }

    public void setEyeColors(String eyeColors) {
        this.eyeColors = eyeColors;
    }

    public String getAverageLifespan() {
        return averageLifespan;
    }

    public void setAverageLifespan(String averageLifespan) {
        this.averageLifespan = averageLifespan;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
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
        if (this.getPeople() != null)
            return this.getPeople();
        return null;
    }

    public void mapRelationships(DBEntity dbEntity) {
        SpeciesDB speciesDB = (SpeciesDB) dbEntity;

        List<PeopleDB> peopleDBList = CacheEntities.retrieveDBEntities(this.getPeople());
        //List<Film> filmList = CacheEntities.retrieveDBEntities(this.getFilms());

        speciesDB.setPeople(peopleDBList);
        // speciesDB.setFilms(filmList);*/
    }

    @Override
    public SpeciesDB asDBEntity(boolean mapRelationships) {
        CacheEntities apiCache = new CacheEntities();
        SpeciesDB speciesDB = new SpeciesDB();
        speciesDB.setName(this.getName());
        speciesDB.setAverageHeight(this.getAverageHeight());
        speciesDB.setClassification(this.getClassification());
        speciesDB.setCreated(this.getCreated());
        speciesDB.setEdited(this.getEdited());
        speciesDB.setDesignation(this.getDesignation());
        speciesDB.setAverageLifespan(this.getAverageLifespan());
        speciesDB.setEyeColors(this.getEyeColors());
        speciesDB.setHairColors(this.getHairColors());
        speciesDB.setLanguage(this.getLanguage());
        speciesDB.setSkinColors(this.getSkinColors());
        speciesDB.setUrl(this.getUrl());
        if (this.getUrl() != null)
            speciesDB.setId(urlToId(this.getUrl()));
        return speciesDB;
    }

}
