package org.varun.uberbookingservice.Services;


import org.springframework.stereotype.Service;
import org.varun.uberbookingservice.Dto.CreateBookingDto;
import org.varun.uberbookingservice.Dto.CreateBookingResponseDto;
import org.varun.uberentityservice.Models.Booking;


public interface BookingService {

 public CreateBookingResponseDto createBooking(CreateBookingDto createBookingDto);




}
