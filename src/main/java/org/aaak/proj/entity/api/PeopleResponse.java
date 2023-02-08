package org.aaak.proj.entity.api;

import java.util.List;

public class PeopleResponse extends APIResponse<People> {
    List<People> results;

    @Override
    public List<People> getResults() {
        return results;
    }

    @Override
    public void setResults(List<People> results) {
        this.results = results;
    }
}
