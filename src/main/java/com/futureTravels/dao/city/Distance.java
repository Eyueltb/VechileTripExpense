package com.futureTravels.dao.city;

public class Distance {
    int from;
    int to;
    double distance;

    public Distance(int from, int to, double distance) {
        this.from = from;
        this.to = to;
        this.distance = distance;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public double getDistance() {
        return distance;
    }
}
