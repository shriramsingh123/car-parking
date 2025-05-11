package main.java.entity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Billings {
    private final double basePrice = 50.0;

    public void getBills(Parking parking){
        double pricePerMinute;
        double taxRate = 18.0;
        if (parking.getVehicleType() == VehicleType.CAR){
            pricePerMinute = 30;
        } else if (parking.getVehicleType() == VehicleType.TRUCK) {
            pricePerMinute = 50;
        }else {
            pricePerMinute = 10;
        }

        long minutesParked = Duration.between(
                LocalDateTime.of(parking.getArrivalDate(),parking.getArrivalTime()),
                LocalDateTime.of(LocalDate.now(),LocalTime.now()))
                .toMinutes();


        double totalWithoutTax = basePrice + (pricePerMinute * minutesParked);
        double totalTax = (totalWithoutTax * taxRate) /100;
        double totalAmount = totalWithoutTax + totalTax;

        System.out.println("\n******************************************");
        System.out.println("*            🚗 PARKING BILL 🚗         *");
        System.out.println("******************************************");
        System.out.printf("* %-15s: %s \n", "Owner Name", parking.getOwnerName());
        System.out.printf("* %-15s: %s \t \t \t \t *\n", "Vehicle No.", parking.getVehicleNumber());
        System.out.printf("* %-15s: %s \t \t \t \t *\n","Vehicle Type",parking.getVehicleType());
        System.out.println("******************************************");
        System.out.printf("* %-15s: %s \t \t \t *\n", "Arrival Date", parking.getArrivalDate());
        System.out.printf("* %-15s: %02d:%02d %s \t \t \t *\n", "Arrival Time",
                parking.getArrivalTime().getHour(),
                parking.getArrivalTime().getMinute(),
                "hrs");
        System.out.printf("* %-15s: %s \t \t \t *\n", "Departure Date", LocalDate.now());
        System.out.printf("* %-15s: %02d:%02d %s \t \t \t *\n", "Departure Time",
                LocalTime.now().getHour(),
                LocalTime.now().getMinute(),
                "hrs");
        System.out.println("******************************************");
        System.out.printf("* %-15s: ₹%.2f \t \t \t \t *\n", "Base Price", basePrice);
        System.out.printf("* %-15s: ₹%.2f /min \t \t \t *\n", "Per Minutes", pricePerMinute);
        System.out.printf("* %-15s: %d min \t \t \t \t *\n", "Minutes Parked", minutesParked);
        System.out.printf("* %-15s: ₹%.2f \t \t \t \t *\n", "Tax (18%)", totalTax);
        System.out.println("******************************************");
        System.out.printf("* %-15s: ₹%.2f \t \t \t \t *\n", "Total Amount", totalAmount);
        System.out.println("******************************************");
        System.out.println("*          THANK YOU! DRIVE SAFELY!      *");
        System.out.println("******************************************\n");


    }

}