package api;

import util.ApiConfig;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class CoordinateService {

    private HttpClient client;
    private String apiKey;

    public CoordinateService() {
        this.client = HttpClient.newHttpClient();
        this.apiKey = ApiConfig.GEOCODING_KEY;
    }

    public String fetchCoordinates(String placeName) throws InterruptedException, IOException {
        String apiCall = "http://api.openweathermap.org/geo/1.0/direct?q="+placeName+"&limit=3&appid=" + this.apiKey;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiCall))
                .version(HttpClient.Version.HTTP_2)
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());

        return response.body();
    }
}
