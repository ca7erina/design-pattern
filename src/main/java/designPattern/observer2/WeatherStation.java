package designPattern.observer2;

public class WeatherStation {

    public static void main(String[] args){
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);


        weatherData.setMeasurents(80,65,30.4f);
        weatherData.setMeasurents(82,70,29.1f);
        weatherData.setMeasurents(78,90,29.2f);

    }

}
