package main.java.designs;

public class DesignedOutput {

    public static void parkingConformation(String vehicleNo,int parkingSlot){
        System.out.println("\n****************************************");
        System.out.println("* \t 🚗 Parking Confirmation 🚗       *");
        System.out.println("****************************************");
        System.out.printf("* %-15s: %s \t \t \t   *\n", "Vehicle No.", vehicleNo);
        System.out.printf("* %-15s: %s \t \t \t \t   *\n", "Parking Spot",parkingSlot);
        System.out.println("****************************************");
        System.out.println("* ✅ Your vehicle is securely parked!  *");
        System.out.println("* 🏁 Enjoy Your Day , Dear             *");
        System.out.println("****************************************\n");
    }

    public static void parkingSlotUnavailable(int parkingSlot){
        System.out.println("\n****************************************");
        System.out.println("* 🚫 Parking Slot Unavailable 🚫        *");
        System.out.println("****************************************");
        System.out.printf("* Parking Slot %-3d is already booked! *\n",parkingSlot);
        System.out.println("* ❌ Please park somewhere else.       *");
        System.out.println("****************************************\n");
    }

    public static void noVehicleFound(){
        System.out.println("\n*****************************************");
        System.out.println("* 🚘 VEHICLE NOT FOUND IN PARKING 🚘     *");
        System.out.println("*****************************************");
        System.out.println("* ❌ No such vehicle is available!       *");
        System.out.println("* 🔄 Please verify the vehicle number.   *");
        System.out.println("* 🔁 Try again with a valid entry.       *");
        System.out.println("*****************************************\n");
    }

}
