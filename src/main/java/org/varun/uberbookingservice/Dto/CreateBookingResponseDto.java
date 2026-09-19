package org.varun.uberbookingservice.Dto;

import lombok.*;
import org.varun.uberentityservice.Models.Driver;
import org.varun.uberentityservice.Models.Passenger;

import java.util.Optional;



@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookingResponseDto {
    private long bookingId;
    //private Passenger passenger;
    private Optional<Driver> driver;
    private String bookingStatus;
}
