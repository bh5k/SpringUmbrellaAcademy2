package com.example.SpringUmbrellaAcademy2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class UmbrellaAcademyTests {

    UmbrellaAcademy uut;
    INationalWeatherService nws;
    IPublicServiceAnnouncement psa;
    String city;
    int testChanceOfRain;
    boolean expectedUmbrellaCarry;
    boolean actualUmbrellaCarry;

    @BeforeEach
    public void setUp()  {
        //create uut
        uut = new UmbrellaAcademy();

        //mock the dependent objects
        nws = mock(INationalWeatherService.class);
        psa = mock(IPublicServiceAnnouncement.class);

        //inject the mocks
        uut.setNationalWeatherService(nws);
        uut.setPublicServiceAnnouncement(psa);
    }

    @ParameterizedTest
    @CsvSource({"Charlotte, 51, true, 0", "London, 81, true, 1", "Cleveland, 49, false, 0"})
    public void testUmbrellaAcademy(String city, int testChanceOfRain, boolean expectedUmbrellaCarry, int timesCalled)  {

        when(nws.getChanceOfRain(city)).thenReturn(testChanceOfRain);

        actualUmbrellaCarry=uut.shouldICarryAnUmbrella(city);

        assertEquals(expectedUmbrellaCarry, actualUmbrellaCarry);

        verify(psa, times(timesCalled)).makeAnnouncement(anyString());
    }
}
