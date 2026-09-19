package org.varun.uberbookingservice.Services;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.varun.uberbookingservice.Apis.LocationServiceApi;
import org.varun.uberbookingservice.Dto.*;

import org.varun.uberbookingservice.Repository.BookingRepository;
import org.varun.uberbookingservice.Repository.PassengerRepository;
import org.varun.uberentityservice.Models.Booking;
import org.varun.uberentityservice.Models.BookingStatus;
import org.varun.uberentityservice.Models.Passenger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;
import java.util.Optional;


@Service
public class BookingServiceImpl implements BookingService{


    private final PassengerRepository passengerRepository;
    private final BookingRepository bookingRepository;

    private final LocationServiceApi locationServiceApi;


    public BookingServiceImpl(PassengerRepository passengerRepository, BookingRepository bookingRepository,LocationServiceApi locationServiceApi) {
        this.passengerRepository = passengerRepository;
        this.bookingRepository = bookingRepository;
        this.locationServiceApi = locationServiceApi;


    }



    ///now it need to fetch the nearbyDriver .. which will be comming from Locstion servive
    /// and this comm. will be Sync comm.
    @Override
    public CreateBookingResponseDto createBooking(CreateBookingDto createBookingDto) {
       Optional<Passenger> passenger = passengerRepository.findById(createBookingDto.getPassengerId());
        Booking Newbooking = Booking.builder()
                .bookingStatus(BookingStatus.ASSIGNING_DRIVER)
                .startLocation(createBookingDto.getStartLocation())
                .endLocation(createBookingDto.getEndLocation())
                .passenger(passenger.get())
                .build();

       Booking booking= bookingRepository.save(Newbooking);


       /// making an api call to LocationService for nearByDrivers
        NearByDriverRequestDTO request = new NearByDriverRequestDTO(
                createBookingDto.getStartLocation().getLatitude(),
                createBookingDto.getStartLocation().getLongitude()
        );

        getNearByDrivers(request);


        return CreateBookingResponseDto.builder()
                .bookingId(booking.getId())
                .bookingStatus(booking.getBookingStatus().toString())
                //.passenger(booking.getPassenger())
                .driver(Optional.ofNullable(booking.getDriver()))
                .build();
    }





    /// THIS METHOD WILL ASYNC CALL LOCATION SERVICE TO GET DRIVER
    private void getNearByDrivers(NearByDriverRequestDTO requestDTO){
        Call<List<NearbyDriverRESPONSEdto>> call = locationServiceApi.getNearByDrivers(requestDTO);

        ///now we need this as Async
        /// so we will use enqueue()
        /// for SYnc== execute()

        call.enqueue(new Callback<List<NearbyDriverRESPONSEdto>>() {
            @Override
            public void onResponse(Call<List<NearbyDriverRESPONSEdto>> call, Response<List<NearbyDriverRESPONSEdto>> response) {
                if (response.isSuccessful() && response.body() != null){
                    List<NearbyDriverRESPONSEdto> drivers = response.body();
                    drivers.forEach(x-> {
                        System.out.println("DriverID : "+x.getDriverId() + "\n" +"Latitude : "+ x.getLatitude() +"\n" +"Longitude : "+x.getLongitude());
                    });

                }
            }

            @Override
            public void onFailure(Call<List<NearbyDriverRESPONSEdto>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }


}
