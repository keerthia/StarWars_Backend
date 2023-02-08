package org.aaak.proj.entity.db;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "people")
public class PeopleDB implements DBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "people_id", nullable = false)
    private Long peopleId;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private int birthYear;
    private String gender;
    private String homeWorld;
    /* @ManyToMany(cascade = CascadeType.ALL)
     private List<Film> films;*/
    private String name;
    /* @OneToMany(cascade = CascadeType.ALL)
     private List<VehicleDB> vehicles;

     //private List<SpeciesDB> species;
     @OneToMany(cascade = CascadeType.ALL)

     private List<StarshipsDB> starShips;*/
    private Date created;
    private Date edited;
    private String url;

    public Long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Long peopleId) {
        this.peopleId = peopleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeWorld() {
        return homeWorld;
    }

    public void setHomeWorld(String homeWorld) {
        this.homeWorld = homeWorld;
    }
    /*public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }*/

    /*public List<VehicleDB> getVehicles() {
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
    }*/

    /*public List<StarshipsDB> getStarShips() {
        return starShips;
    }

    public void setStarShips(List<StarshipsDB> starShips) {
        this.starShips = starShips;
    }*/

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getEdited() {
        return edited;
    }

    public void setEdited(Date edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public DBEntity asDBEntity() {
        PeopleDB peopleDB = new PeopleDB();
        return null;
    }
}
