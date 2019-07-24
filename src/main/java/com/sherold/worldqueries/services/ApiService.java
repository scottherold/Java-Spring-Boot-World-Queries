package com.sherold.worldqueries.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.sherold.worldqueries.models.City;
import com.sherold.worldqueries.models.Country;
import com.sherold.worldqueries.models.Language;
import com.sherold.worldqueries.respositories.CityRepository;
import com.sherold.worldqueries.respositories.CountryRepository;
import com.sherold.worldqueries.respositories.LanguageRepository;

@Service
public class ApiService {
	// <----- Attributes ----->
	// dependency injection
	private CityRepository cityRepo;
	private CountryRepository countryRepo;
	private LanguageRepository languageRepo;
	
	// <----- Constructors ----->
	public ApiService(CityRepository cityRepo, CountryRepository countryRepo, LanguageRepository languageRepo) {
		this.cityRepo = cityRepo;
		this.countryRepo = countryRepo;
		this.languageRepo = languageRepo;
	}
	
	// <----- Methods ------>
	// queries from cities table
	
	// SELECT * FROM cities
	public List<City> allCities() {
		return cityRepo.findAll();
	}
	
	// queries from countries table
	
	// SELECT * FROM countries
	public List<Country> allCountries() {
		return countryRepo.findAll();
	}
	
	// SELECT country region, country count FROM countries
	public List<Object[]> allCountriesInAllRegions() {
		return countryRepo.allCountriesInAllRegions();
	}
	
	// SELECT country name, language, language percent FROM countries JOIN languages ON countries.id = languages.country_id WHERE language = ?
	public List<Object[]> findCountriesByLanguage(String language) {
		return countryRepo.findCountriesByLanguage(language);
	}
	
	// SELECT country name, language, language percent FROM countries JOIN language on countries.id = languages.country_id WHERE c and language.percentage > ?
	public List<Object[]> allLanguagesOverPercent(double percent) {
		return countryRepo.allLanguagesOverPercent(percent);
	}
	
	// SELECT country name, city count FROM countries JOIN cities ON countries.id = cities.countries_id
	public List<Object[]> findCityCountPerCountry() {
		return countryRepo.findCityCountPerCountry();
	}
	
	// SELECT country name, city name FORM countries JOIN cities ON countries.id = cities.country_id WHERE city.population > ? AND country = ?
	public List<Object[]> allCitiesInCountryOverPop(String country, int population) {
		return countryRepo.allCitiesInCountryOverPop(country, population);
	}	
	
	// SELECT country name, country surface_area, country population FROM countries WHERE countries.surface_area < ? AND country.population > ?
	public List<Object[]> allCountriesOverSurfaceAreaAndPop(Double surArea, int population) {
		return countryRepo.allCountriesOverSurfaceAreaAndPop(surArea, population);
	}
	
	// SELECT country name, country government, country surface area, country life expectancy FROM countries WHERE country.government = ? AND country.surface_area > ? AND country.life_expectancy > ?
	public List<Object[]> allCountriesByGovTypeSurAreaOverLifeExpOver(String government, Double surArea, Double lifeExp) {
		return countryRepo.allCountriesByGovTypeSurAreaOverLifeExpOver(government, surArea, lifeExp);
	}
	
	// SELECT country name, city name, city district, city population FROM countries JOIN ON country.id = city.country_id WHERE country.name = ? AND city.district = ? and city.population > ?
	// Selects the cities in a given country, within a given district and over a given population
	public List<Object[]> allCitiesByCountryDistrictOverPop(String country, String district, int population) {
		return countryRepo.allCitiesByCountryDistrictOverPop(country, district, population);
	}
	
	// queries from languages table
	
	// SELECT * FROM languages
	public List<Language> allLanguages() {
		return languageRepo.findAll();
	}
}
