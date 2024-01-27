package com.backend.codingchallenge.city;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	/* Interfaz CityRepository que extiende JpaRepository, 
	 * ya se heredan métodos de consulta básicos proporcionados por Spring Data JPA, 
	 * como save, findById, findAll y delete*/
	
	@Query("SELECT c FROM City c WHERE LOWER(c.name) LIKE LOWER(concat('%',:q,'%')) ORDER BY " +
            "(6371 * acos(cos(radians(:latitude)) * cos(radians(c.latitude)) * " +
            "cos(radians(c.longitude) - radians(:longitude)) + sin(radians(:latitude)) * " +
            "sin(radians(c.latitude))))")
    List<City> findByOrderByProximity(@Param("q") String query, @Param("latitude") Double latitude, @Param("longitude") Double longitude);
	
	@Query("SELECT c FROM City c WHERE LOWER(c.name) LIKE LOWER(concat('%',:q,'%'))")
    List<City> findByNameContainingIgnoreCase(@Param("q") String query);
}
