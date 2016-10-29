package flightsearch;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for PriceCalculator class
 *
 * @author Miguel Barcenilla
 * @version 1.0
 */
public class PriceCalculatorIT {

    /**
     * Information of prices of infants for each airline
     */
    private static final HashMap<String, Double> infantPrices = new HashMap<String, Double>();

    public PriceCalculatorIT() {
    }

    @BeforeClass
    public static void setUpClass() {

        // Airlines with infant prices
        infantPrices.put("IB", (double) 10);
        infantPrices.put("BA", (double) 15);
        infantPrices.put("LH", (double) 7);
        infantPrices.put("FR", (double) 20);
        infantPrices.put("VY", (double) 10);
        infantPrices.put("TK", (double) 5);
        infantPrices.put("U2", 19.90);

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
     * Test of getPriceByDate method, of class PriceCalculator.
     */
    @Test
    public void testGetPriceByDate() {
        System.out.println("getPriceByDate");

        PriceCalculator instance = new PriceCalculator(null);

        double basePrice = 186;

        double expResult1 = -1;
        double expResult2 = 279;
        double expResult3 = 279;
        double expResult4 = 223.2;
        double expResult5 = 223.2;
        double expResult6 = 186;
        double expResult7 = 186;
        double expResult8 = 148.8;

        double result1 = instance.getPriceByDate(basePrice, -1);
        assertEquals("getPriceByDate with negative days to departure", expResult1, result1, 0.0);

        double result2 = instance.getPriceByDate(basePrice, 0);
        assertEquals("getPriceByDate with 0 days to departure", expResult2, result2, 0.0);

        double result3 = instance.getPriceByDate(basePrice, 2);
        assertEquals("getPriceByDate with 2 days to departure", expResult3, result3, 0.0);

        double result4 = instance.getPriceByDate(basePrice, 3);
        assertEquals("getPriceByDate with 3 days to departure", expResult4, result4, 0.0);

        double result5 = instance.getPriceByDate(basePrice, 15);
        assertEquals("getPriceByDate with 15 days to departure", expResult5, result5, 0.0);

        double result6 = instance.getPriceByDate(basePrice, 16);
        assertEquals("getPriceByDate with 16 days to departure", expResult6, result6, 0.0);

        double result7 = instance.getPriceByDate(basePrice, 30);
        assertEquals("getPriceByDate with 30 days to departure", expResult7, result7, 0.0);

        double result8 = instance.getPriceByDate(basePrice, 31);
        assertEquals("getPriceByDate with 31 days to departure", expResult8, result8, 0.0);

    }

    /**
     * Test of getPriceByPassengers method, of class PriceCalculator.
     */
    @Test
    public void testGetPriceByPassengers() {
        System.out.println("getPriceByPassengers");

        double price = 223.2;

        PriceCalculator instance1 = new PriceCalculator(null);
        PriceCalculator instance2 = new PriceCalculator(infantPrices);

        double expResult1 = 0.0;
        double result1 = instance1.getPriceByPassengers(null, price, 0, 0, 0);
        assertEquals("getPriceByPassengers without passengers", expResult1, result1, 0.001);

        double expResult2 = 446.4;
        double result2 = instance1.getPriceByPassengers(null, price, 2, 0, 0);
        assertEquals("getPriceByPassengers with 2 adults", expResult2, result2, 0.001);

        double expResult3 = -1;
        double result3 = instance1.getPriceByPassengers(null, price, -2, 0, 0);
        assertEquals("getPriceByPassengers with negative adults", expResult3, result3, 0.001);

        double expResult4 = 299.088;
        double result4 = instance1.getPriceByPassengers(null, price, 0, 2, 0);
        assertEquals("getPriceByPassengers with 2 children", expResult4, result4, 0.001);

        double expResult5 = -1;
        double result5 = instance1.getPriceByPassengers(null, price, 0, -2, 0);
        assertEquals("getPriceByPassengers with negative children", expResult5, result5, 0.001);

        double expResult6 = -1;
        double result6 = instance1.getPriceByPassengers("U2", price, 0, 0, 2);
        assertEquals("getPriceByPassengers with infants without infant prices", expResult6, result6, 0.001);

        double expResult7 = -1;
        double result7 = instance2.getPriceByPassengers(null, price, 0, 0, 2);
        assertEquals("getPriceByPassengers with infants without airline expecification", expResult7, result7, 0.001);

        double expResult8 = -1;
        double result8 = instance2.getPriceByPassengers("XX", price, 0, 0, 2);
        assertEquals("getPriceByPassengers with infants with airline not found", expResult8, result8, 0.001);

        double expResult9 = 39.80;
        double result9 = instance2.getPriceByPassengers("U2", price, 0, 0, 2);
        assertEquals("getPriceByPassengers with 2 infants", expResult9, result9, 0.001);

        double expResult10 = -1;
        double result10 = instance2.getPriceByPassengers("U2", price, 0, 0, -2);
        assertEquals("getPriceByPassengers with negative infants", expResult10, result10, 0.001);

        double expResult11 = 785.288;
        double result11 = instance2.getPriceByPassengers("U2", price, 2, 2, 2);
        assertEquals("getPriceByPassengers with mixed passengers", expResult11, result11, 0.001);

    }

}
