package com.backend.codingchallenge.city;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.codingchallenge.Suggestion;

@RestController
public class CityController {
	@Autowired
	private CityService cityService;
	
	@GetMapping("/suggestions")
	public ResponseEntity<List<Suggestion>>getSuggestions( //Maneja las solicitudes GET en la ruta /suggestions
			@RequestParam String q,//Parametro de consulta para la ciudad
			@RequestParam(required = false) Double latitude, //Parametro de latitud opcional
			@RequestParam(required =false) Double longitude //Parametro de longitud opcional
			){
		//Llamada al método getSuggestions del CityService para obtener las sugerencias basadas en los parámetros de la solicitud.
		List<Suggestion> suggestions = cityService.getSuggestions(q, latitude, longitude);
		// Ordena las sugerencias por puntaje de manera descendente
		Collections.sort(suggestions, Comparator.comparing(Suggestion::getScore).reversed());
		//suggestions.sort(Comparator.comparingDouble(s -> Double.valueOf(s.getScore())).reversed());
		//Devuelve un ResponseEntity con el código de estado HTTP 200 (OK) y la lista de sugerencias como cuerpo de la respuesta.
		return ResponseEntity.ok(suggestions);
	}
}
