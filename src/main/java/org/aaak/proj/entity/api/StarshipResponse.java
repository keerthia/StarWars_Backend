package org.aaak.proj.entity.api;

import java.util.List;

public class StarshipResponse extends APIResponse<Starship> {
    List<Starship> results;

    @Override
    public List<Starship> getResults() {
        return this.results;
    }

    @Override
    public void setResults(List<Starship> results) {
        this.results = results;

    }
}
