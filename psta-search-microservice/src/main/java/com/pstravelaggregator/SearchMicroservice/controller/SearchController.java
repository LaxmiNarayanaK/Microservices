package com.pstravelaggregator.SearchMicroservice.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.pstravelaggregator.SearchMicroservice.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/search")
@RestController
@CrossOrigin
public class SearchController {
    @Autowired
    SearchService searchService;

    @RequestMapping(value = "get/flights", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllFlights(@RequestBody JsonNode query){
        return new ResponseEntity<>(searchService.getAll("dev_flights", query).toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "get/accommodations", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllAccommodations(@RequestBody JsonNode query){
        return new ResponseEntity<>(searchService.getAll("dev_accommodation", query).toString(), HttpStatus.OK);
    }
}
