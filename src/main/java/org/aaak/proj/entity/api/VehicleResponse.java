package org.aaak.proj.entity.api;

import java.util.List;

public class VehicleResponse extends APIResponse<Vehicle> {
    private List<Vehicle> results;

    @Override
    public List<Vehicle> getResults() {
        return this.results;
    }

    @Override
    public void setResults(List<Vehicle> results) {
        this.results = results;
    }
}
