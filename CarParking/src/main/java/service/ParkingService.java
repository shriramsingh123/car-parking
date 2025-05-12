package main.java.service;


import java.util.Scanner;

public interface ParkingService {

    void arrive(Scanner scanner);

    void departure(Scanner scanner);

    void allParkedVehicleList();

    void allParkingHistoryList();

    void getVehicleHistory(Scanner scanner);
}