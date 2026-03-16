package org.introduction.introduction_spring.service;

import org.introduction.introduction_spring.entity.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        int numero = reservation.getNumeroChambre();

        if (numero < 1 || numero > 9) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Les numéros de chambres sont compris entre 1 et 9 uniquement."
            );
        }

        reservations.add(reservation);
    }
}
