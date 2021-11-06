package com.futureTravels.service;

import com.futureTravels.dao.vehicle.Vehicle;
import com.futureTravels.dao.vehicle.VehicleProperties;

import java.util.List;

public interface TravelService {

    void setUpTravelAgency(int standardPetrolRate, double additionalPassengerChargers, int passengerLimit,
                                  double standardDiscount, double acCharges, double dieselDiscount);

    void addTrip(Vehicle vehicle, VehicleProperties.FuelType fuelType,
                        int passengerCount, List<String> travelPlan, boolean isStandardRate);

    void addDistance(String from, String to, double distance);

    double calculateTripCost(int tripId);
}
