package com.example.SpringUmbrellaAcademy2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class NationalWeatherService implements INationalWeatherService{

    @Value("${nwsName}")
    String name;
    @Override
    public int getChanceOfRain(String city) {
        int chanceOfRain;
        switch (city) {
            case "Charlotte" : {
                chanceOfRain = 51;
                break;
            }
            case "London" : {
                chanceOfRain = 90;
                break;
            }
            case "Las Vegas" : {
                chanceOfRain = 10;
                break;
            }
            default : {
                chanceOfRain = 49;
            }
        }
        return chanceOfRain;
    }
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
