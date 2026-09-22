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
public class UpdateBookingRequestDto {
    private String status;
    private Optional<Long> driverId;
}
