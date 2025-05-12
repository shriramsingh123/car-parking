package main.java.service;

import main.java.designs.DesignedOutput;
import main.java.entity.Billings;
import main.java.entity.Parking;
import main.java.entity.VehicleType;
import main.java.repository.ParkingRepository;
import main.java.repository.ParkingRepositoryImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ParkingServiceImpl implements ParkingService{

    private final ParkingRepository repository = new ParkingRepositoryImpl();


    @Override
    public void arrive(Scanner sc) {

        List<Parking> parkingList = repository.findByDepartureDateAndTime();
        Parking parking = new Parking();

        System.out.print("Enter the ownerName : ");
        parking.setOwnerName(sc.nextLine());

        System.out.print("Enter the vehicle Number: ");
        parking.setVehicleNumber(sc.next());
        sc.nextLine();

        for (Parking park : parkingList){
            if (park.getVehicleNumber().equals(parking.getVehicleNumber())){
                System.out.println("Hey Dear , This Vehicle is already parked.");
                return;
            }
        }

        System.out.print("Allot parkingSlot (Integer) : ");
        parking.setParkingNo(sc.nextInt());
        sc.nextLine();


        for (Parking park : parkingList){
            if (park.getParkingNo() == parking.getParkingNo()){
                DesignedOutput.parkingSlotUnavailable(parking.getParkingNo());
                return;
            }
        }

        System.out.println("1.Car 2.Truck 3.Two Wheeler");
        System.out.print("Enter the Vehicle type (Integer) : ");
        int vehicleType = sc.nextInt();
        sc.nextLine();

        switch (vehicleType) {
            case 1: parking.setVehicleType(VehicleType.CAR); break;
            case 2: parking.setVehicleType(VehicleType.TRUCK); break;
            case 3: parking.setVehicleType(VehicleType.TWO_WHEELER); break;
            default:{
                System.out.println("Invalid vehicle Type");
                return;
            }
        }
        parking.setArrivalDate(LocalDate.now());
        parking.setArrivalTime(LocalTime.now());


        repository.insert(parking);

        // Conformation message
        DesignedOutput.parkingConformation(parking.getVehicleNumber(),parking.getParkingNo());

    }

    @Override
    public void departure(Scanner scanner){
        System.out.print("Enter the vehicle number : ");
        String vehicleNumber = scanner.nextLine();
        Parking park = null;
        List<Parking> parkingList = repository.findByDepartureDateAndTime();
        for (Parking parking : parkingList){
            if (parking.getVehicleNumber().equals(vehicleNumber)){
                park = parking;
            }
        }
        if (park == null) {
            DesignedOutput.noVehicleFound();
            return;
        }
        Billings billings = new Billings();
        repository.updateDepartureDateAndTime(park.getpId(),LocalDate.now(),LocalTime.now());
        billings.getBills(park);
    }

    @Override
    public void allParkedVehicleList() {
        List<Parking> parkedVehicleList = repository.findByDepartureDateAndTime();
        if (!parkedVehicleList.isEmpty()){
            for (Parking parking : parkedVehicleList){
                System.out.println(parking);
            }
        }else {
            System.out.println("Sorry No Vehicle are parked in the Parking");
        }
    }

    @Override
    public void allParkingHistoryList(){
        List<Parking>  allParkedVehicleList = repository.findAll();
        if (!allParkedVehicleList.isEmpty()){
            for (Parking parking : allParkedVehicleList){
                System.out.println(parking);
            }
        }else {
            System.out.println("Sorry No Vehicle are parked in the Parking");
        }

    }

    @Override
    public void getVehicleHistory(Scanner scanner) {
        System.out.print("Enter the vehicle no : ");
        String vehicleNo = scanner.next();
        List<Parking> parkingList = repository.findByVehicleNo(vehicleNo);

        if (!parkingList.isEmpty()){
            parkingList.sort(Comparator.comparing(Parking::getArrivalDate));
            parkingList.forEach(System.out::println);
        }else {
            System.out.println("Vehicle No : "+vehicleNo+" Never parked in our parking.");
        }
    }


}
