package com.futureTravels.manager;

import com.futureTravels.service.TravelService;
import com.futureTravels.service.TravelServiceImpl;

import java.util.Arrays;

import static com.futureTravels.dao.vehicle.VehicleProperties.FuelType.*;
import static com.futureTravels.dao.vehicle.VehicleProperties.VehicleType.*;

public class TravelManager {

    public static void main(String[] args) {
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

    }

    //addTrip("VW GOlf, Diesel, NON AC, Prague-Brno-Budapest-Prague, 3");

}
