package org.aaak.proj.entity.db;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "planet")
public class PlanetDB implements DBEntity {
    @Id
    @Column(name = "id", nullable = false)
    private long planet_id;
    private String climate;
    private double diameter;
    private String gravity;
    private String name;
    private double orbitalPeriod;
    private Double population;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<PeopleDB> residents;

    //private List<Film> films;

    private Double rotationPeriod;

    /*public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
*/
    private Double surfaceWater;
    private String terrain;
    private String url;

    public long getPlanet_id() {
        return planet_id;
    }

    public void setPlanet_id(long planet_id) {
        this.planet_id = planet_id;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }


    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public void setDiameter(Double diameter) {
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

    public Double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public void setOrbitalPeriod(Double orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

    public List<PeopleDB> getResidents() {
        return residents;
    }

    public void setResidents(List<PeopleDB> residents) {
        this.residents = residents;
    }

    public Double getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(Double rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public Double getSurfaceWater() {
        return surfaceWater;
    }

    public void setSurfaceWater(Double surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
}
