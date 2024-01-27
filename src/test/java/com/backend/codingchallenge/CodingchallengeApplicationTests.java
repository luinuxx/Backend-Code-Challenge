package com.backend.codingchallenge;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import com.backend.codingchallenge.city.City;
import com.backend.codingchallenge.city.CityRepository;

@SpringBootTest
class CodingchallengeApplicationTests {

	@Autowired
    private CityRepository cityRepository; 

    @Test
    void contextLoads() {
        // Verifica que el contexto de la aplicación se cargue correctamente
    	assertNotNull(cityRepository);
    }

    @Test
    void testFindCitiesWithCityUnexist() {
    	// Ejecutar la consulta para encontrar ciudades por nombre ignorando mayúsculas y minúsculas
        List<City> resultCities = cityRepository.findByNameContainingIgnoreCase("Jiutepec");

     // Verificar que la lista resultante no sea nula y que no contenga ciudades
        assertNotNull(resultCities);
        assertTrue(resultCities.isEmpty());
    }
    
    @Test
    void testFindCitiesByNameIgnoreCase() {
    	// Ejecutar la consulta para encontrar ciudades por nombre ignorando mayúsculas y minúsculas
        List<City> resultCities = cityRepository.findByNameContainingIgnoreCase("los Angeles");

        // Verificar que la lista resultante no sea nula y contenga la ciudad esperada
        assertNotNull(resultCities);
        assertFalse(resultCities.isEmpty());
        // Verifica que la lista contenga al menos un elemento que incluya "Los Angeles"
        assertTrue(resultCities.stream().anyMatch(city -> city.getName().contains("Los Angeles")));
    }
    
    @Test
    void testFindCitiesByLongLat() {
    	// Ejecutar la consulta para encontrar ciudades que incliyan coordenadas
        List<City> resultCities = cityRepository.findByOrderByProximity("Londo",43.70011,-79.4163);

        // Verificar que la lista resultante no sea nula
        assertNotNull(resultCities);
        assertFalse(resultCities.isEmpty());
        // Verifica que la lista contenga al menos un elemento que cumpla con el query solicitado
        assertTrue(resultCities.stream()
                .anyMatch(city -> 
                    city.getName().toLowerCase().contains("londo") &&
                    isCloseTo(city.getLatitude(), 43.70011) &&
                    isCloseTo(city.getLongitude(), -79.4163)
                ));
    }
    
    private boolean isCloseTo(double actual, double expected) {
        double tolerance = 5; // Tolerancia para ver que tar cerca estan las coordenadas dadas por el usuario
        return Math.abs(actual - expected) < tolerance;
    }

}
