/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex;

import java.util.ArrayList;
import java.util.Date;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ehn19
 */
public class DateFormatterTest {
    
    /*
    !!!!!!!!!!!! Lav en test der mocker date 
    så vi kan teste den eksakte string!!!!!!!
    
    */
    @Test
    public void testGetFormattedDateWithList() throws JokeException {
        String testStrings[] = {"Europe/Copenhagen", "PRT"};
        ArrayList<String> ar = new ArrayList();
        Date date = new Date();
        DateFormatter df = new DateFormatter();
        
        for (String tmp : testStrings) {
            ar.add(df.getFormattedDate(date, tmp));
        }
        for (String string : ar) {
            assertNotNull(string);
            Assert.assertThat(string.length() > 1, is(true));
        }
    }
    
    @Test(expected = JokeException.class)
    public void testGetFormattedDateWithEx() throws JokeException {
        System.out.println("Get invalid formatted data");
        Date date = new Date();
        DateFormatter dateF = new DateFormatter();
        dateF.getFormattedDate(date, "ThisIsNotLegal");
    }
}
