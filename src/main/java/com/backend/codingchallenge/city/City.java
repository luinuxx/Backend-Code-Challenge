package com.backend.codingchallenge.city;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//Entidad que representa una Ciudad
@Entity
public class City {
	@Id
	private Long id;
	@Column(name = "name", length = 200)
	private String name;
	@Column(name = "ascii", length = 200)
	private String ascii;
	@Column(name = "altName", length = 5000)
	private String altName;
	@Column(name = "latitude")
	private Double latitude;
	@Column(name = "llongitude")
	private Double longitude;
	@Column(name = "featClass", length = 1)
	private String featClass;
	@Column(name = "featCode", length = 10)
	private String featCode;
	@Column(name = "country", length = 2)
	private String country;
	@Column(name = "cc2", length = 60)
	private String cc2;
	@Column(name = "admin1", length = 20)
	private String admin1;
	@Column(name = "admin2", length = 80)
	private String admin2;
	@Column(name = "admin3", length = 20)
	private String admin3;
	@Column(name = "admin4", length = 20)
	private String admin4;
	@Column(name = "population")
	private BigInteger population;
	@Column(name = "elevation")
	private int elevation;
	@Column(name = "dem")
	private int dem;
	@Column(name = "tz", length = 40)
	private String tz;
	@Column(name = "modifiedAt", length = 12)
	private String modifiedAt;
	
	// getters y setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAscii() {
		return ascii;
	}
	
	public void setAscii(String ascii) {
		this.ascii = ascii;
	}
	
	public String getAltName() {
		return altName;
	}
	
	public void setAltName(String altName) {
		this.altName = altName;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLatitud(Double latitude) {
		this.latitude = latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitud(Double longitude) {
		this.longitude = longitude;
	}
	
	public String getFeatClass() {
		return featClass;
	}
	
	public void setFeatClass(String featClass) {
		this.featClass = featClass;
	}
	
	public String getFeatCode() {
		return featCode;
	}
	
	public void setFeatCode(String featCode) {
		this.featCode = featCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCc2() {
		return cc2;
	}
	
	public void setCc2(String cc2) {
		this.cc2 = cc2;
	}
	
	public String getAdmin1() {
		return admin1;
	}
	
	public void setAdmin1(String admin1) {
		this.admin1 = admin1;
	}
	
	public String getAdmin2() {
		return admin2;
	}
	
	public void setAdmin2(String admin2) {
		this.admin2 = admin2;
	}
	
	public String getAdmin3() {
		return admin3;
	}
	
	public void setAdmin3(String admin3) {
		this.admin3 = admin3;
	}
	
	public String getAdmin4() {
		return admin4;
	}
	
	public void setAdmin4(String admin4) {
		this.admin4 = admin4;
	}
	
	public BigInteger getPopulation() {
		return population;
	}
	
	public void setPopulation(BigInteger population) {
		this.population = population;
	}
	
	public int getElevation() {
		return elevation;
	}
	
	public void setElevation(int elevation) {
		this.elevation = elevation;
	}
	
	public int getDem() {
		return dem;
	}
	
	public void setDem(int dem) {
		this.dem = dem;
	}
	
	public String getTz() {
		return tz;
	}
	
	public void setTz(String tz) {
		this.tz = tz;
	}
	
	public String getModifiedAt() {
		return modifiedAt;
	}
	
	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
}
