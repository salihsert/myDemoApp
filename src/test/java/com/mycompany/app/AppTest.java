package com.mycompany.app;

import java.util.Arrays;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void test1()
    {
        int ar1[]={1,3,5,7,9};
        int ar2[]={0,2,4,6,8};

        assertTrue(Arrays.equals(Arrays.copyOfRange(ar1,0,3),Arrays.copyOfRange(new App().replace(ar1,ar2,0,2),0,3)));
    }
    public void test2()
    {
        int ar1[]={1,3,5,7,9};
        int ar2[]={0,2,4,6,8};

        assertNull(new App().replace(ar1,ar2,0,5));
    }
    public void test3()
    {
        int ar1[]={1,3,5,7,9};
        int ar2[]={0,2,4,6,8};

        assertNull(new App().replace(ar1,ar2,8,9));
    }
    public void test4()
    {
        int ar1[]={};
        int ar2[]={50,100,150};
        assertNull(new App().replace(ar1,ar2,0,0));
    }
    public void test5() {
        int ar1[]={};
        int ar2[]={};
        assertNull(new App().replace(ar1,ar2,0,0));
    }
}
