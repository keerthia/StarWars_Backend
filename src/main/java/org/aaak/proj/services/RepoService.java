package org.aaak.proj.services;

import org.aaak.proj.entity.db.*;
import org.aaak.proj.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepoService {
    @Autowired
    PlanetRepo planetRepo;
    @Autowired
    PeopleRepo peopleRepo;
    @Autowired
    FilmRepo filmRepo;
    @Autowired
    SpeciesRepo speciesRepo;
    @Autowired
    StarshipRepo starshipRepo;
    @Autowired
    VehicleRepo vehicleRepo;


    public void addToFilmTable(DBEntity entrySet) {
        Film film = (Film) entrySet;
        filmRepo.save(film);
        System.out.println(film.getUrl());
    }

    public void addToPlanetTable(DBEntity entrySet) {
        PlanetDB planetDB = (PlanetDB) entrySet;
        planetRepo.save(planetDB);
        System.out.println(planetDB.getUrl());
    }

    public void addToPeopleTable(DBEntity entrySet) {
        PeopleDB peopleDB = (PeopleDB) entrySet;
        if (!(peopleRepo.existsById(peopleDB.getPeopleId())))
            peopleRepo.save(peopleDB);
        System.out.println(peopleDB.getUrl());
    }

    public void addToSpeciesTable(DBEntity entrySet) {
        SpeciesDB speciesDB = (SpeciesDB) entrySet;
        speciesRepo.save(speciesDB);
        System.out.println(speciesDB.getUrl());
    }

    public void addToStarShipTable(DBEntity entrySet) {
        StarshipsDB starshipsDB = (StarshipsDB) entrySet;
        starshipRepo.save(starshipsDB);
        System.out.println(starshipsDB.getUrl());
    }

    public void addToVehicleTable(DBEntity entrySet) {
        VehicleDB vehicleDB = (VehicleDB) entrySet;
        vehicleRepo.save(vehicleDB);
        System.out.println(vehicleDB.getUrl());
    }


    //@Autowired
    //ForeignTableMapping foreignTableMapping;

    /*public void addAAAK(aaak aaakObj) {
        aaak a= null;
        try {
            a= (aaak) planetRepo.save(aaakObj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(a.getId());
    }

    public void addAAAKForeignTable(aaakForeignTable aaakForeignTable) {
        aaakForeignTable aaakForeignTableObj = null;
        try {
            aaakForeignTableObj = (org.aaak.proj.entity.db.aaakForeignTable) planetRepo.save(aaakForeignTable);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(aaakForeignTableObj.getId());
    }*/
}


