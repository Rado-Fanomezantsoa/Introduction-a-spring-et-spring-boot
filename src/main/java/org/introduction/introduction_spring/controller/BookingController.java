package org.introduction.introduction_spring.controller;

import org.introduction.introduction_spring.entity.Reservation;
import org.introduction.introduction_spring.service.BookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
