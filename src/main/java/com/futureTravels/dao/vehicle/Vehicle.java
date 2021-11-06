package com.futureTravels.dao.vehicle;

import com.futureTravels.dao.TravelAgencyRates;
import lombok.Data;

import static com.futureTravels.dao.vehicle.VehicleProperties.*;
import static com.futureTravels.dao.vehicle.VehicleProperties.VehicleType.*;

@Data
public class Vehicle {
    int id;
    TravelAgencyRates rates;
    FuelType fuelType;
    VehicleType vehicleType;
    double standardRate;
    boolean isAC;
    int passengerLimit;
    double standardDiscount;

    public Vehicle(int id, TravelAgencyRates rates, FuelType fuelType, VehicleType vehicleType,
                   boolean isAC, int passengerLimit, double standardDiscount) {
        this.id = id;
        this.rates = rates;
        this.fuelType = fuelType;
        this.vehicleType = vehicleType;
        this.isAC = isAC;
        this.passengerLimit=passengerLimit;
        this.standardDiscount=standardDiscount;

        calculateFuelDiscount();
        calculateStandardRate();
        calculateAcCharges();
    }

    private void calculateFuelDiscount(){
        if(fuelType==FuelType.DIESEL){
            this.standardRate = this.rates.getStandardPetrolRate() - this.rates.getDieselDiscount();
        }
    }

    public void calculateStandardRate(){
       if(this.vehicleType == BUS){
           this.standardRate = this.standardRate - this.standardDiscount/ 100 * this.standardRate;
       }
    }

    private void calculateAcCharges(){
        if(this.isAC){
            this.standardRate = this.standardRate + this.rates.getAcCharges();
        }
    }

}
