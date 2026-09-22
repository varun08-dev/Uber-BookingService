package org.varun.uberbookingservice.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.varun.uberbookingservice.Dto.CreateBookingDto;
import org.varun.uberbookingservice.Dto.CreateBookingResponseDto;
import org.varun.uberbookingservice.Dto.UpdateBookingRequestDto;
import org.varun.uberbookingservice.Dto.UpdateBookingResponseDto;
import org.varun.uberbookingservice.Services.BookingService;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/newbooking")
    public ResponseEntity<CreateBookingResponseDto> createBooking(@RequestBody CreateBookingDto request){
            return new ResponseEntity<>(bookingService.createBooking(request), HttpStatus.OK);
    }

    @PatchMapping("/{bookingId}")
    public ResponseEntity<UpdateBookingResponseDto> updateBooking(@RequestBody UpdateBookingRequestDto requestDto, @PathVariable Long bookingId) throws Throwable {
        return new ResponseEntity<>(bookingService.updateBooking(bookingId,requestDto), HttpStatus.OK);
    }
}
