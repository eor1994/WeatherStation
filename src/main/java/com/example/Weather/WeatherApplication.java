package com.example.Weather;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.Scanner;



@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(WeatherApplication.class, args);
		//System.out.println("Hello");
		URL urlOBJ = new URL("https://api.openweathermap.org/data/2.5/weather?q=Dublin,IRE&appid=257b4304aeeb76b44b77358c13ccccac");
		HttpURLConnection connection = (HttpURLConnection) urlOBJ.openConnection();
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();
		System.out.println("Resonse CODE: "+responseCode);

		if(responseCode == HttpURLConnection.HTTP_OK)
		{
			StringBuilder sb = new StringBuilder();
			Scanner scanner = new Scanner(connection.getInputStream());
			while (scanner.hasNext())
			{
				sb.append(scanner.nextLine());
			}
			System.out.println(sb);
		}


	}

}
