package com.futureTravels.dao;

public class TravelAgencyRates {
    int standardPetrolRate;
    double additionalPassengerChargers;
    int passengerLimit;
    double standardDiscount;
    double acCharges;
    double dieselDiscount;

    public TravelAgencyRates(int standardPetrolRate, double additionalPassengerChargers, int passengerLimit,
                             double standardDiscount, double acCharges, double dieselDiscount) {
        this.standardPetrolRate = standardPetrolRate;
        this.additionalPassengerChargers = additionalPassengerChargers;
        this.passengerLimit = passengerLimit;
        this.standardDiscount = standardDiscount;
        this.acCharges = acCharges;
        this.dieselDiscount = dieselDiscount;
    }

    public int getStandardPetrolRate() {
        return standardPetrolRate;
    }

    public double getAdditionalPassengerChargers() {
        return additionalPassengerChargers;
    }

    public int getPassengerLimit() {
        return passengerLimit;
    }

    public double getStandardDiscount() {
        return standardDiscount;
    }

    public double getAcCharges() {
        return acCharges;
    }

    public double getDieselDiscount() {
        return dieselDiscount;
    }
}
