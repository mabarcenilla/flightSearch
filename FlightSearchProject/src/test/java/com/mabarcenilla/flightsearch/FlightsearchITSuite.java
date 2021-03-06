package com.mabarcenilla.flightsearch;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Tests for flightsearch package
 * @author Miguel Barcenilla
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.mabarcenilla.flightsearch.PriceCalculatorIT.class, com.mabarcenilla.flightsearch.FlightInfoIT.class, com.mabarcenilla.flightsearch.FlightManagerIT.class, com.mabarcenilla.flightsearch.FlightSearchIT.class})
public class FlightsearchITSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
