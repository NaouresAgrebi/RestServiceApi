package com.margoConseil.rst.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "city")
public class City implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public City() {
		super();
	}

	public City(Country country, String cityName, Boolean visited, List<Attraction> attractions) {
		super();
		this.country = country;
		this.cityName = cityName;
		this.visited = visited;
		this.attractions = attractions;
	}

	private Integer cityId;
	private Country country;
	private String cityName;
	private Boolean visited;
	public List<Attraction> attractions;

	@Id
	@GenericGenerator(name = "kaugen", strategy = "increment")
	@GeneratedValue(generator = "kaugen")
	@Column(name = "cityId")
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@ManyToOne
	@JoinColumn(name = "countryId")
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(name = "cityName")
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Column(name = "visited")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	public Boolean getVisited() {
		return visited;
	}

	public void setVisited(Boolean visited) {
		this.visited = visited;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "attraction_city", joinColumns = @JoinColumn(name = "cityId", referencedColumnName = "cityId") , inverseJoinColumns = @JoinColumn(name = "attractionId", referencedColumnName = "attractionId") )
	public List<Attraction> getAttractions() {
		return attractions;
	}

	public void setAttractions(List<Attraction> attractions) {
		this.attractions = attractions;
	}

}
