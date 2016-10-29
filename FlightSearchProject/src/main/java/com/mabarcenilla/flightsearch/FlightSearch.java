package com.mabarcenilla.flightsearch;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Main class of FlightSearch package for searching the posible flights of a
 * route for the existing airlines flights and the total price following the
 * pricing rules.
 *
 * @author Miguel Barcenilla
 * @version 1.0
 */
public class FlightSearch {

    /**
     * Number of miliseconds in a day
     */
    private static final int DAY_IN_MS = 1000 * 60 * 60 * 24;

    /**
     * Manages the existing flights to search route flights
     */
    private final FlightManager flightManager;

    /**
     * Price calculator
     */
    private final PriceCalculator priceCalculator;

    /**
     * Creates a new instance of FlightSearch
     *
     * @param flightsInfo List with the information of every existing flight
     * @param infantPrices HashMap of infant prices by airline
     */
    public FlightSearch(FlightInfo[] flightsInfo, HashMap<String, Double> infantPrices) {
        flightManager = new FlightManager(flightsInfo);
        priceCalculator = new PriceCalculator(infantPrices);
    }

    /**
     * Obtains the possible routes of a flight and the total prices for the
     * indicated passengers
     *
     * @param origin IATA code of the origin of the flight
     * @param destination IATA code of the destination
     * @param departureDate Date of departure
     * @param nAdults Number of adults in the flight
     * @param nChildren Number of children in the flight
     * @param nInfants Number of infants in the flight
     * @return A String with the possible routes of a flight and the total
     * prices for the indicated passengers for every route
     */
    public String searchFlights(String origin, String destination, Date departureDate, int nAdults, int nChildren, int nInfants) {

        String result = "";
        String foundRoutes = "";

        if (origin == null || destination == null) {
            result = "* origin or destionation not selected\n";
        } else if (!(nAdults > 0 || nChildren > 0 || nInfants > 0)) {
            result = "* " + origin + " -> " + destination + "\n\n";
            result += "  no passengers selected\n";
        } else if (departureDate == null) {
            result = "* " + origin + " -> " + destination + "\n\n";
            result += "  no date selected\n";
        } else {
            Date currentDate = new Date();
            long daysLeft = (departureDate.getTime() - currentDate.getTime()) / DAY_IN_MS;
            if (daysLeft < 0) {
                result = "* " + origin + " -> " + destination + "\n\n";
                result += "  invalid date selected\n";
            } else {
                ArrayList<FlightInfo> routeFlights = flightManager.getRouteFlights(origin, destination);

                if (routeFlights == null || routeFlights.isEmpty()) {
                    result = "* " + origin + " -> " + destination + "\n\n";
                    result += "  no flights available\n";
                } else {
                    for (FlightInfo info : routeFlights) {
                        if (info != null) {
                            String routeCode = info.getRouteCode();
                            if (routeCode != null && routeCode.length() > 2) {

                                double basePrice = info.getBasePrice();
                                String airline = routeCode.substring(0, 2);

                                double priceByDate = priceCalculator.getPriceByDate(basePrice, (int) daysLeft);
                                double totalPrice = priceCalculator.getPriceByPassengers(airline, priceByDate, nAdults, nChildren, nInfants);

                                foundRoutes += "\t* " + info.getRouteCode() + ", ";
                                foundRoutes += String.format("%1$,.2f", totalPrice) + " €\n";
                            }
                        }
                    }

                    result = "*";
                    if (nAdults > 0) {
                        result += " " + nAdults + " adult" + (nAdults > 1 ? "s" : "") + ",";
                    }
                    if (nChildren > 0) {
                        result += " " + nChildren + " child" + (nChildren > 1 ? "ren" : "") + ",";
                    }
                    if (nInfants > 0) {
                        result += " " + nInfants + " infant" + (nInfants > 1 ? "s" : "") + ",";
                    }
                    result += " " + daysLeft + " day" + (daysLeft > 1 ? "s" : "") + " to the departure date,";
                    result += " flying " + origin + " -> " + destination + "\n\n";
                    result += "  flights:\n\n" + foundRoutes;
                }
            }
        }

        return result;
    }

}
