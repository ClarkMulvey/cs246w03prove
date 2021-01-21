package mulvey;

// Will use a non-default constructor taking a WeatherForecast object as an argument
public class City {
    // holds three values - max temp, max speed, and the name of the city in question
    private float maxTempNextFiveDays;
    private float maxWindSpeedNextFiveDays;
    private String name;

    // non-default constructor. calls the getMaxTemp(), getMaxWindSpeed(), getCityStats() methods
    // from the forecast parameter to populate it's member var's
    public City(WeatherForecast forecast) {
        this.maxTempNextFiveDays = forecast.getMaxTemp();
        this.maxWindSpeedNextFiveDays = forecast.getMaxWindSpeed();
        this.name = forecast.getCityStats().getName();
    }

    // Getters - used by Comparator classes
    public float getMaxTempNextFiveDays() {
        return this.maxTempNextFiveDays;
    }

    public float getMaxWindSpeedNextFiveDays() {
        return this.maxWindSpeedNextFiveDays;
    }

    // Display method - Displays member vars
    public void displayInfo() {
        System.out.println("City Name: " + this.name);
        System.out.println("Maximum temp in the next five days: " + this.maxTempNextFiveDays);
        System.out.println("Maximum wind speed in the next five days: " + this.maxWindSpeedNextFiveDays);
    }
}
