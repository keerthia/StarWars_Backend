package org.aaak.proj.entity.api;

import org.aaak.proj.entity.db.DBEntity;

import java.util.List;

public abstract class APIEntity<T> {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public abstract DBEntity asDBEntity(boolean mapRelationships);

    public abstract List<String> getVehicleUrls();

    public abstract List<String> getPeopleUrls();

    public abstract void mapRelationships(DBEntity dbEntity);


    // public abstract void  setVehicleDBEntities();

}
