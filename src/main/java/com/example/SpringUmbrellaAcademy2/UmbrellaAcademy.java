package com.example.SpringUmbrellaAcademy2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Qualifier("firstUmbrellaAcademy")
public class UmbrellaAcademy {
    private IPublicServiceAnnouncement publicServiceAnnouncement;
    private INationalWeatherService nationalWeatherService;

    @Value("#{T(java.time.LocalDate).parse('${dateFounded}')}")
    LocalDate dateFounded;

    @Value("${UmbrellaAcademySlogan}")
    private String slogan;

    @Autowired
    public UmbrellaAcademy(IPublicServiceAnnouncement publicServiceAnnouncement, INationalWeatherService nationalWeatherService) {
        this.publicServiceAnnouncement = publicServiceAnnouncement;
        this.nationalWeatherService = nationalWeatherService;
    }

    public UmbrellaAcademy()  {

    }

    public boolean shouldICarryAnUmbrella(String location)  {
        boolean shouldICarry = false;
        String carryMessage = ("You won't need an umbrella in " + location);
        int chanceOfRain = nationalWeatherService.getChanceOfRain(location);
        if (chanceOfRain >= 50) {
            shouldICarry = true;
            carryMessage = ("You should carry an umbrella in " + location);
        }
        System.out.println(carryMessage);
        if (chanceOfRain >= 80) {
            publicServiceAnnouncement.makeAnnouncement("Carry an umbrella in " + location + ".");
        }
        return shouldICarry;
    }


    public IPublicServiceAnnouncement getPublicServiceAnnouncement() {
        return publicServiceAnnouncement;
    }

    //@Autowired
    public void setPublicServiceAnnouncement(IPublicServiceAnnouncement publicServiceAnnouncement) {
        this.publicServiceAnnouncement = publicServiceAnnouncement;
    }

    public INationalWeatherService getNationalWeatherService() {
        return nationalWeatherService;
    }

    @Autowired
    @Qualifier("alternateWeatherService")
    public void setNationalWeatherService(INationalWeatherService nationalWeatherService) {
        this.nationalWeatherService = nationalWeatherService;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public LocalDate getDateFounded() {
        return dateFounded;
    }

    public void setDateFounded(LocalDate dateFounded) {
        this.dateFounded = dateFounded;
    }
}
