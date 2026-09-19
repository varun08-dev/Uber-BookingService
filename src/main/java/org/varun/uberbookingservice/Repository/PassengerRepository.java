package org.varun.uberbookingservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.varun.uberentityservice.Models.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
