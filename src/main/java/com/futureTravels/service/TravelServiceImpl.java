package com.futureTravels.service;

import com.futureTravels.dao.TravelAgencyRates;
import com.futureTravels.dao.Trip;
import com.futureTravels.dao.city.AllDistance;
import com.futureTravels.dao.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

import static com.futureTravels.dao.vehicle.VehicleProperties.*;

public class TravelServiceImpl implements TravelService{
    TravelAgencyRates travelAgencyRates;
    AllDistance allDistance;
    List<Vehicle> vehicles;
    Trip trip;

    public TravelServiceImpl(int standardPetrolRate, double additionalPassengerChargers, int passengerLimit,
                             double standardDiscount, double acCharges, double dieselDiscount) {

        this.travelAgencyRates = new TravelAgencyRates(standardPetrolRate,additionalPassengerChargers,passengerLimit,
                standardDiscount,acCharges,dieselDiscount);
        vehicles=new ArrayList<>();
        allDistance=new AllDistance();


    }

    @Override
    public void setUpTravelAgency(int standardPetrolRate, double additionalPassengerChargers,
                                  int passengerLimit, double standardDiscount, double acCharges, double dieselDiscount) {

    }

    @Override
    public void addTrip(Vehicle vehicle, FuelType fuelType, int passengerCount,
                        List<String> travelPlan, boolean isStandardRate) {
        //calculate id;
        trip=new Trip(1, vehicle, fuelType, passengerCount, travelPlan, isStandardRate);
   
    }

    @Override
    public void addDistance(String from, String to, double distance) {
        allDistance.addDistance(from,to,distance);
    }

    @Override
    public double calculateTripCost(int tripId) {
        return 0;
    }
}
