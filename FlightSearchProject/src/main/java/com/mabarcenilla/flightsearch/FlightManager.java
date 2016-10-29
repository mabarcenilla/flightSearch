package com.mabarcenilla.flightsearch;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Manages the existing flights to search route flights
 *
 * @author Miguel Barcenilla
 * @version 1.0
 */
public class FlightManager {

    /**
     * HashMap with the matching flights for every route
     */
    private final HashMap<String, ArrayList<FlightInfo>> flights = new HashMap<String, ArrayList<FlightInfo>>();

    /**
     * Creates a new instance of FlightManager
     *
     * @param flightsInfo List with the information of every existing flight
     */
    public FlightManager(FlightInfo[] flightsInfo) {
        setFlights(flightsInfo);
    }

    /**
     * Obtains the possible flights of a route
     *
     * @param origin IATA code of the origin of the flight
     * @param destination IATA code of the destination
     * @return A List with the possible flights for the route
     */
    public ArrayList<FlightInfo> getRouteFlights(String origin, String destination) {
        String key = origin + destination;
        return flights.get(key);
    }

    /**
     * Builds a HashMap with the matching flights for every route for a fast
     * search
     *
     * @param flightsInfo List with the information of every existing flight
     */
    private void setFlights(FlightInfo[] flightsInfo) {
        if (flightsInfo != null) {
            for (FlightInfo info : flightsInfo) {
                if (info != null) {
                    String key = info.getOrigin() + info.getDestination();
                    ArrayList<FlightInfo> routeFlights = flights.get(key);
                    if (routeFlights == null) {
                        // First flight for the route, adding list of flights
                        routeFlights = new ArrayList<FlightInfo>();
                        flights.put(key, routeFlights);
                    }
                    // Adding flight for the route
                    routeFlights.add(info);
                }
            }
        }
    }

}
