package flightsearch;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for FlightInfo class
 *
 * @author Miguel Barcenilla
 * @version 1.0
 */
public class FlightInfoIT {

    public FlightInfoIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getOrigin method, of class FlightInfo.
     */
    @Test
    public void testGetOrigin() {

        System.out.println("getOrigin");
        String origin1 = null;
        String origin2 = "MAD";
        String destination = null;
        String routeCode = null;
        double basePrice = 0;
        FlightInfo instance1 = new FlightInfo(origin1, destination, routeCode, basePrice);
        FlightInfo instance2 = new FlightInfo(origin2, destination, routeCode, basePrice);

        String result1 = instance1.getOrigin();
        assertNull("getOrigin, null value", result1);

        String result2 = instance2.getOrigin();
        assertEquals("getOrigin, not null value", "MAD", result2);

    }

    /**
     * Test of getDestination method, of class FlightInfo.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");

        String origin = null;
        String destination1 = null;
        String destination2 = "MAD";
        String routeCode = null;
        double basePrice = 0;
        FlightInfo instance1 = new FlightInfo(origin, destination1, routeCode, basePrice);
        FlightInfo instance2 = new FlightInfo(origin, destination2, routeCode, basePrice);

        String result1 = instance1.getDestination();
        assertNull("getDestination, null value", result1);

        String result2 = instance2.getDestination();
        assertEquals("getDestination, not null value", "MAD", result2);
    }

    /**
     * Test of getRouteCode method, of class FlightInfo.
     */
    @Test
    public void testGetRouteCode() {
        System.out.println("getRouteCode");

        String origin = null;
        String destination = null;
        String routeCode1 = null;
        String routeCode2 = "TK4667";
        double basePrice = 0;
        FlightInfo instance1 = new FlightInfo(origin, destination, routeCode1, basePrice);
        FlightInfo instance2 = new FlightInfo(origin, destination, routeCode2, basePrice);

        String result1 = instance1.getRouteCode();
        assertNull("getRouteCode, null value", result1);

        String result2 = instance2.getRouteCode();
        assertEquals("getRouteCode, not null value", "TK4667", result2);
    }

    /**
     * Test of getBasePrice method, of class FlightInfo.
     */
    @Test
    public void testGetBasePrice() {
        System.out.println("getBasePrice");
        
        String origin = null;
        String destination = null;
        String routeCode = null;
        double basePrice = 1.7;
        FlightInfo instance = new FlightInfo(origin, destination, routeCode, basePrice);
        
        double expResult = 1.7;
        double result = instance.getBasePrice();
        assertEquals("getBasePrice, double value", expResult, result, 0.0);
    }

}
