package com.example.SpringUmbrellaAcademy2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("classpath:application.properties")
public class SpringUmbrellaAcademy2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringUmbrellaAcademy2Application.class, args);

		UmbrellaAcademy academy = context.getBean("umbrellaAcademy", UmbrellaAcademy.class);

		academy.shouldICarryAnUmbrella("Charlotte");
		academy.shouldICarryAnUmbrella("Las Vegas");
		academy.shouldICarryAnUmbrella("London");
		academy.shouldICarryAnUmbrella("Cleveland");

		String nwsName = academy.getNationalWeatherService().getName();;
		System.out.println("\nThese forecasts were brought to you by " + nwsName + "\n");

		System.out.println(academy.getSlogan());
		System.out.println("The Umbrella Academy was founded on " + academy.getDateFounded().toString());
	}
}

