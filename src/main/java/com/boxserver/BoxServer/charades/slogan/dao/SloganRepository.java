package com.boxserver.BoxServer.charades.slogan.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SloganRepository extends CrudRepository<Slogan, Long> {

    @Query("select id from Slogan")
    List<Long> getAllIds();
}
