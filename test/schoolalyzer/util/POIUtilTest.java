/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package schoolalyzer.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author uli
 */
public class POIUtilTest {

    public POIUtilTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of generateColumnName method, of class POIUtil.
     */
    @Test
    public void testGenerateColumnName() {
        System.out.println("Testing generateColumnName...");
        assertEquals("A", POIUtil.generateColumnName(0));
        assertEquals("B", POIUtil.generateColumnName(1));
        assertEquals("AA", POIUtil.generateColumnName(26));
        assertEquals("AB", POIUtil.generateColumnName(27));
        assertEquals("BA", POIUtil.generateColumnName(52));
    }
}