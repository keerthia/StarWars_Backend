package org.aaak.proj.entity.db;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicle")
public class VehicleDB implements DBEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String model;
    private String manufacturer;
    private double costInCredits;
    private double length;
    private double maxAtmospheringSpeed;
    private String crew;
    private String passengers;
    private int cargoCapacity;
    private String consumables;
    private String vehicleClass;
    private String created;
    private String edited;
    private String url;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<PeopleDB> pilots;
    //private List<Film> films;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(double costInCredits) {
        this.costInCredits = costInCredits;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public void setMaxAtmospheringSpeed(double maxAtmospheringSpeed) {
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

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
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

 public List<PeopleDB> getPilots() {
        return pilots;
    }

    public void setPilots(List<PeopleDB> pilots) {
        this.pilots = pilots;
    }

    /*public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }*/

    public DBEntity asDBEntity() {
        return null;
    }
}
