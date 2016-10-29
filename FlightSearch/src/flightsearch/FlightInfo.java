package flightsearch;

/**
 * Information of a flight route.
 *
 * @author Miguel Barcenilla
 * @version 1.0
 */
public class FlightInfo {

    /**
     * Origin of the flight
     */
    private final String origin;
    /**
     * Destination of the flight
     */
    private final String destination;
    /**
     * Route code of the flight
     */
    private final String routeCode;
    /**
     * Base price of the flight
     */
    private final double basePrice;

    /**
     * Creates a new instance of FlightInfo
     *
     * @param origin IATA code of the origin of the flight
     * @param destination IATA code of the destination
     * @param routeCode Route code
     * @param basePrice Base price
     */
    public FlightInfo(String origin, String destination, String routeCode, double basePrice) {
        this.origin = origin;
        this.destination = destination;
        this.routeCode = routeCode;
        this.basePrice = basePrice;
    }

    /**
     * Returns the IATA code origin of the flight
     *
     * @return Origin IATA code
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Returns the IATA code destination of the flight
     *
     * @return Destination IATA code
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Returns the route code of the flight
     *
     * @return Route code
     */
    public String getRouteCode() {
        return routeCode;
    }

    /**
     * Returns the base price of the flight
     *
     * @return Base price
     */
    public double getBasePrice() {
        return basePrice;
    }

}
