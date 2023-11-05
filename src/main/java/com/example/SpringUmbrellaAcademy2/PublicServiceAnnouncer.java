package com.example.SpringUmbrellaAcademy2;

import org.springframework.stereotype.Component;

@Component
public class PublicServiceAnnouncer implements IPublicServiceAnnouncement{
    @Override
    public void makeAnnouncement(String announcement) {
        System.out.println("This is a public service announcement.  "  + announcement);
    }
}
