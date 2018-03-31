/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex;

import interfaces.IDateFormatter;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*; 
import static org.hamcrest.CoreMatchers.*; 

/**
 *
 * @author ehn19
 */
@RunWith(MockitoJUnitRunner.class)
public class JokeFetcherTest {
    

    @Mock
    IDateFormatter dateFormatter;
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getAvailableTypes method, of class JokeFetcher.
     */
  
    
    @Test
    public void testGetAvailableTypes() {
        System.out.println("getAvailableTypes");
        JokeFetcher instance = new JokeFetcher(dateFormatter);
        List<String> expected = Arrays.asList("eduprog", "chucknorris", "moma", "tambal");
        List<String> result = instance.getAvailableTypes();
        assertEquals(expected, result);
    }

    /**
     * Test of isStringValid method, of class JokeFetcher.
     */
//    @Test
//    public void testIsStringValid() {
//        System.out.println("isStringValid");
//        String jokeTokens = "";
//        JokeFetcher instance = new JokeFetcher(dateFormatter);
//        boolean expResult = false;
//        boolean result = instance.isStringValid(jokeTokens);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getJokes method, of class JokeFetcher.
//     */
//    @Test
//    public void testGetJokes() throws Exception {
//        System.out.println("getJokes");
//        String jokesToFetch = "";
//        String timeZone = "";
//        JokeFetcher instance = new JokeFetcher(dateFormatter);
//        Jokes expResult = null;
//        Jokes result = instance.getJokes(jokesToFetch, timeZone);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of main method, of class JokeFetcher.
//     */
//    @Test
//    public void testMain() throws Exception {
//        System.out.println("main");
//        String[] args = null;
//        JokeFetcher.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
