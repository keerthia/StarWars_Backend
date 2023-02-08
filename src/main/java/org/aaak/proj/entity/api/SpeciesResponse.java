package org.aaak.proj.entity.api;

import java.util.List;

public class SpeciesResponse extends APIResponse<Species> {
    List<Species> results;

    @Override
    public List<Species> getResults() {
        return results;
    }

    @Override
    public void setResults(List<Species> results) {
        this.results = results;

    }
}
