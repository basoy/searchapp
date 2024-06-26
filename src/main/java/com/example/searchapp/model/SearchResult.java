package com.example.searchapp.model;

public class SearchResult {
    private String provider;
    private long hits;

    public SearchResult(String provider, long hits) {
        this.provider = provider;
        this.hits = hits;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public long getHits() {
        return hits;
    }

    public void setHits(long hits) {
        this.hits = hits;
    }
}
