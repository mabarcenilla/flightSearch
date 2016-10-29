package flightsearch;

import java.util.HashMap;

/**
 * Calculator of the total price of a flight following the price rules of days
 * to departure date and passenger types.
 *
 * @author Miguel Barcenilla
 * @version 1.0
 */
class PriceCalculator {

    /**
     * Rate of the price for children
     */
    private final double CHILD_RATE = 1 - 0.33;
    /**
     * Information of prices of infants for each airline
     */
    private final HashMap<String, Double> infantPrices;

    /**
     * Creates a new instance of PriceCalculator
     *
     * @param infantPrices HashMap of infant prices by airline
     */
    public PriceCalculator(HashMap<String, Double> infantPrices) {
        this.infantPrices = infantPrices;
    }

    /**
     * Calculates de price of a flight following the price rules of days to
     * departure:
     *
     * | days prior to the departure date | % of the base price |
     * |----------------------------------|---------------------|
     * | more than 30                     | 80%                 |
     * | 30 - 16                          | 100%                |
     * | 15 - 3                           | 120%                |
     * | less that 3                      | 150%                |
     * 
     * @param basePrice Base price of the flight
     * @param departureDate Date of departure
     * @return resulting price or -1 if there is error in the input date
     */
    public double getPriceByDate(double basePrice, int daysLeft) {

        double result = -1;

        if (daysLeft >= 31) {
            result = basePrice * 0.8;
        } else if (daysLeft >= 16) {
            result = basePrice;
        } else if (daysLeft >= 3) {
            result = basePrice * 1.2;
        } else if (daysLeft >= 0) {
            result = basePrice * 1.5;
        }
        return result;
    }

    /**
     * Calculates de total price of a flight according to the passenger types
     * pricing rules:
     *
     * | passenger type | price                                                                                          |
     * |----------------|----------------------------------------|
     * | adult          | full price                             |
     * | child          | 33% discount                           |
     * | infant         | fixed price depending on the airline.  |
     * 
     * @param airline Airline identifier
     * @param price Price rated following the price rules of days to departure
     * @param nAdults Number of adults in the flight
     * @param nChildren Number of children in the flight
     * @param nInfants Number of infants in the flight
     * @return resulting price or -1 if there is error in the input data
     */
    public double getPriceByPassengers(String airline, double price, int nAdults, int nChildren, int nInfants) {

        double result = 0;

        if (nAdults >= 0 && nChildren >= 0 && nInfants >= 0) {
            if (nAdults > 0) {
                result = price * nAdults;
            }
            if (nChildren > 0) {
                result += price * CHILD_RATE * nChildren;
            }
            if (nInfants > 0) {
                if (infantPrices != null && airline != null) {
                    Double infantPrice = infantPrices.get(airline);
                    if (infantPrice != null) {
                        result += infantPrice * nInfants;
                    } else {
                        // Error, infant price for airline not found
                        result = -1;
                    }
                } else {
                    // Error, cannot calculate price with infants
                    result = -1;
                }
            }
        } else {
            // Error, passengers must be positive
            result = -1;
        }

        return result;
    }

}
