package com.example.searchapp.controller;

import com.example.searchapp.model.SearchResult;
import com.example.searchapp.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public Map<String, Long> getSearchResults(@RequestParam("query") String query) {
        String[] keywords = query.split("\\s+");
        Map<String, Long> searchResult = new HashMap<>();
        long totalHitsGoogle = 0;
        long totalHitsBing = 0;
        long totalHitsYahoo = 0;

        for (String keyword : keywords) {
            List<SearchResult> results = searchService.getSearchResults(keyword);
            for (SearchResult result : results) {
                switch (result.getProvider()) {
                    case "Google":
                        totalHitsGoogle += result.getHits();
                        break;
                    case "Bing":
                        totalHitsBing += result.getHits();
                        break;
                    case "Yahoo":
                        totalHitsYahoo += result.getHits();
                        break;
                }
            }
        }

        searchResult.put("googleHits", totalHitsGoogle);
        searchResult.put("bingHits", totalHitsBing);
        searchResult.put("yahooHits", totalHitsYahoo);

        return searchResult;
    }
}
