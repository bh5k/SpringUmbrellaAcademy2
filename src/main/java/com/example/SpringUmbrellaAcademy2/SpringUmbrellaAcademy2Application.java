package com.example.SpringUmbrellaAcademy2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@Slf4j
public class SpringUmbrellaAcademy2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringUmbrellaAcademy2Application.class, args);

		UmbrellaAcademy academy = context.getBean("umbrellaAcademy", UmbrellaAcademy.class);

		academy.shouldICarryAnUmbrella("Charlotte");
		academy.shouldICarryAnUmbrella("Las Vegas");
		academy.shouldICarryAnUmbrella("London");
		academy.shouldICarryAnUmbrella("Cleveland");

		String nwsName = academy.getNationalWeatherService().getName();;
		log.debug("\nThese forecasts were brought to you by " + nwsName + "\n");

		log.debug(academy.getSlogan());
		log.debug("The Umbrella Academy was founded on " + academy.getDateFounded().toString());
	}
}

