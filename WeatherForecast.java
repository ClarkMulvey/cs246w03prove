package mulvey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// Don't need a constructor because we never use it
public class WeatherForecast {
    private List<WeatherForecastItem> list;
    @SerializedName("city") private ForecastCityStats cityStats;

    // getters
    public ForecastCityStats getCityStats() {
        return this.cityStats;
    }

    // This method will sort through this.list and find the WeatherForecastItem that has the
    // largest measurement of temp_max, and return that value
    public float getMaxTemp() {

        float maxTemp = 0;

        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getMeasurements().get("temp_max") > maxTemp) {
                maxTemp = this.list.get(i).getMeasurements().get("temp_max");
            };
        }

        return maxTemp;
    }

    // This method will sort through this.list and find the WeatherForecastItem that has the
    // largest wind speed, and return that value
    public float getMaxWindSpeed() {

        float maxWindSpeed = 0;

        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getWind().get("speed") > maxWindSpeed) {
                maxWindSpeed = this.list.get(i).getWind().get("speed");
            };
        }

        return maxWindSpeed;
    }

    // Display the information for the whole 5 day forecast
    public void displayWeatherForecast() {
        System.out.println("Weather forecast for " + this.cityStats.getName() + ": (Next five days)");
        for (int i = 0; i < this.list.size(); i++) {
            System.out.println(this.list.get(i).getDateTime());
            System.out.println("Temperature: " + this.list.get(i).getMeasurements().get("temp") + " Fahrenheit");
            System.out.println("Conditions: " + this.list.get(i).getWeather().get(0).get("description"));
            System.out.println("Wind: " + this.list.get(i).getWind().get("speed") + "mph at " + this.list.get(1).getWind().get("deg") + " degrees");
            System.out.println("--------------------");
        }
    }
}
