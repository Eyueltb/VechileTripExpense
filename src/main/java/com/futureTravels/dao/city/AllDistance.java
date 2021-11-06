package com.futureTravels.dao.city;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AllDistance {
    List<Distance> distanceList;
    AllCities allCities;

    public AllDistance( ) {
        this.distanceList = new ArrayList<>();
        this.allCities = new AllCities();
    }

    public double getDistanceBetweenCities(String from, String to){
        int fromId=allCities.getOrAddCity(from);
        int toId=allCities.getOrAddCity(to);
        return  getDistanceBetweenCities(fromId,toId);
    }

    public Double getDistanceBetweenCities(int from, int to){
        Optional<Distance> distance = distanceList.stream().filter(d -> (d.getFrom() == from && d.getTo() == to) || (d.getFrom() == to && d.getTo() == from)).findFirst();
        if(distance.isPresent()){
            return distance.get().getDistance();
        }
        return null;
    }

    public void addDistance(String from, String to, double distance ){
        int fromCity=allCities.getOrAddCity(from);
        int toCity=allCities.getOrAddCity(to);
        if(getDistanceBetweenCities(fromCity,toCity) == null){
            this.distanceList.add(new Distance(fromCity, toCity, distance));
        }

    }
}
