package com.futureTravels.service;

import com.futureTravels.dao.TravelAgencyRates;
import com.futureTravels.dao.Trip;
import com.futureTravels.dao.city.AllDistance;
import com.futureTravels.dao.vehicle.Vehicle;

import java.util.*;

import static com.futureTravels.dao.vehicle.VehicleProperties.*;

public class TravelServiceImpl implements TravelService{
    TravelAgencyRates rates;
    AllDistance allDistance;
    List<Vehicle> vehicles;
    List<Trip> trips;
    Map<VehicleType, Integer> passengerLimit;
    Map<VehicleType, Double> discounts;

    public TravelServiceImpl(double standardPetrolRate, double additionalPassengerChargers,
                             double acCharges, double dieselDiscount) {

        this.rates = new TravelAgencyRates(standardPetrolRate,additionalPassengerChargers,
               acCharges,dieselDiscount);
        this.vehicles=new ArrayList<>();
        this.allDistance=new AllDistance();
        this.trips=new ArrayList<>();
        this.passengerLimit = new HashMap<>();
        this.discounts=new HashMap<>();
    }

    @Override
    public int addTrip(int vehicleId, FuelType fuelType, int passengerCount,
                        List<String> travelPlan, boolean isStandardRate) {

       if(trips.isEmpty()) {
           trips.add(new Trip(1, this.getVehicle(vehicleId), fuelType, passengerCount, travelPlan, isStandardRate));
           return 1;
       }
       else {
           trips.add(new Trip(trips.size() + 1, this.getVehicle(vehicleId), fuelType, passengerCount, travelPlan, isStandardRate));
           return trips.size();
       }

    }

    @Override
    public void addDistance(String from, String to, double distance) {
        allDistance.addDistance(from,to,distance);
    }

    @Override
    public int addVehicle(FuelType fuelType, VehicleType vehicleType,
                           boolean isAC) {
        if(vehicles.isEmpty()){
            vehicles.add(new Vehicle(1,this.rates, fuelType, vehicleType,
                    isAC, passengerLimit.get(vehicleType), discounts.get(vehicleType)));
            return 1;
        }
        else{
            vehicles.add(new Vehicle(vehicles.size()+1, this.rates, fuelType, vehicleType,
                    isAC, passengerLimit.get(vehicleType), discounts.get(vehicleType)));
            return vehicles.size();
        }
    }

    @Override
    public double calculateTripCost(int tripId) {
        Optional<Trip> tripObject = trips.stream().filter(t -> t.getId() == tripId).findFirst();
        if (tripObject.isPresent()) {
            Trip trip = tripObject.get();
            double totalDistance = getTotalDistance(trip.getTravelPlan());
            return trip.getVehicle().getStandardRate() * totalDistance;
        }
        throw new RuntimeException("Trip not found ");
    }

    @Override
    public void addVehiclePassengerLimit(VehicleType type, int limit) {
        this.passengerLimit.put(type,limit);
    }

    @Override
    public void addVehicleDiscount(VehicleType type, double discount) {
        this.discounts.put(type, discount);
    }

    private double getTotalDistance(List<String> travelPlan){
        double totalDistance = 0;
        for (int i=0; i < travelPlan.size()-1; i++){
            String from=travelPlan.get(i);
            String to=travelPlan.get(i+1);
            double distance = allDistance.getDistanceBetweenCities(from, to);
            totalDistance += distance;
        }
        return totalDistance;
    }

    public Vehicle getVehicle(int id){
        Optional<Vehicle> v = this.vehicles.stream().filter(k -> k.getId() == id).findFirst();
        if(v.isPresent()){
            return v.get();
        }
        throw new RuntimeException("Vehicle not found");
    }
    public Trip getTrip(int id){
        Optional<Trip> t = this.trips.stream().filter(k -> k.getId() == id).findFirst();
        if(t.isPresent()){
            return t.get();
        }
        throw new RuntimeException("Trip not found");
    }
}
