# Mi Proyecto de Cities

Este proyecto proporciona un servicio para encontrar información sobre ciudades, incluyendo sugerencias y detalles geográficos.

## Consumir el Servicio

Puedes consumir el servicio utilizando cURL. A continuación, se presenta un ejemplo básico:

curl -Method GET https://backend-code-challenge-7z5lcolypq-uw.a.run.app/suggestions?q=Los%20Angeles

### Obtener Sugerencias de Ciudades
https://backend-code-challenge-7z5lcolypq-uw.a.run.app/suggestions?q=Londo&latitude=43.70011&longitude=-79.4163

Te devolvera una salida en formato JSON 
```json
[
    {
        "name": "West New York, NJ, US",
        "latitude": 40.78788,
        "longitude": -74.01431,
        "score": "0.6"
    },
    {
        "name": "East New York, NY, US",
        "latitude": 40.66677,
        "longitude": -73.88236,
        "score": "0.6"
    },
    {
        "name": "New York City, NY, US",
        "latitude": 40.71427,
        "longitude": -74.00597,
        "score": "0.6"
    }
]
```
