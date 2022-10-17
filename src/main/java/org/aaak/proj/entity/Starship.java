package org.aaak.proj.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.OneToMany;
import java.util.List;

public class Starship {

    @JsonProperty("url")
    //@JsonDeserialize(UrlToIdDeserializer.class)
    int id;

    @OneToMany
    @JsonProperty("films")
    @JsonDeserialize
    List<Films> films;
}
