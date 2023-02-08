package org.aaak.proj.controller;

import org.aaak.proj.entity.db.PeopleDB;
import org.aaak.proj.repository.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class PeopleController {
    @Autowired
    PeopleRepo peopleRepo;

    //Get Hair Color from PeopleDB
    @RequestMapping(value = "/peopleDBs/search/findAllHairColor/", method = RequestMethod.GET)
    @ResponseBody
    public Set<String> findAllHairColor() {
        List<PeopleDB> peopleDBList = peopleRepo.findAll();
        Set<String> hairColorList = new HashSet<>();
        for (PeopleDB people : peopleDBList
        ) {
            hairColorList.add(people.getHairColor());
        }
        return hairColorList;

    }

    //Get Eye Color from PeopleDB
    @RequestMapping(value = "/peopleDBs/search/findAllEyeColor/", method = RequestMethod.GET)
    @ResponseBody
    public Set<String> findAllEyeColor() {
        List<PeopleDB> peopleDBList = peopleRepo.findAll();
        Set<String> eyeColorList = new HashSet<>();
        for (PeopleDB people : peopleDBList
        ) {
            eyeColorList.add(people.getEyeColor());
        }
        return eyeColorList;

    }

}
