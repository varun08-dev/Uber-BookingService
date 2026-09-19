package org.varun.uberbookingservice.Dto;

import lombok.*;
import org.varun.uberentityservice.Models.ExactLocation;
import org.varun.uberentityservice.Models.Passenger;



@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookingDto {

    private Long passengerId;
    private ExactLocation startLocation;
    private ExactLocation endLocation;
}
