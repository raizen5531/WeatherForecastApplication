package model;

public class WeatherObject {
    private String placeName;
    private String currentWeather;
    private String currentWeatherDescription;
    private double temperature;
    private double feelsLikeTemperature;
    private int humidity;

    public WeatherObject(String placeName) {
        this.placeName = placeName;
    }

//    public void setPlaceName(String placeName) {
//        this.placeName = placeName;
//    }

    public void setCurrentWeather(String currentWeather) {
        this.currentWeather = currentWeather;
    }

    public void setCurrentWeatherDescription(String currentWeatherDescription) {
        this.currentWeatherDescription = currentWeatherDescription;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setFeelsLikeTemperature(double feelsLikeTemperature) {
        this.feelsLikeTemperature = feelsLikeTemperature;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getPlaceName() {
        return this.placeName;
    }

    public String getCurrentWeather() {
        return this.currentWeather;
    }

    public String getCurrentWeatherDescription() {
        return this.currentWeatherDescription;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public double getFeelsLikeTemperature() {
        return this.feelsLikeTemperature;
    }

    public int getHumidity() {
        return this.humidity;
    }
}
