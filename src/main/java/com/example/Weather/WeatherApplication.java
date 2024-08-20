package com.example.Weather;
import com.example.Weather.Service.WeatherService;
import com.example.Weather.Model.WeatherModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
		System.out.println("Hello");

		//debugging section:
		System.out.println("Api response:  ");

	}

}
