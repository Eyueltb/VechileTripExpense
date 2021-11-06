package com.futureTravels.dao;

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

    public double getStandardPetrolRate() {
        return standardPetrolRate;
    }

    public double getAdditionalPassengerChargers() {
        return additionalPassengerChargers;
    }

    public double getAcCharges() {
        return acCharges;
    }

    public double getDieselDiscount() {
        return dieselDiscount;
    }
}
