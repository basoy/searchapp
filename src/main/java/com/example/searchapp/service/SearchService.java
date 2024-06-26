package com.example.searchapp.service;

import com.example.searchapp.model.SearchResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    public List<SearchResult> getSearchResults(String query) {
        List<SearchResult> results = new ArrayList<>();

        results.add(new SearchResult("Google", getHitsFromProvider(query, "Google")));
        results.add(new SearchResult("Bing", getHitsFromProvider(query, "Bing")));
        results.add(new SearchResult("Yahoo", getHitsFromProvider(query, "Yahoo")));

        return results;
    }

    private long getHitsFromProvider(String query, String provider) {
        return (long) (Math.random() * 100000000);
    }
}