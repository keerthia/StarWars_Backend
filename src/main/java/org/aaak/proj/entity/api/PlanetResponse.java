package org.aaak.proj.entity.api;

import java.util.List;

public class PlanetResponse extends APIResponse<Planet> {
    List<Planet> results;

    @Override
    public List<Planet> getResults() {
        return this.results;
    }

    @Override
    public void setResults(List<Planet> results) {
        this.results = results;

    }
}
