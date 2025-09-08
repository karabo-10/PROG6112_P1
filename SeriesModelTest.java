package com.mycompany.prog_part1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for SeriesModel.
 */
public class SeriesModelTest {
    
    private SeriesModel instance;

    public SeriesModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new SeriesModel("123", "MySeries", 10, 13);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test SearchSeries (example: number of episodes)
     */
    @Test
    public void testSearchSeries() {
        System.out.println("SearchSeries");
        int expResult = 13;  // matches constructor value
        int result = instance.getNumberOfEpisodes();
        assertEquals(expResult, result);
    }

    /**
     * Test setAgeRestriction method.
     */
    @Test
    public void testSetAgeRestriction() {
        System.out.println("setAgeRestriction");
        int newAge = 18;
        instance.setAgeRestriction(newAge);
        assertEquals(newAge, instance.getAgeRestriction());
    }

    /**
     * Test UpdateSeries method.
     * (Simulating an update by changing name and episodes)
     */
    @Test
    public void testUpdateSeries_validUpdate() {
        System.out.println("UpdateSeries");
        instance.setSeriesName("UpdatedSeries");
        instance.setNumberOfEpisodes(20);

        assertEquals("UpdatedSeries", instance.getSeriesName());
        assertEquals(20, instance.getNumberOfEpisodes());
    }
    
    /**
     * Test DeleteSeries (simulate by setting fields to null/0).
     */
    @Test
    public void testDeleteSeries() {
        System.out.println("DeleteSeries");
        instance.setSeriesName(null);
        instance.setNumberOfEpisodes(0);

        assertNull(instance.getSeriesName());
        assertEquals(0, instance.getNumberOfEpisodes());
    }

    /**
     * Test toString method with expected format.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String result = instance.toString();
        assertTrue(result.contains("123"));
        assertTrue(result.contains("MySeries"));
        assertTrue(result.contains("10"));
        assertTrue(result.contains("13"));
    }
}