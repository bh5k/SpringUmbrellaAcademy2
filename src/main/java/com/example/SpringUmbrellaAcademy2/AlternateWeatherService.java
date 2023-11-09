package com.example.SpringUmbrellaAcademy2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("alternateWeatherService")
public class AlternateWeatherService implements INationalWeatherService{

    @Value("${altNwsName}")
    String name;

    @Override
    public int getChanceOfRain(String city) {
        return 50;
    }

    @Override
    public String getName() {
        return null;
    }
}
