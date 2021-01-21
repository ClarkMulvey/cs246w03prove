package mulvey;

import com.google.gson.annotations.SerializedName;

import java.util.Map;


// No need for a constructor as we will never use it
public class WeatherConditions {
    // Each object will have an id, name of the city, and the measurements
    private int id;
    private String name;
    @SerializedName("main") private Map<String, Float> measurements;

    // Display the information
    public void displayWeatherConditions() {
        System.out.println("Current weather conditions in " + this.name + ":");
        System.out.println("id: " + this.id);
        this.measurements.forEach((k, v) -> System.out.printf("%s: %.02f%n", k, v));
        System.out.println("\n");
    }

}
