package org.introduction.introduction_spring.service;

import org.introduction.introduction_spring.entity.Reservation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {


    private final List<Reservation> reservations = new ArrayList<>();


    public List<Reservation> getAllReservations() {
        return reservations;
    }

    // On ajoutera plus tard la méthode pour ajouter une réservation
}
