package com.pricingengine.CyclePricingEngine;

import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */

public class PricingEngineMainTest 
		extends TestCase
{
	
	
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PricingEngineMainTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PricingEngineMainTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
