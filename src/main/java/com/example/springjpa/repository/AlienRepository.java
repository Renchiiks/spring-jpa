package com.example.springjpa.repository;

import com.example.springjpa.entities.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienRepository extends JpaRepository<Alien, Long> {
//    List<Alien> findByTech(String tech);
//
//    List<Alien> findByIdGreaterThan(Long id);
//
//    @Query("from Alien where tech=?1 order by name")
//    List<Alien> findByTechSorted(String tech);

}
