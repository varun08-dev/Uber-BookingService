package org.varun.uberbookingservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.varun.uberentityservice.Models.Booking;


@Repository
public interface   BookingRepository extends JpaRepository<Booking, Long> {
}
