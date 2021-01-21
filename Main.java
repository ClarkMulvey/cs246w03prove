package mulvey;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    // This method will return a WeatherConditions object
    // It will access the API using the requestURl given as an argument
    public static WeatherConditions getWeatherConditions(String requestUrl) {
        Gson gson = new Gson();
        String responseBody = "";

        // Get the data from API
        try {
            URLConnection connection = new URL(requestUrl).openConnection();
            InputStream response = connection.getInputStream();

            // Turn it into a usable String
            try (Scanner scanner = new Scanner(response)) {
                responseBody = scanner.useDelimiter("\\A").next();
            }

        } catch (IOException e) {
            System.out.println("There has been an error");
            e.printStackTrace();
        }

        // Deserialize into a WeatherConditions object and return
        WeatherConditions weather = gson.fromJson(responseBody, WeatherConditions.class);
        return weather;
    }

    // This method will return a WeatherForecast object
    // It will access the API using the requestURl given as an argument
    public static WeatherForecast getWeatherForecast(String requestUrl) {
        Gson gson = new Gson();
        String responseBody = "";

        // Get the data from API
        try {
            URLConnection connection = new URL(requestUrl).openConnection();
            InputStream response = connection.getInputStream();

            // Turn it into a usable String
            try (Scanner scanner = new Scanner(response)) {
                responseBody = scanner.useDelimiter("\\A").next();
            }

        } catch (IOException e) {
            System.out.println("There has been an error");
            e.printStackTrace();
        }

        // Deserialize into a WeatherConditions object and return
        WeatherForecast forecast = gson.fromJson(responseBody, WeatherForecast.class);

        return forecast;
    }

    public static void main(String[] args) {
        // Get input from the user - which city do they want to know stats on
        System.out.print("Please enter the name of a city you would like to see the weather conditions and forecast for: ");
        Scanner in = new Scanner(System.in);
        String city = in.nextLine();

        // create the urls that we will use
        String param1 = "units=imperial";
        String param2 = "q=";
        String param3 = "apiKey=26286e129e244ca1c8a917150937d991";
        String query = String.format("%s&%s&%s", param1, param2 + city, param3);
        String urlWeatherConditions = "https://api.openweathermap.org/data/2.5/weather" + "?" + query;
        String urlWeatherForecast = "https://api.openweathermap.org/data/2.5/forecast" + "?" + query;

        // get the weather conditions into a new object and display
        WeatherConditions conditions = getWeatherConditions(urlWeatherConditions);
        conditions.displayWeatherConditions();

        // get the weather forecast into a new object and display
        WeatherForecast forecast = getWeatherForecast(urlWeatherForecast);
        forecast.displayWeatherForecast();


        // ######## STRETCH CHALLENGE ############
        List<City> cityList = new ArrayList<>();
        String[] cityNameList = {"Layton", "Logan", "Juneau", "Sitka", "Blytheville"};

        // In this for loop we go through each city in cityNameList, use that to get our
        // url, create a WeatherForecast object using that url,
        // create a City object using that WeatherForecast object,
        // Add that city to our list of Cities
        for (int i = 0; i < cityNameList.length; i++) {
            query = String.format("%s&%s&%s", param1, param2 + cityNameList[i], param3);
            urlWeatherForecast = "https://api.openweathermap.org/data/2.5/forecast" + "?" + query;
            cityList.add(new City(getWeatherForecast(urlWeatherForecast)));
        }

        //################ Sort and Display ########################
        // Display unsorted list
        System.out.println("\nHere is the list of unsorted cities");
        System.out.println("-------------------------------------");
        for (int i = 0; i < cityList.size(); i++) {
            cityList.get(i).displayInfo();
            System.out.println("-------------------------------------");
        }
        System.out.println("\n");


        // Sort by max temp
        Collections.sort(cityList, new SortByMaxTemp());
        // Display results
        System.out.println("Here is the list of cities sorted from the highest maximum temperature to the lowest (for the next 5 days):");
        System.out.println("-------------------------------------");
        for (int i = 0; i < cityList.size(); i++) {
            cityList.get(i).displayInfo();
            System.out.println("-------------------------------------");
        }
        System.out.println("\n");


        // Sort by max wind speed
        Collections.sort(cityList, new SortByMaxWindSpeed());
        // Display results
        System.out.println("Here is the list of cities sorted from the highest potential wind speed to the lowest (for the next 5 days):");
        System.out.println("-------------------------------------");
        for (int i = 0; i < cityList.size(); i++) {
            cityList.get(i).displayInfo();
            System.out.println("-------------------------------------");
        }
    }
}
