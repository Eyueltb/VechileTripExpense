package com.futureTravels.dao.city;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AllCities {
    Map<Integer,String> cities;

    public AllCities() {
        this.cities = new HashMap<>();
    }

    public int getOrAddCity(String city) {
        if(cities.values().stream().anyMatch(k->k.equals(city))) {
           for(Entry<Integer,String> theCity : cities.entrySet()) {
               if(theCity.getValue().equals(city)){
                   return theCity.getKey();
               }
           }
        }
        if(city.isEmpty()) {
          cities.put(1, city);
          return 1;
        }
        else {
            cities.put(cities.size() + 1, city);
            return cities.size();
        }
    }
}
