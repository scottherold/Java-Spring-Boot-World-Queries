package com.sherold.worldqueries.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sherold.worldqueries.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
	// Sets findAll() to return Language objects
	List<Language> findAll();
}
