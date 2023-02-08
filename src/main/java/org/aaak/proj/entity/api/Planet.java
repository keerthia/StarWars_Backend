package org.aaak.proj.entity.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.aaak.proj.controller.CacheEntities;
import org.aaak.proj.entity.db.DBEntity;
import org.aaak.proj.entity.db.PeopleDB;
import org.aaak.proj.entity.db.PlanetDB;

import java.util.List;

import static org.aaak.proj.util.NumberParser.*;


public class Planet extends APIEntity {


    private String climate;
    private String diameter;
    private String gravity;
    private String name;
    @JsonProperty("orbital_period")
    private String orbitalPeriod;
    private String population;
    private List<String> residents;

    private List<String> films;

    @JsonProperty("rotation_period")

    private String rotationPeriod;
    @JsonProperty("surface_water")
    private String surfaceWater;
    private String terrain;

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(String orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public List<String> getResidents() {
        return residents;
    }

    public void setResidents(List<String> residents) {
        this.residents = residents;
    }

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }

    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    @Override
    public List<String> getVehicleUrls() {
        return null;
    }

    public void mapRelationships(DBEntity dbEntity) {
        PlanetDB planetDB = (PlanetDB) dbEntity;

        List<PeopleDB> peopleDBList = CacheEntities.retrieveDBEntities(this.getResidents());
        // List<Film> filmList = CacheEntities.retrieveDBEntities(this.getFilms());

        planetDB.setResidents(peopleDBList);
        // planetDB.setFilms(filmList);
    }


    @Override
    public List<String> getPeopleUrls() {
        if (this.getResidents() != null)
            return this.getResidents();
        return null;
    }


    @Override
    public PlanetDB asDBEntity(boolean mapRelationships) {
        PlanetDB planetDB = new PlanetDB();
        List<String> people = this.getResidents();
        //planetDB.setCreated(new SimpleDateFormat("dd/mm/yyyy").parse(this.created));
        //planetDB.setEdited(Date.valueOf(this.edited));
        planetDB.setClimate(this.getClimate());
        planetDB.setName(this.name);

        planetDB.setDiameter(safeDoubleParser(this.getDiameter()));
        planetDB.setGravity(this.getGravity());
        planetDB.setPopulation(safeDoubleParser(this.getPopulation()));
        planetDB.setOrbitalPeriod(safeDoubleParser(this.getOrbitalPeriod()));
        planetDB.setSurfaceWater(safeDoubleParser(this.getSurfaceWater()));
        planetDB.setUrl(this.getUrl());
        if (this.getUrl() != null)
            planetDB.setPlanet_id(urlToId(this.getUrl()));
        //Set People For Planet
        //planetDB.setResidents();
        //planetDB.setSpecies(null);
        return planetDB;

    }
}
