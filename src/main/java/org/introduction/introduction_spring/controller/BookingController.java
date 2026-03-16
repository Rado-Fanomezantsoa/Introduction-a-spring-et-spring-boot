package org.introduction.introduction_spring.controller;

import jakarta.validation.Valid;
import org.introduction.introduction_spring.entity.Reservation;
import org.introduction.introduction_spring.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;


    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // GET /booking
    @GetMapping
    public List<Reservation> getAllBookings() {
        return bookingService.getAllReservations();
    }

    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody @Valid Reservation newReservation) {


        if (!bookingService.isAvailable(newReservation.getNumeroChambre(),
                newReservation.getDateReservation())) {

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("La chambre " + newReservation.getNumeroChambre()
                            + " n’est plus disponible pour le "
                            + newReservation.getDateReservation());
        }


        bookingService.addReservation(newReservation);


        return ResponseEntity.ok(bookingService.getAllReservations());
    }
}
