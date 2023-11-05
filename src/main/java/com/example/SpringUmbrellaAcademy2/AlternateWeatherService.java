package com.example.SpringUmbrellaAcademy2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class AlternateWeatherService implements INationalWeatherService{
    @Override
    public int getChanceOfRain(String city) {
        return 50;
    }

    @Override
    public String getName() {
        return null;
    }
}
