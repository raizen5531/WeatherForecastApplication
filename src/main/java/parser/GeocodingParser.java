package parser;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.CoordinateObject;

import java.io.IOException;

public class GeocodingParser {

    private ObjectMapper objectMapper;

    public GeocodingParser() {
        this.objectMapper = new ObjectMapper();
    }

    public void parseCoordinateData(String jsonString, CoordinateObject coordinateObject) throws JsonMappingException, JsonParseException,  IOException{
        JsonNode jsonNode = this.objectMapper.readTree(jsonString);

        double latitude = jsonNode.get(0).get("lat").asDouble();
        coordinateObject.setLatitude(latitude);

        double longitude = jsonNode.get(0).get("lon").asDouble();
        coordinateObject.setLongitude(longitude);
    }

}
