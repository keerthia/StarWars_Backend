package org.aaak.proj.entity.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.aaak.proj.controller.CacheEntities;
import org.aaak.proj.entity.db.*;

import java.util.Date;
import java.util.List;

import static org.aaak.proj.util.NumberParser.safeLongParser;
import static org.aaak.proj.util.NumberParser.urlToId;


public class Films extends APIEntity {
    private String url;
    private String title;
    @JsonProperty("episode_id")
    private String episodeId;
    @JsonProperty("opening_crawl")
    private String openingCrawl;
    private String director;
    private String producer;
    @JsonProperty("release_date")
    private Date releaseDate;
    private List<String> characters;
    private List<String> planets;
    private List<String> starships;
    private List<String> vehicles;
    private List<String> species;

    public List<String> getSpecies() {
        return species;
    }

    public void setSpecies(List<String> species) {
        this.species = species;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(String episodeId) {
        this.episodeId = episodeId;
    }

    public String getOpeningCrawl() {
        return openingCrawl;
    }

    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public List<String> getPlanets() {
        return planets;
    }

    public void setPlanets(List<String> planets) {
        this.planets = planets;
    }

    public List<String> getStarships() {
        return starships;
    }

    public void setStarships(List<String> starships) {
        this.starships = starships;
    }

    public List<String> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public List<String> getVehicleUrls() {
        if (this.getVehicles() != null)
            return this.getVehicles();
        return null;
    }

    @Override
    public List<String> getPeopleUrls() {
        if (this.getCharacters() != null)
            return this.getCharacters();
        return null;
    }

    public void mapRelationships(DBEntity dbEntity) {
        Film film = (Film) dbEntity;

        List<VehicleDB> vehicleDBList = CacheEntities.retrieveDBEntities(this.getVehicles());
        List<PeopleDB> peopleDBList = CacheEntities.retrieveDBEntities(this.getCharacters());
        List<StarshipsDB> starshipsDBList = CacheEntities.retrieveDBEntities(this.getStarships());
        List<SpeciesDB> speciesDBList = CacheEntities.retrieveDBEntities(this.getSpecies());
        List<PlanetDB> planetDBList = CacheEntities.retrieveDBEntities(this.getPlanets());

        film.setVehicles(vehicleDBList);
        film.setCharacters(peopleDBList);
        film.setStarships(starshipsDBList);
       film.setSpecies(speciesDBList);
        film.setPlanets(planetDBList);
    }


    public Film asDBEntity(boolean mapRelationships) {
        CacheEntities apiCache = new CacheEntities();
        Film film = new Film();
        //Mapping PeopleAPIEntity List to Film
        //film.setId(safeIntParser(this.getUrl().split("/")[4]));
        film.setDirector(this.getDirector());
        film.setEpisodeId(this.getEpisodeId());
        film.setTitle(this.getTitle());
        film.setProducer(this.getProducer());
        film.setOpeningCrawl(this.getOpeningCrawl());
        film.setReleaseDate(this.getReleaseDate());
        film.setUrl(this.getUrl());
        if (this.getUrl() != null)
            film.setFilmId(urlToId(this.getUrl()));
        // this.display(film);
        return film;
    }

    private void display(Film film) {
        System.out.println("Director  " + film.getDirector());
        System.out.println("Producer  " + film.getProducer());
        System.out.println("Episode Id  " + film.getEpisodeId());
        System.out.println("Title  " + film.getTitle());
        System.out.println("Characters");
/*        for (int i = 0; i < (film.getCharacters().size()); i++) {
            System.out.print("  " + film.getCharacters().get(i));
        }
        System.out.println("\nVehicles");
        for (int i = 0; i < (film.getVehicles().size()); i++) {
            System.out.print("  " + film.getVehicles().get(i));
        }*/

    }

    private List<PeopleDB> strToList(List<String> characters) {

        return null;

    }
}
