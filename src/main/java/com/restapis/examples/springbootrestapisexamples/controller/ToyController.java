package com.restapis.examples.springbootrestapisexamples.controller;

import com.restapis.examples.springbootrestapisexamples.model.Toy;
import com.restapis.examples.springbootrestapisexamples.service.ToyService;
import com.restapis.examples.springbootrestapisexamples.utils.ResponseHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/toys")
public class ToyController {

    @Autowired
    ToyService toyService;

    @GetMapping
    public ResponseEntity<Object> getToys() {
        return ResponseHandler.generateResponse("Successfully retrieved data.",
                HttpStatus.OK,
                toyService.getAllToys());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Object> getToyByProductId(@PathVariable String productId) {
        return ResponseHandler.generateResponse("Successfully retrieved data.",
                HttpStatus.OK,
                toyService.getToyByProductId(productId));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Object> deleteToy(@PathVariable String productId) {
        toyService.deleteToy(productId);
        return ResponseHandler.generateResponse("Successfully deleted data.",
                HttpStatus.OK,
                productId);
    }

    @PostMapping
    public ResponseEntity<Object> addToy(@RequestBody Toy newToy) {
        toyService.addToys(newToy);
        return ResponseHandler.generateResponse("Successfully added data.",
                HttpStatus.OK,
                newToy.getProductId());
    }

}
