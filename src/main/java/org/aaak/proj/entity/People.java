package org.aaak.proj.entity;

import java.util.List;
//import org.springframework.context.annotation.Bean;

public class People {
    private String name;
    private int height;
    private int mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeWorld;
    private List<String> films;
    private List<String> vehicles;
    private List<String> species;
    private List<String> starShips;
    private String created;
    private String edited;
    private String url;

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreated() {
        return created;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
