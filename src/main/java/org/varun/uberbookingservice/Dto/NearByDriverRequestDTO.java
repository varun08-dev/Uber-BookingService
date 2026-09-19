package org.varun.uberbookingservice.Dto;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NearByDriverRequestDTO {

    private Double latitude;
    private Double longitude;
}
