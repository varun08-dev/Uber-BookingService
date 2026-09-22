package org.varun.uberbookingservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.varun.uberentityservice.Models.Booking;
import org.varun.uberentityservice.Models.BookingStatus;
import org.varun.uberentityservice.Models.Driver;

import java.util.List;


@Repository
public interface   BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findBookingById(long id);

    @Modifying
    @Query("UPDATE Booking B SET B.bookingStatus=:status , B.driver=:driver WHERE B.id=:id")
    void updateBookingStatusAndDriverById(@Param("id") Long id, @Param("status") BookingStatus status, @Param("driver") Driver driver);
}
