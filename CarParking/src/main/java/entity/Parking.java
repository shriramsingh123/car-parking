package main.java.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Parking {

    private int pId;
    private String ownerName;
    private int parkingNo;
    private String vehicleNumber;
    private VehicleType vehicleType;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private LocalDate departureDate;
    private LocalTime departureTime;

    public String getOwnerName() {
        return ownerName;
    }

    public int getpId() {
        return pId;
    }

    public Parking setpId(int pId) {
        this.pId = pId;
        return this;
    }

    public Parking setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public int getParkingNo() {
        return parkingNo;
    }

    public Parking setParkingNo(int parkingNo) {
        this.parkingNo = parkingNo;
        return this;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public Parking setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        return this;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Parking setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public Parking setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
        return this;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public Parking setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public Parking setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public Parking setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
        return this;
    }

    @Override
    public String toString() {
        return String.format("🚘 Owner: %s | 🏠 Parking No: %d | 🔢 Vehicle No: %s | 🚗 Type: %s | 📅 Arrival: %s | ⏰ Time: %tT | 📅 Departure: %s | ⏰ Time: %tT",
                ownerName, parkingNo, vehicleNumber, vehicleType,
                arrivalDate,
                arrivalTime,
                departureDate,
                departureTime);
    }
}
