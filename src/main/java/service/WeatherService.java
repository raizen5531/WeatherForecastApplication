package service;

import api.CoordinateService;
import api.WeatherApiService;

import model.CoordinateObject;
import model.WeatherObject;

import parser.GeocodingParser;
import parser.WeatherParser;

import java.io.IOException;

public class WeatherService {

    private CoordinateService coordinateService;
    private WeatherApiService weatherApiService;

    public WeatherService() {
        this.coordinateService = new CoordinateService();

    }

    public CoordinateObject getCoordinates(String placeName) throws InterruptedException, IOException {

        CoordinateObject coordinates = new CoordinateObject();
        GeocodingParser coordinateParser = new GeocodingParser();

        String coordinateData = this.coordinateService.fetchCoordinates(placeName);
        coordinateParser.parseCoordinateData(coordinateData, coordinates);

        return coordinates;
    }

    public WeatherObject getWeather(String placeName) throws InterruptedException, IOException {
        CoordinateObject coordinates = this.getCoordinates(placeName);
        WeatherObject weatherObject = new WeatherObject(placeName);
        WeatherApiService weatherService = new WeatherApiService(coordinates);
        WeatherParser weatherParser = new WeatherParser();

        String weatherData = weatherService.fetchWeatherData();

        weatherParser.parseWeatherData(placeName, weatherData, weatherObject);

        return weatherObject;
    }
}
