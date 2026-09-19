package org.varun.uberbookingservice.Dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NearbyDriverRESPONSEdto {

    private String driverId;

    private Double distance;

    private Double longitude;

    private Double latitude;
}
