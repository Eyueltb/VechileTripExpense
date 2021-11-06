package com.futureTravels.manager;

import com.futureTravels.service.TravelService;
import com.futureTravels.service.TravelServiceImpl;

import java.util.Arrays;

import static com.futureTravels.dao.vehicle.VehicleProperties.*;
import static com.futureTravels.dao.vehicle.VehicleProperties.FuelType.*;
import static com.futureTravels.dao.vehicle.VehicleProperties.VehicleType.*;

public class TravelManager {

    public static void main(String[] args) {
        //TravelManager tm=new TravelManager();
        TravelService ts=new TravelServiceImpl(1.5, 0.1, 0.2, 0.1);
        ts.addVehicleDiscount(CAR, 0);
        ts.addVehiclePassengerLimit(CAR, 4);
        int vehicleId = ts.addVehicle(DIESEL, CAR, true);
        ts.addDistance("Prague", "Brno", 200);
        ts.addDistance("Prague", "Budapest", 550);
        ts.addDistance("Brno", "Viena", 150);
        ts.addDistance("Brno", "Budapest", 350);

        int tripId=ts.addTrip( vehicleId, DIESEL,5, Arrays.asList("Prague","Brno","Budapest","Prague" ),true);

        System.out.println(ts.calculateTripCost(tripId));
        //tm.addTrip("VW GOlf, Diesel, NON AC, Prague-Brno-Budapest-Prague, 3");
    }

    /*private void addTrip(String tripInput){
        //To add a trip form inputs-
         String [] inputs=tripInput.split(",");

         FuelType type=(DIESEL.toString().equals(inputs[1].toUpperCase())) ? DIESEL: PETROL;

         boolean isAC=(inputs[2].endsWith("AC")) ? true : false;
         int numberOfPassenger=  Integer.parseInt(inputs[inputs.length-1].split(" ")[1]);
    }*/

}
