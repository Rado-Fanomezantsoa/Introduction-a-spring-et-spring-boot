package org.introduction.introduction_spring.service;

import org.introduction.introduction_spring.entity.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {


    private final List<Reservation> reservations = new ArrayList<>();


    public List<Reservation> getAllReservations() {
        return reservations;
    }

    public boolean isAvailable(int numeroChambre, LocalDate dateReservation) {
        return reservations.stream()
                .noneMatch(r -> r.getNumeroChambre() == numeroChambre
                        && r.getDateReservation().isEqual(dateReservation));
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }
}
