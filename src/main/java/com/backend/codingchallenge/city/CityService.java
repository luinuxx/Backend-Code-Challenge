package com.backend.codingchallenge.city;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.codingchallenge.Suggestion;

@Service
public class CityService {
	@Autowired
	private CityRepository cityRepository;
	
	public List<Suggestion> getSuggestions(String query, Double latitude, Double longitude){
		List<City> cities;
		
		if(latitude != null && longitude != null) {
			// Si se proporciona la ubicación, ordena las ciudades por proximidad.
			cities = cityRepository.findByOrderByProximity(query, latitude, longitude);
		} else {
			// Si no se proporciona la ubicación, realiza una búsqueda básica
			cities = cityRepository.findByNameContainingIgnoreCase(query);
		}
		
		//Se convierte la lista de ciudades a una lista de sugerencias
		return cities.stream()
				.map(city -> {
					double score = calculateScore(query, city.getName());
					return new Suggestion(city.getName()+", "+city.getAdmin1()+", "+city.getCountry(), city.getLatitude(), city.getLongitude(), String.format("%,.1f", score));
				})
				.collect(Collectors.toList());
	}
	
	private double calculateScore(String query, String cityName) {
		// Función para calcular el puntaje
        // Aquí se muestra un enfoque básico basado en la coincidencia de cadenas
		int coincidencia = cityName.contains(query) ? query.length():0;
		double score = (double) coincidencia / cityName.length();
		return ((int) (score*10))/10.0;
	}
}
