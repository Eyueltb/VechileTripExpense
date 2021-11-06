package com.futureTravels.dao.city;


import lombok.Data;

@Data
public class Distance {
    int from;
    int to;
    double distance;

    public Distance(int from, int to, double distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

}
