package com.example.SpringUmbrellaAcademy2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
public class UmbrellaAcademySpringIT {

    @Autowired
    UmbrellaAcademy uut;

    @MockBean
    INationalWeatherService nws;

   @MockBean
    IPublicServiceAnnouncement psa;

    @ParameterizedTest
    @CsvSource({"Charlotte, 51, true, 0", "London, 81, true, 1", "Cleveland, 49, false, 0"})
    public void testUmbrellaAcademy(String city, int testChanceOfRain, boolean expectedUmbrellaCarry, int timesCalled)  {

        when(nws.getChanceOfRain(city)).thenReturn(testChanceOfRain);

        boolean actualUmbrellaCarry=uut.shouldICarryAnUmbrella(city);

        assertEquals(expectedUmbrellaCarry, actualUmbrellaCarry);

        verify(psa, times(timesCalled)).makeAnnouncement(anyString());
    }
}
