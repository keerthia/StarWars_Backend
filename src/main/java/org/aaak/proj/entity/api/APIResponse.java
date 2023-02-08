package org.aaak.proj.entity.api;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
public abstract class APIResponse<T> {
    int count;
    String next;
    String previous;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public abstract List<T> getResults();

    public abstract void setResults(List<T> results);
}
