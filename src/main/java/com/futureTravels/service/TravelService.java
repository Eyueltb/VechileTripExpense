package com.futureTravels.service;

import com.futureTravels.dao.TravelAgencyRates;
import com.futureTravels.dao.vehicle.Vehicle;
import com.futureTravels.dao.vehicle.VehicleProperties;

import java.util.List;

import static com.futureTravels.dao.vehicle.VehicleProperties.*;

public interface TravelService {

    int addTrip(int id, FuelType fuelType,
                        int passengerCount, List<String> travelPlan, boolean isStandardRate);

    void addDistance(String from, String to, double distance);

    int addVehicle(FuelType fuelType, VehicleType vehicleType,
                    boolean isAC);

    double calculateTripCost(int tripId);

    void addVehiclePassengerLimit(VehicleType type, int limit);

    void addVehicleDiscount(VehicleType type, double discount);
}
