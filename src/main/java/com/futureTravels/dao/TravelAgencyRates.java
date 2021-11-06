package com.futureTravels.dao;

import lombok.Data;

@Data
public class TravelAgencyRates {
    double standardPetrolRate;
    double additionalPassengerChargers;
    double acCharges;
    double dieselDiscount;

    public TravelAgencyRates(double standardPetrolRate, double additionalPassengerChargers,
                        double acCharges, double dieselDiscount) {
        this.standardPetrolRate = standardPetrolRate;
        this.additionalPassengerChargers = additionalPassengerChargers;
        this.acCharges = acCharges;
        this.dieselDiscount = dieselDiscount;
    }

}
