package org.varun.uberbookingservice.Dto;


import lombok.*;
import org.varun.uberentityservice.Models.BookingStatus;
import org.varun.uberentityservice.Models.Driver;

import java.util.Optional;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookingResponseDto {

    private Long bookingId;
    private BookingStatus status;
    private Optional<Driver> driver;
}
