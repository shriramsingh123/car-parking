package main.java.repository;

import main.java.entity.Parking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ParkingRepository {

    void insert(Parking parking);
    List<Parking> findAll();

    List<Parking> findByDepartureDateAndTime();

    void updateDepartureDateAndTime(int pId,LocalDate departureDate, LocalTime departureTime);
}
