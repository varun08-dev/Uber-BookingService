package org.varun.uberbookingservice.Apis;

import org.varun.uberbookingservice.Dto.NearByDriverRequestDTO;
import org.varun.uberbookingservice.Dto.NearbyDriverRESPONSEdto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

public interface LocationServiceApi {
    @POST("/api/locations/nearby/Drivers")
    Call<List<NearbyDriverRESPONSEdto>> getNearByDrivers(@Body NearByDriverRequestDTO request);
}
