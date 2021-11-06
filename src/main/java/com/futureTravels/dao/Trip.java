package com.futureTravels.dao;

import com.futureTravels.dao.vehicle.Vehicle;

import java.util.List;

import static com.futureTravels.dao.vehicle.VehicleProperties.*;

public class Trip {
    int id;
    Vehicle vehicle;
    FuelType fuelType;
    int passengerCount;
    List<String> travelPlan;
    boolean isStandardRate;


    public Trip(int id, Vehicle vehicle, FuelType fuelType,
                int passengerCount, List<String> travelPlan, boolean isStandardRate) {
        this.id = id;
        this.vehicle = vehicle;
        this.fuelType = fuelType;
        this.passengerCount = passengerCount;
        this.travelPlan = travelPlan;
        this.isStandardRate = isStandardRate;
    }
}
