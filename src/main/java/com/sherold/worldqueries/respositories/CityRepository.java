package com.sherold.worldqueries.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sherold.worldqueries.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
	// Sets findAll() to return City objects
	List<City> findAll();
}
