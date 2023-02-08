package org.aaak.proj.entity.api;

import java.util.List;

public class FilmsResponse extends APIResponse<Films> {
    List<Films> results;

    @Override
    public List<Films> getResults() {
        return results;
    }

    @Override
    public void setResults(List<Films> results) {
        this.results = results;
    }
}
