package org.aaak.proj.entity.api;

import org.aaak.proj.entity.db.Film;
import org.aaak.proj.entity.db.PeopleDB;
import org.aaak.proj.entity.db.StarshipsDB;
import org.aaak.proj.entity.db.VehicleDB;

import java.util.ArrayList;
import java.util.List;

public class TransferAPIToDB {

    private List<PeopleDB> peopleList;
    private List<Film> filmsList;
    private List<VehicleDB> vehicleList;
    private List<StarshipsDB> starshipsList;

    public List<PeopleDB> getPeopleList() {
        System.out.println("Characters");
        for (PeopleDB people : peopleList
        ) {
            System.out.print(people.getName());
        }
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        List<PeopleDB> peopleDBList = new ArrayList<>();
        if (!peopleList.isEmpty()) {
            for (People people : peopleList) {
                peopleDBList.add(people.asDBEntity(false));
            }
        }
        this.peopleList = peopleDBList;
    }

    public List<Film> getFilmsList() {
        return filmsList;
    }

    public void setFilmsList(List<Films> filmsList) {
        List<Film> filmDBList = new ArrayList<>();
        for (Films films : filmsList) {
            filmDBList.add(films.asDBEntity(false));
        }
        this.filmsList = filmDBList;
    }

    public List<VehicleDB> getVehicleList() {
        System.out.println("VehicleDB Name");
        return this.vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        List<VehicleDB> vehicleDBList = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            vehicleDBList.add(vehicle.asDBEntity(false));
        }
        this.vehicleList = vehicleDBList;
    }

    public List<StarshipsDB> getStarshipsList() {
        return starshipsList;
    }

    public void setStarshipsList(List<Starship> starshipList) {
        List<StarshipsDB> starshipsDBList = new ArrayList<>();
        for (Starship starship : starshipList) {
            starshipsDBList.add(starship.asDBEntity(false));
        }
        this.starshipsList = starshipsDBList;
    }

}
