package mulvey;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

// Don't need a constructor because we never use it
public class WeatherForecastItem {
    // Each WeatherForecast Item will have these variables:
    @SerializedName("main") private Map<String, Float> measurements;
    private List<Map<String, String>> weather;
    private Map<String, Float> wind;
    @SerializedName("dt_txt") private String dateTime;

    // Getters
    public Map<String,Float> getMeasurements() {
        return this.measurements;
    }

    public List<Map<String,String>> getWeather() {
        return this.weather;
    }

    public Map<String,Float> getWind() {
        return this.wind;
    }

    public String getDateTime() {
        return this.dateTime;
    }
}
