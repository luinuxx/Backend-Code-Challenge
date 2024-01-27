package com.backend.codingchallenge;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Suggestion {
	private String name;
    private Double latitude;
    private Double longitude;
    private String score;
    
    public Suggestion(String name, Double latitude, Double longitude, String score) {
    	this.name = name;
    	this.latitude = latitude;
    	this.longitude = longitude;
    	this.score = score;
    }
    
    public String getScore() {
    	return this.score;
    }
}
