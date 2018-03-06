package com.accenture.dao;

import com.accenture.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HeroDAO extends JpaRepository<Hero, Integer> {

    @Query("select h from Hero h where h.name like %:queryText%")
    List<Hero> search(String queryText);
}
