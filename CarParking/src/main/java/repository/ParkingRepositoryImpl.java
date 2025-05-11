package main.java.repository;

import main.java.connections.CreateConnections;
import main.java.entity.Parking;
import main.java.entity.VehicleType;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingRepositoryImpl implements ParkingRepository{

    private static final Connection connection = CreateConnections.getConnection();

    @Override
    public void insert(Parking parking){

       if (connection!=null){
           try {
               String query = "insert into parking(ownerName,parkingNo,vehicleNo,vehicleType,arrivalDate,arrivalTime) values(?,?,?,?,?,?)";
               PreparedStatement ps = connection.prepareStatement(query);
               ps.setString(1,parking.getOwnerName());
               ps.setInt(2,parking.getParkingNo());
               ps.setString(3,parking.getVehicleNumber());
               ps.setString(4,String.valueOf(parking.getVehicleType()));
               ps.setDate(5, Date.valueOf(LocalDate.now()));
               ps.setTime(6, Time.valueOf(LocalTime.now()));

               int i = ps.executeUpdate();
               System.out.println(i>0?"Inserted":"Not Inserted");

           } catch (SQLException e) {
               e.printStackTrace();

           }
       }

    }

    @Override
    public List<Parking> findAll() {
       if (connection!= null){
           try {
               Statement statement = connection.createStatement();
               ResultSet resultSet = statement.executeQuery("SELECT * FROM parking");
               List<Parking>  parkingList = new ArrayList<>();
                   while (resultSet.next()){
                       parkingList.add(
                               new Parking()
                                       .setpId(resultSet.getInt("pId"))
                                       .setOwnerName(resultSet.getString("ownerName"))
                                       .setVehicleNumber(resultSet.getString("vehicleNo"))
                                       .setParkingNo(resultSet.getInt("parkingNo"))
                                       .setVehicleType(VehicleType.valueOf(resultSet.getString("vehicleType")))

                                       .setArrivalDate(resultSet.getDate("arrivalDate").toLocalDate())
                                       .setArrivalTime(resultSet.getTime("arrivalTime").toLocalTime())

                                       .setDepartureDate(resultSet.getDate("departureDate") != null ?
                                               resultSet.getDate("departureDate").toLocalDate() : null)
                                       .setDepartureTime(resultSet.getTime("departureTime")!=null ?
                                               resultSet.getTime("departureTime").toLocalTime() : null)
                       );

                   }
                   return parkingList;


           } catch (SQLException e) {
               e.printStackTrace();
               return null;
           }
       }
        return null;
    }

    @Override
    public List<Parking> findByDepartureDateAndTime() {
        if (connection!= null){
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM parking WHERE departureDate is NULL AND departureTime is NULL");
                List<Parking>  parkingList = new ArrayList<>();
                    while (resultSet.next()){
                        parkingList.add(
                                new Parking()
                                        .setpId(resultSet.getByte("pId"))
                                        .setOwnerName(resultSet.getString("ownerName"))
                                        .setVehicleNumber(resultSet.getString("vehicleNo"))
                                        .setParkingNo(resultSet.getInt("parkingNo"))
                                        .setVehicleType(VehicleType.valueOf(resultSet.getString("vehicleType")))

                                        .setArrivalDate(resultSet.getDate("arrivalDate").toLocalDate())
                                        .setArrivalTime(resultSet.getTime("arrivalTime").toLocalTime())

                                        .setDepartureDate(resultSet.getDate("departureDate") != null ?
                                                resultSet.getDate("departureDate").toLocalDate() : null)
                                        .setDepartureTime(resultSet.getTime("departureTime")!=null ?
                                                resultSet.getTime("departureTime").toLocalTime() : null)
                        );

                    }
                    return parkingList;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override
    public void updateDepartureDateAndTime(int pId,LocalDate departureDate, LocalTime departureTime) {
        if (connection !=null){
            try {
                PreparedStatement preparedStatement =
                        connection.prepareStatement("UPDATE parking SET departureDate = ?, departureTime = ? WHERE pId = ?");
                preparedStatement.setDate(1, Date.valueOf(departureDate));
                preparedStatement.setTime(2, Time.valueOf(departureTime));
                preparedStatement.setInt(3,pId);

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
