package util;

import io.github.cdimascio.dotenv.Dotenv;

public class ApiConfig {
    public static final Dotenv dotenv = Dotenv.load();

    public static final String GEOCODING_KEY = dotenv.get("GEOCODING_API_KEY");
    public static final String WEATHER_KEY = dotenv.get("WEATHER_API_KEY");
}
