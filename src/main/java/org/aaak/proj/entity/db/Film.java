package org.aaak.proj.entity.db;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "film")
public class Film implements DBEntity {

    @Id
    @Column(name = "film_id", nullable = false)
    private long filmId;
    private String title;
    private String episodeId;
    @Column(columnDefinition="TEXT")
    private String openingCrawl;
    private String director;
    private String producer;
    private Date releaseDate;
   @ManyToMany(cascade = CascadeType.ALL)
    private List<PeopleDB> characters;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<VehicleDB> vehicles;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<PlanetDB> planets;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<SpeciesDB> species;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<StarshipsDB> starships;
    private String Url;

    public List<PlanetDB> getPlanets() {
        return planets;
    }

    public void setPlanets(List<PlanetDB> planets) {
        this.planets = planets;
    }



    public List<VehicleDB> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleDB> vehicles) {
        this.vehicles = vehicles;
    }
   public List<SpeciesDB> getSpecies() {
       return species;
   }

    public void setSpecies(List<SpeciesDB> species) {
        this.species = species;
    }
    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public List<StarshipsDB> getStarships() {
        return starships;
    }

    public void setStarships(List<StarshipsDB> starships) {
        this.starships = starships;
    }
    public List<PeopleDB> getCharacters() {
        return characters;
    }

    public void setCharacters(List<PeopleDB> characters) {
        this.characters = characters;
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



    @Override
    public String getUrl() {
        return Url;
    }

    @Override
    public void setUrl(String url) {
        this.Url = url;
    }
}




