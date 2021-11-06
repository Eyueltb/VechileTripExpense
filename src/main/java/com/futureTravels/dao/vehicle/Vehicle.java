package com.futureTravels.dao.vehicle;

import com.futureTravels.dao.TravelAgencyRates;

import static com.futureTravels.dao.vehicle.VehicleProperties.*;
import static com.futureTravels.dao.vehicle.VehicleProperties.VehicleType.*;

public class Vehicle {

    int id;
    TravelAgencyRates rates;
    FuelType fuelType;
    VehicleType vehicleType;
    double standardRate;
    int passengers;
    boolean isAC;

    public Vehicle(int id, TravelAgencyRates rates, FuelType fuelType, VehicleType vehicleType,
                   int passengers, boolean isAC) {
        this.id = id;
        this.rates = rates;
        this.fuelType = fuelType;
        this.vehicleType = vehicleType;
        this.passengers = passengers;
        this.isAC = isAC;

        calculateFuelDiscount();
        calculateStandardRate();
        calculateExtraPassengerCharges();
    }

    private void calculateFuelDiscount(){
        if(fuelType==FuelType.DIESEL){
            this.standardRate = this.rates.getStandardPetrolRate() - this.rates.getDieselDiscount();
        }
    }

    public void calculateStandardRate(){
       if(this.vehicleType == BUS){
           this.standardRate = this.standardRate - this.rates.getStandardDiscount() / 100 * this.standardRate;
       }
    }

    private void calculateAcCharges(){
        if(this.isAC){
            this.standardRate = this.standardRate + this.rates.getAcCharges();
        }
    }
    public void calculateExtraPassengerCharges() { //done after we apply discount on standard rate
        if( this.passengers > this.rates.getPassengerLimit()){
            this.standardRate = this.rates.getAdditionalPassengerChargers()
                    * (this.passengers - this.rates.getPassengerLimit())
                    + this.standardRate;
        }
    }

}
