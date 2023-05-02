package com.restapis.examples.springbootrestapisexamples.service;

import com.restapis.examples.springbootrestapisexamples.model.Toy;
import com.restapis.examples.springbootrestapisexamples.repository.ToyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ToyService {

    @Autowired
    private ToyRepository toyRepository;

    public List<Toy> getAllToys() {
        List<Toy> toys = new ArrayList<>();
        toyRepository.findAll().forEach(toys::add);
        return toys;
    }

    public void addToys(Toy toy) {
        if (toyRepository.existsById(toy.getProductId())) {
            log.info("Product ID: {} is already present. Incrementing the stock.", toy.getProductId());
            toyRepository.incrementRemainingStock(toy.getProductId());
        } else {
            log.info("Product ID: {} is not present. Adding to the stock.", toy.getProductId());
            toyRepository.save(toy);
        }
    }

    public Optional<Toy> getToyByProductId(String productId) {
        log.info("Retrieving the toy with product id: {}", productId);
        return Optional.of(toyRepository.findById(productId).stream().findFirst().orElseThrow());
    }

    public void deleteToy(String productId) {
        if (toyRepository.existsById(productId)) {
            log.info("Product ID: {} is already present. Reducing the stock.", productId);
            toyRepository.findById(productId)
                    .ifPresent(toy -> {
                        if (toy.getRemainingStock() > 1) {
                            toyRepository.reduceRemainingStock(toy.getProductId());
                        } else if (toy.getRemainingStock() == 1) {
                            toyRepository.deleteById(productId);
                        }
                    });
        } else {
            log.error("Product ID: {} is not present. No items deleted.", productId);
        }
    }
}
