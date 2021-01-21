package mulvey;

// used by WeatherForecast to store information from the forecast JSON
// Don't have a constructor because we never use one
public class ForecastCityStats {
    private int id;
    private String name;
    private String country;

    // Getters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }
}
