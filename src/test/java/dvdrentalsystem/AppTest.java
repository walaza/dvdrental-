/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdrentalsystem;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author bulelani
 */
public class AppTest extends TestCase{
    
    public AppTest( String testName )
    {
        super( testName );
    }
    
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    
    public void testApp()
    {
        assertTrue( true );
    }
}
