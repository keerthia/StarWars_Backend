package org.aaak.proj.entity.api;

import org.aaak.proj.entity.db.Film;
import org.aaak.proj.entity.db.PeopleDB;
import org.aaak.proj.entity.db.SpeciesDB;

import java.util.List;

public class AsDBEntity {


    private List<SpeciesDB> speciesDBList;

    private List<PeopleDB> peopleList;
    private List<Film> filmsList;
   /* public void setSpeciesList(List<Species> speciesList) {
        List<SpeciesDB> speciesDBList = new ArrayList<>();
        for (Species species : speciesList) {
            speciesDBList.add(species.asDBEntity(false));
        }
        this.speciesDBList = speciesDBList;
    }

    public List<PeopleDB> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        List<PeopleDB> peopleDBList = new ArrayList<>();
        for (People people : peopleList) {
            peopleDBList.add(people.asDBEntity(false));
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

    private List<VehicleDB> vehicleList;
    private List<StarshipsDB> starshipsList;
}

Films.java
if (mapRelationships) {
            if(this.getCharacters()!=null) {
                this.setPeopleList(apiCache.getEntities(this.getUrl(), this.getCharacters()));
                film.setCharacters(this.getPeopleList());
            }
            //Mapping VehicleDB APIEntity List to Vehicle
            if((this.getVehicles()!=null)) {
                this.setVehicleList(apiCache.getEntities(this.getUrl(), this.getVehicles()));
                film.setVehicles(this.getVehicleList());
            }

            //Mapping Starship APIEntity to StarshipDB
            if((this.getStarships()!=null)) {
                this.setStarshipsList(apiCache.getEntities(this.getUrl(), this.getStarships()));
                film.setStarships(this.getStarshipsList());
            }

        }

People.java
//Mapping FilmAPIEntity List to FilmDB
        if (mapRelationships) {
            //Map Films from APIEntity to FilmDB
            if(this.getFilms()!=null) {
                this.setFilmsList(apiCache.getEntities(this.getUrl(), this.getFilms()));
                peopleDB.setFilms(this.getFilmsList());
            }
            //Map Vehicles from APIEntity to vehicleDB
            if(this.getVehicles()!=null) {
                this.setVehicleList(apiCache.getEntities(this.getUrl(), this.getVehicles()));
                peopleDB.setVehicles(this.getVehicleList());
            }
            //Map Starships from APIEntity to StarshipDB
            if(this.getStarShips()!=null) {
                this.setStarshipsList(apiCache.getEntities(this.getUrl(), this.getStarShips()));
                peopleDB.setStarShips(this.getStarshipsList());
            }
            if(this.getSpecies()!=null) {
                this.setSpeciesList(apiCache.getEntities(this.getUrl(), this.getSpecies()));
                peopleDB.setStarShips(this.getStarshipsList());
            }
        }

species.java
 if (mapRelationships) {
            if (this.getFilms() != null) {
                this.setFilmsList(apiCache.getEntities(this.getUrl(), this.getFilms()));
                speciesDB.setFilms(this.getFilmsList());
            }
            if(this.getPeople()!=null){
                this.setPeopleList(apiCache.getEntities(this.getUrl(), this.getPeople()));
                speciesDB.setPeople(this.getPeopleList());
            }
        }


        STARSHIP.java
          if (mapRelationships) {
            //Map Pilots from API Entity to DB
            if(!(this.getPilots().isEmpty())) {
                this.setPeopleList(apiCache.getEntities(this.getUrl(), this.getPilots()));
                starshipsDB.setPilots(this.getPeopleList());
            }
            //Map Film from API Entity to DB
            if(this.getFilms()!=null) {
                this.setFilmsList(apiCache.getEntities(this.getUrl(), this.getFilms()));
                starshipsDB.setFilms(this.getFilmsList());
            }
        }

        Vehicle.java
        if (mapRelationships) {
            if(this.getFilms()!=null) {
                this.setFilmsList(apiCache.getEntities(this.getUrl(), this.getFilms()));
                vehicleDB.setFilms(this.getFilmsList());
            }
            if(this.getPilots()!=null) {
                this.setPeopleList(apiCache.getEntities(this.getUrl(), this.getPilots()));
                vehicleDB.setPilots(this.getPeopleList());
            }
        }
*/

}
