package com.sherold.worldqueries.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sherold.worldqueries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
	// Sets findAll() to return Country objects
	List<Country> findAll();
	
	// Selects all countries that speak a certain language
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language =?1 ORDER BY l.percentage DESC")
	List<Object[]> findCountriesByLanguage(String language);
	
	// Selects all the languages in all countries over the input
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage >?1 ORDER BY l.percentage DESC")
	List<Object[]> allLanguagesOverPercent(double percent);
	
	// Selects the total number of cities in each country
	@Query("SELECT c.name, COUNT(cy) FROM Country c JOIN c.cities cy GROUP BY c.name ORDER BY COUNT(cy) DESC")
	List<Object[]> findCityCountPerCountry();
	
	// Selects the cities in a given country with a population over the input
	@Query("SELECT c.name, cy.name, cy.population FROM Country c JOIN c.cities cy WHERE cy.country.name =?1 AND cy.population >?2 ORDER BY cy.population DESC")
	List<Object[]> allCitiesInCountryOverPop(String country, int population);
	
	// Selects the countries with a surface area < the given amount and a popuation greater than the given amount
	@Query("SELECT c.name, c.surface_area, c.population FROM Country c WHERE c.surface_area <?1 AND c.population >?2")
	List<Object[]> allCountriesOverSurfaceAreaAndPop(Double surArea, int population);
	
	// Selects the countries with a given government type, a given surface area under a given amount and a life expectancy greater than a given amount
	@Query("SELECT c.name, c.government_form, c.surface_area, c.life_expectancy FROM Country c WHERE c.government_form =?1 AND c.surface_area >?2 AND c.life_expectancy >?3")
	List<Object[]> allCountriesByGovTypeSurAreaOverLifeExpOver(String government, Double surArea, Double lifeExp);
	
	// Selects the cities in a given country, within a given district and over a given population
	@Query("SELECT c.name, cy.name, cy.district, cy.population FROM Country c JOIN c.cities cy WHERE cy.country.name =?1 AND cy.district = ?2 AND cy.population >?3")
	List<Object[]> allCitiesByCountryDistrictOverPop(String country, String district, int population);
	
	// // Selects the total number of countries in each region
	@Query("SELECT c.region, COUNT(c) FROM Country c GROUP BY c.region ORDER BY COUNT(c) DESC")
	List<Object[]> allCountriesInAllRegions();
}
