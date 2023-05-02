package com.restapis.examples.springbootrestapisexamples.repository;

import com.restapis.examples.springbootrestapisexamples.model.Toy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ToyRepository extends CrudRepository<Toy, String> {

    @Modifying
    @Transactional
    @Query("UPDATE Toys SET remainingStock=remainingStock+1 WHERE productId=:productId")
    void incrementRemainingStock(@Param("productId") String productId);

    @Modifying
    @Transactional
    @Query("UPDATE Toys SET remainingStock=remainingStock-1 WHERE productId=:productId")
    void reduceRemainingStock(@Param("productId") String productId);

}
