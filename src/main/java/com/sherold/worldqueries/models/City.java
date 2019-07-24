package com.sherold.worldqueries.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // designates DB entity
@Table(name="cities")
public class City {
	// <----- Attributes ----->
	@Id // designates id field
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
	private Long id;
	private String name;
	private String country_code;
	private String district;
	private Integer population;
	
	// <----- Relationships ----->
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="country_id")
	private Country country;

	// <----- Constructors ----->
	public City() {
	}

	public City(String name, String country_code, String district, Integer population, Country country) {
		this.name = name;
		this.country_code = country_code;
		this.district = district;
		this.population = population;
		this.country = country;
	}
	
	// <----- Getters/Setters ----->
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Long getId() {
		return id;
	}
	
	
}
