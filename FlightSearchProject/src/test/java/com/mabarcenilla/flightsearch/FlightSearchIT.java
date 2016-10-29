package com.mabarcenilla.flightsearch;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for FlightSearch class
 *
 * @author Miguel Barcenilla
 * @version 1.0
 */
public class FlightSearchIT {

    /**
     * Information of prices of infants for each airline
     */
    private static final HashMap<String, Double> infantPrices = new HashMap<String, Double>();
    /**
     * Information of the flights
     */
    private static FlightInfo[] flightsInfo;

    public FlightSearchIT() {
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

        // Information of the flights
        flightsInfo = new FlightInfo[88];
        flightsInfo[0] = new FlightInfo("CPH", "FRA", "IB2818", 186);
        flightsInfo[1] = new FlightInfo("CPH", "LHR", "U23631", 152);
        flightsInfo[2] = new FlightInfo("CDG", "MAD", "IB8482", 295);
        flightsInfo[3] = new FlightInfo("BCN", "FRA", "FR7521", 150);
        flightsInfo[4] = new FlightInfo("CPH", "FCO", "TK4667", 137);
        flightsInfo[5] = new FlightInfo("CPH", "FCO", "U24631", 268);
        flightsInfo[6] = new FlightInfo("FCO", "CDG", "VY4335", 158);
        flightsInfo[7] = new FlightInfo("LHR", "IST", "TK8891", 250);
        flightsInfo[8] = new FlightInfo("FRA", "AMS", "U24107", 237);
        flightsInfo[9] = new FlightInfo("CPH", "BCN", "U22593", 218);
        flightsInfo[10] = new FlightInfo("BCN", "IST", "VY9890", 178);
        flightsInfo[11] = new FlightInfo("AMS", "CPH", "TK4927", 290);
        flightsInfo[12] = new FlightInfo("FCO", "MAD", "BA1164", 118);
        flightsInfo[13] = new FlightInfo("CPH", "LHR", "BA7710", 138);
        flightsInfo[14] = new FlightInfo("BCN", "AMS", "U24985", 191);
        flightsInfo[15] = new FlightInfo("MAD", "CDG", "IB9961", 128);
        flightsInfo[16] = new FlightInfo("LHR", "FRA", "LH2118", 165);
        flightsInfo[17] = new FlightInfo("IST", "FRA", "IB8911", 180);
        flightsInfo[18] = new FlightInfo("AMS", "FRA", "TK2372", 197);
        flightsInfo[19] = new FlightInfo("FRA", "IST", "LH4145", 169);
        flightsInfo[20] = new FlightInfo("MAD", "CDG", "IB6112", 112);
        flightsInfo[21] = new FlightInfo("CPH", "FRA", "LH1678", 298);
        flightsInfo[22] = new FlightInfo("LHR", "CPH", "LH6620", 217);
        flightsInfo[23] = new FlightInfo("MAD", "LHR", "TK4199", 186);
        flightsInfo[24] = new FlightInfo("MAD", "CDG", "IB7403", 253);
        flightsInfo[25] = new FlightInfo("FRA", "CPH", "BA4369", 109);
        flightsInfo[26] = new FlightInfo("BCN", "MAD", "IB2171", 259);
        flightsInfo[27] = new FlightInfo("IST", "LHR", "LH6412", 197);
        flightsInfo[28] = new FlightInfo("IST", "MAD", "LH1115", 160);
        flightsInfo[29] = new FlightInfo("LHR", "LHR", "VY8162", 285);
        flightsInfo[30] = new FlightInfo("FRA", "LHR", "BA8162", 205);
        flightsInfo[31] = new FlightInfo("AMS", "FCO", "BA7610", 168);
        flightsInfo[32] = new FlightInfo("LHR", "IST", "LH1085", 148);
        flightsInfo[33] = new FlightInfo("FCO", "FRA", "U21423", 274);
        flightsInfo[34] = new FlightInfo("CPH", "MAD", "U23282", 113);
        flightsInfo[35] = new FlightInfo("CDG", "CPH", "LH5778", 263);
        flightsInfo[36] = new FlightInfo("CPH", "CDG", "BA2777", 284);
        flightsInfo[37] = new FlightInfo("BCN", "LHR", "TK4375", 208);
        flightsInfo[38] = new FlightInfo("MAD", "FCO", "LH8408", 149);
        flightsInfo[39] = new FlightInfo("AMS", "IST", "IB4563", 109);
        flightsInfo[40] = new FlightInfo("LHR", "FCO", "LH5174", 251);
        flightsInfo[41] = new FlightInfo("MAD", "BCN", "BA9569", 232);
        flightsInfo[42] = new FlightInfo("AMS", "FRA", "TK2659", 248);
        flightsInfo[43] = new FlightInfo("LHR", "CDG", "IB2771", 289);
        flightsInfo[44] = new FlightInfo("IST", "MAD", "IB8688", 150);
        flightsInfo[45] = new FlightInfo("CPH", "AMS", "TK8355", 137);
        flightsInfo[46] = new FlightInfo("FCO", "CDG", "VY2974", 111);
        flightsInfo[47] = new FlightInfo("AMS", "FRA", "LH5909", 113);
        flightsInfo[48] = new FlightInfo("CPH", "BCN", "FR7949", 176);
        flightsInfo[49] = new FlightInfo("BCN", "CPH", "U27858", 237);
        flightsInfo[50] = new FlightInfo("FRA", "AMS", "LH2320", 288);
        flightsInfo[51] = new FlightInfo("LHR", "BCN", "VY4633", 149);
        flightsInfo[52] = new FlightInfo("AMS", "IST", "IB7289", 163);
        flightsInfo[52] = new FlightInfo("FRA", "LHR", "IB9443", 254);
        flightsInfo[53] = new FlightInfo("IST", "FCO", "LH4948", 176);
        flightsInfo[54] = new FlightInfo("IST", "BCN", "TK5558", 211);
        flightsInfo[55] = new FlightInfo("BCN", "BCN", "BA9409", 215);
        flightsInfo[56] = new FlightInfo("IST", "AMS", "FR9261", 267);
        flightsInfo[57] = new FlightInfo("CDG", "IST", "IB7181", 227);
        flightsInfo[58] = new FlightInfo("LHR", "BCN", "TK1446", 217);
        flightsInfo[59] = new FlightInfo("FCO", "FRA", "TK2793", 175);
        flightsInfo[60] = new FlightInfo("AMS", "CPH", "FR1491", 284);
        flightsInfo[61] = new FlightInfo("IST", "BCN", "IB9219", 279);
        flightsInfo[62] = new FlightInfo("MAD", "AMS", "TK7871", 159);
        flightsInfo[63] = new FlightInfo("FCO", "AMS", "VY4840", 260);
        flightsInfo[64] = new FlightInfo("MAD", "FRA", "BA8982", 171);
        flightsInfo[65] = new FlightInfo("IST", "LHR", "U23526", 254);
        flightsInfo[66] = new FlightInfo("FRA", "MAD", "BA6773", 157);
        flightsInfo[67] = new FlightInfo("CDG", "CPH", "IB5257", 299);
        flightsInfo[68] = new FlightInfo("CPH", "CDG", "LH8545", 230);
        flightsInfo[69] = new FlightInfo("LHR", "AMS", "IB4737", 110);
        flightsInfo[70] = new FlightInfo("BCN", "MAD", "LH5496", 293);
        flightsInfo[71] = new FlightInfo("CDG", "LHR", "U29718", 103);
        flightsInfo[72] = new FlightInfo("LHR", "AMS", "BA9561", 253);
        flightsInfo[73] = new FlightInfo("FRA", "LHR", "TK3167", 118);
        flightsInfo[74] = new FlightInfo("IST", "FRA", "FR4727", 108);
        flightsInfo[75] = new FlightInfo("CPH", "IST", "LH6320", 115);
        flightsInfo[76] = new FlightInfo("LHR", "AMS", "BA6657", 122);
        flightsInfo[77] = new FlightInfo("LHR", "FRA", "TK5342", 295);
        flightsInfo[78] = new FlightInfo("IST", "LHR", "IB4938", 226);
        flightsInfo[79] = new FlightInfo("CDG", "BCN", "VY9791", 289);
        flightsInfo[80] = new FlightInfo("MAD", "LHR", "IB4124", 272);
        flightsInfo[81] = new FlightInfo("FRA", "MAD", "BA7842", 121);
        flightsInfo[82] = new FlightInfo("AMS", "FCO", "VY5092", 178);
        flightsInfo[83] = new FlightInfo("CDG", "LHR", "BA9813", 171);
        flightsInfo[84] = new FlightInfo("FRA", "IST", "BA2421", 226);
        flightsInfo[85] = new FlightInfo("IST", "CPH", "U28059", 262);
        flightsInfo[86] = new FlightInfo("MAD", "AMS", "LH7260", 191);
        flightsInfo[87] = new FlightInfo("CDG", "CPH", "TK2044", 186);

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
     * Test of searchFlights method, of class FlightSearch.
     */
    @Test
    public void testGetFlightRoutes() {
        System.out.println("searchFlights");

        FlightSearch instance1 = new FlightSearch(flightsInfo, infantPrices);

        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, 31);
        Date departureDate1 = calendar.getTime();

        calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, 15);
        Date departureDate2 = calendar.getTime();

        calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, 2);
        Date departureDate3 = calendar.getTime();

        calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date departureDate4 = calendar.getTime();

        String result1 = instance1.searchFlights("AMS", "FRA", departureDate1, 1, 0, 0);
        System.out.println(result1);
        String expResult1 = "* 1 adult, 31 days to the departure date, flying AMS -> FRA\n\n"
                + "  flights:\n\n"
                + "	* TK2372, 157,60 €\n"
                + "	* TK2659, 198,40 €\n"
                + "	* LH5909, 90,40 €\n";
        assertEquals("searchFlights, example 1", expResult1, result1);

        String result2 = instance1.searchFlights("LHR", "IST", departureDate2, 2, 1, 1);
        System.out.println(result2);
        String expResult2 = "* 2 adults, 1 child, 1 infant, 15 days to the departure date, flying LHR -> IST\n\n"
                + "  flights:\n\n"
                + "	* TK8891, 806,00 €\n"
                + "	* LH1085, 481,19 €\n";
        assertEquals("searchFlights, example 2", expResult2, result2);

        String result3 = instance1.searchFlights("BCN", "MAD", departureDate3, 1, 2, 0);
        System.out.println(result3);
        String expResult3 = "* 1 adult, 2 children, 2 days to the departure date, flying BCN -> MAD\n\n"
                + "  flights:\n\n"
                + "	* IB2171, 909,09 €\n"
                + "	* LH5496, 1.028,43 €\n";
        assertEquals("searchFlights, example 3", expResult3, result3);

        String result4 = instance1.searchFlights("CDG", "FRA", departureDate1, 1, 0, 0);
        System.out.println(result4);
        String expResult4 = "* CDG -> FRA\n\n"
                + "  no flights available\n";
        assertEquals("searchFlights, example 4", expResult4, result4);

        String result5 = instance1.searchFlights(null, null, departureDate1, 1, 0, 0);
        String expResult5 = "* origin or destionation not selected\n";
        assertEquals("searchFlights, origin/destionation null", expResult5, result5);

        String result6 = instance1.searchFlights("AMS", "FRA", null, 1, 0, 0);
        String expResult6 = "* AMS -> FRA\n\n"
                + "  no date selected\n";
        assertEquals("searchFlights, no date selected", expResult6, result6);

        String result7 = instance1.searchFlights("AMS", "FRA", departureDate4, 1, 0, 0);
        String expResult7 = "* AMS -> FRA\n\n"
                + "  invalid date selected\n";
        assertEquals("searchFlights, invalid date", expResult7, result7);

        FlightSearch instance2 = new FlightSearch(null, null);
        String result8 = instance2.searchFlights("AMS", "FRA", departureDate1, 1, 1, 1);
        String expResult8 = "* AMS -> FRA\n\n"
                + "  no flights available\n";
        assertEquals("searchFlights, null flights data", expResult8, result8);

    }

}
