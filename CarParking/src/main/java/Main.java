package main.java;

import main.java.designs.DeveloperName;
import main.java.service.ParkingService;
import main.java.service.ParkingServiceImpl;

import java.util.Scanner;

public class Main {

    public static final ParkingService service = new ParkingServiceImpl();

    public static void main(String[] args) {
        System.out.println("Build By :::::===>>>");
        DeveloperName.printDeveloperName();


        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("1.Arrive, 2.Departure, 3.Parked Vehicle List, 4.Parking History, 5.Vehicle History");
            System.out.print("Enter the choices : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1 : {
                    service.arrive(scanner);
                }break;
                case 2 : {
                    service.departure(scanner);
                }break;
                case 3 :{
                    service.allParkedVehicleList();
                }break;
                case 4 :{
                    service.allParkingHistoryList();
                }break;
                case 5 :{
                    service.getVehicleHistory(scanner);
                }break;
                default:{
                    System.out.println("Invalid Choice");
                }
            }
        }
    }
}
