package controller;

import api.CoordinateService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import model.WeatherObject;
import parser.WeatherParser;
import service.WeatherService;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;

public class WeatherController {

    private WeatherService service;

    @FXML private TextField searchTextField;
    @FXML private Text cityNameText;
    @FXML private Text currentWeatherText;
    @FXML private Text currentWeatherDescriptionText;
    @FXML private Text temperatureText;
    @FXML private Text feelsLikeTemperatureText;
    @FXML private Text humidityText;

    public WeatherService getService() {
        return service;
    }

    public WeatherController() {
        this.service = new WeatherService();
    }

    @FXML protected void handleSearchAgainButtonAction(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/weatherview.fxml")
            );

            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root, 900, 600));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML protected void handleFetchButton(ActionEvent event) throws Exception{
        WeatherObject weather = this.service.getWeather(this.searchTextField.getText().trim());

        this.cityNameText.setText(weather.getPlaceName());
        this.currentWeatherText.setText(weather.getCurrentWeather());
        this.currentWeatherDescriptionText.setText(weather.getCurrentWeatherDescription());
        this.temperatureText.setText(String.format(String.valueOf("%.0f°"), weather.getTemperature()));
        this.feelsLikeTemperatureText.setText(String.format(String.valueOf("%.0f°"), weather.getFeelsLikeTemperature()));
        this.humidityText.setText(String.format(String.valueOf("%s%%"), weather.getHumidity()));
    }

}
