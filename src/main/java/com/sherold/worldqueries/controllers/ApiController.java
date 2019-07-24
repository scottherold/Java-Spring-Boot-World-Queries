package com.sherold.worldqueries.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sherold.worldqueries.models.Country;
import com.sherold.worldqueries.services.ApiService;

@RestController
@RequestMapping("/")
public class ApiController {
	// <----- Attributes ----->
	// dependency injection
	private ApiService apiService;

	// <----- Constructors ----->
	public ApiController(ApiService apiService) {
		this.apiService = apiService;
	}
	
	// <----- Methods ----->
	// Route to return countries by language
	@RequestMapping(value="countries/all", method=RequestMethod.GET, produces="application/json")
	public List<Object[]> countriesByLanguage(@RequestParam("language") String language) {
		return apiService.findCountriesByLanguage(language);
	}
	
	// Route to return cities in a given country with a population over a given amount
	@RequestMapping(value="countries/cities", method=RequestMethod.GET, produces="application/json")
	public List<Object[]> allCitiesInCountryOverPop(@RequestParam("country") String country, @RequestParam("population") int population) {
		return apiService.allCitiesInCountryOverPop(country, population);
	}
	
	// Route to return countries under a given surface area and over a certain population
	@RequestMapping(value="countries", method=RequestMethod.GET, produces="application/json")
	public List<Object[]> allCountriesOverSurfaceAreaAndPop(@RequestParam("surfaceArea") Double surArea, @RequestParam("population") int population) {
		return apiService.allCountriesOverSurfaceAreaAndPop(surArea, population);
	}
	
	// Route to return languages in a given country that are greater than a given percentage
	@RequestMapping(value="countries/languages", method=RequestMethod.GET, produces="application/json")
	public List<Object[]> allLanguagesOverPercent(@RequestParam("percent") double percent) {
		return apiService.allLanguagesOverPercent(percent);
	}
	
	// Route to return city count by country
	@RequestMapping(value="countries/cities/count", method=RequestMethod.GET, produces="application/json")
	public List<Object[]> cityCountByCountry() {
		return apiService.findCityCountPerCountry();
	}
	
	// Route to return countries by government, surface area and life expectancy
	@RequestMapping(value="countries/government", method=RequestMethod.GET, produces="application/json")
	List<Object[]> allCountriesByGovTypeSurAreaOverLifeExpOver(@RequestParam("type") String government, @RequestParam("surfaceArea")Double surArea, @RequestParam("lifeExpectancy") Double lifeExp) {
		return apiService.allCountriesByGovTypeSurAreaOverLifeExpOver(government, surArea, lifeExp);
	}
	
	// Route to return cities by country, district and over population
	@RequestMapping(value="countries/cities/districts", method=RequestMethod.GET, produces="application/json")
	List<Object[]> allCitiesByCountryDistrictOverPop(@RequestParam("country") String country, @RequestParam("district") String district, @RequestParam("population") int population) {
		return apiService.allCitiesByCountryDistrictOverPop(country, district, population);
	}
	
	// Route to return all countries in a given region
	@RequestMapping(value="countries/regions", method=RequestMethod.GET, produces="application/json")
	List<Object[]> allCountriesInAllRegions() {
		return apiService.allCountriesInAllRegions();
	}
}
