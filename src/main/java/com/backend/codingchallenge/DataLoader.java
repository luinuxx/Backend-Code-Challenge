package com.backend.codingchallenge;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.BufferedReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.backend.codingchallenge.city.City;
import com.backend.codingchallenge.city.CityRepository;

@Service
public class DataLoader implements CommandLineRunner {
	@Autowired
	private CityRepository cityRepository;
	
	@Override
	public void run(String... args) throws Exception{
		//Obtener los datos del archivo cities_canada-usa.tsv
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("cities_canada-usa.tsv");
		
		//Leer el archivo aplicando lambdas
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
			reader.lines()
					.skip(1) //Saltar la primera línea que pertenece al encabezado
					.map(line -> line.split("\t")) //Dividir por tabulaciones
					.map(this::createCityFromLine) //Crear objetos City por línea
					.forEach(cityRepository::save); //Guardar en la BD
		}
	}
	
	private City createCityFromLine(String[] columns) {
		Long id = Long.parseLong(columns[0]);
		String name = columns[1];
		String ascii = columns[2];
		String altName = columns[3];
		Double latitude = Double.parseDouble(columns[4]);
		Double longitude = Double.parseDouble(columns[5]);
		String featClass = columns[6];
		String featCode = columns[7];
		String country = columns[8];
		String cc2 = columns[9];
		String admin1 = columns[10];
		String admin2 = columns[11];
		String admin3 = columns[12];
		String admin4 = columns[13];
		BigInteger population = new BigInteger(columns[14]);
		Integer elevation = null;
		try {
			elevation = Integer.parseInt(columns[15]);
		} catch (NumberFormatException e) {
			elevation = null;
		}
		Integer dem = null;
		try {
			dem = Integer.parseInt(columns[16]);
		} catch (NumberFormatException e) {
			dem = null;
		}
		String tz = columns[17];
		String modifiedAt = columns[18];
		
		City city = new City();
		city.setId(id);
		city.setName(name);
		city.setAscii(ascii);
		city.setAltName(altName);
		city.setLatitud(latitude);
		city.setLongitud(longitude);
		city.setFeatClass(featClass);
		city.setFeatCode(featCode);
		city.setCountry(country);
		city.setCc2(cc2);
		city.setAdmin1(admin1);
		city.setAdmin2(admin2);
		city.setAdmin3(admin3);
		city.setAdmin4(admin4);
		city.setPopulation(population);
		if(elevation != null) {
			city.setElevation(elevation);
		}
		city.setDem(dem);
		city.setTz(tz);
		city.setModifiedAt(modifiedAt);
		
		return city;
	}
}
