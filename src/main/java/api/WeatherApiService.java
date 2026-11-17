package api;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.net.URI;

import java.nio.file.Paths;

import java.time.Duration;

import model.CoordinateObject;
import util.ApiConfig;

public class WeatherApiService {

    private CoordinateObject coordinates;
    private String apiKey;
    private HttpClient client;

    public WeatherApiService(CoordinateObject coordinates) {
        this.coordinates = coordinates;
        this.apiKey = ApiConfig.WEATHER_KEY;
        this.client = HttpClient.newHttpClient();
    }

    public String fetchWeatherData() throws InterruptedException, IOException {

        String apiCall = "https://api.openweathermap.org/data/2.5/weather?lat="+this.coordinates.getLatitude()+"&lon="+this.coordinates.getLongitude()+"&appid="+this.apiKey;


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiCall))
                .timeout(Duration.ofSeconds(10))
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();

        HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());

        return response.body();
    }
}
