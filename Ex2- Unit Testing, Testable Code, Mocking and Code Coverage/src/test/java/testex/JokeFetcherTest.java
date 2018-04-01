/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex;

import interfaces.IDateFormatter;
import interfaces.IFetcherFactory;
import interfaces.IJokeFetcher;
import java.util.Arrays;
import java.util.List;
import jokes.ChuckNorris;
import jokes.EduJoke;
import jokes.Moma;
import jokes.Tambal;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.given;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author ehn19
 */
@RunWith(MockitoJUnitRunner.class)
public class JokeFetcherTest {

    private JokeFetcher jokeFetcher;

    @Mock
    private IDateFormatter dateFormatter;

    @Mock
    IFetcherFactory factory;

    @Mock
    List<IJokeFetcher> results;

    @Mock
    EduJoke eduJoke;

    @Mock
    ChuckNorris chuckNorris;

    @Mock
    Moma moma;

    @Mock
    Tambal tambal;

    @Before
    public void before() {
        List<IJokeFetcher> fetchers = Arrays.asList(eduJoke, chuckNorris, moma, tambal);
        when(factory.getJokeFetchers("eduprog,chucknorris,moma,tambal")).thenReturn(fetchers);
        List<String> types = Arrays.asList("eduprog", "chucknorris", "moma", "tambal");
        when(factory.getAvailableTypes()).thenReturn(types);
        jokeFetcher = new JokeFetcher(dateFormatter, factory);
    }

    /**
     * Test of getAvailableTypes method, of class JokeFetcher.
     */
    @Test
    public void testGetAvailableTypes() {
        System.out.println("getAvailableTypes");
        List<String> list = factory.getAvailableTypes();
        List<String> expected = Arrays.asList("eduprog", "chucknorris", "moma", "tambal");

        assertThat(list.size(), is(4));
        assertThat(list, is(expected));
    }

    /**
     * Test of isStringValid method, of class JokeFetcher.
     */
    @Test
    public void testIsStringValidTrue() {
        System.out.println("isStringValid expected to be true");
        String jokeTokens = "eduprog,chucknorris,moma,tambal";
        boolean expResult = true;
        boolean result = jokeFetcher.isStringValid(jokeTokens);
        assertThat(expResult, is(result));
    }

    @Test
    public void testIsStringValidFalse() {
        System.out.println("isStringValid expected to be false");
        String jokeTokens = "eduprog1.chucknorris1,moma1,tambal1";
        boolean expResult = false;
        boolean result = jokeFetcher.isStringValid(jokeTokens);
        assertThat(expResult, is(result));
    }

    /**
     * Test of getJokes method, of class JokeFetcher.
     *
     * @throws testex.JokeException
     */

    @Test
    public void testGetJokesState() throws JokeException {
        System.out.println("testGetJokes state based");
        given(dateFormatter.getFormattedDate(eq("Europe/Copenhagen"), anyObject())).willReturn("31 mar. 2018 11:08 PM");
        assertThat(jokeFetcher.getJokes("eduprog,chucknorris,moma,tambal", "Europe/Copenhagen").getTimeZoneString(), is("31 mar. 2018 11:08 PM"));

        verify(dateFormatter, times(1)).getFormattedDate(eq("Europe/Copenhagen"), anyObject());

    }

    @Test(expected = JokeException.class)
    public void testGetException() throws JokeException {
        System.out.println("testGetException expecting a JokeException");
        jokeFetcher.getJokes("yourmama", "Europe/Copenhagen");
    }

    @Test
    public void testGetJokes() throws JokeException {
        System.out.println("testGetJokes");
        List<IJokeFetcher> result = factory.getJokeFetchers("eduprog,chucknorris,moma,tambal");

        assertThat(result.get(0), instanceOf(EduJoke.class));
        assertThat(result.get(1), instanceOf(ChuckNorris.class));
        assertThat(result.get(2), instanceOf(Moma.class));
        assertThat(result.get(3), instanceOf(Tambal.class));

        assertThat(result.size(), is(4));
    }

    @Test
    public void testEduJokeMock() {
        System.out.println("testEduJokeMock");
        String educJoke = "Teacher asked George: 'How can you prove the earth is round?' "
                + "George replied: 'I can’t. Besides, I never said it was.'";
        when(eduJoke.getJoke()).thenReturn(new Joke(educJoke, "http://jokes-plaul.rhcloud.com/api/joke"));
        assertThat(eduJoke.getJoke().getReference(), equalTo("http://jokes-plaul.rhcloud.com/api/joke"));
        results.add(eduJoke);
        verify(results).add(eduJoke);

        when(results.size()).thenReturn(1);
        assertThat(results.size(), equalTo(1));
    }

    @Test
    public void testChuckJokeMock() {
        System.out.println("testChuckJokeMock");
        String chuckJoke = "Chuck Norris can make a class that is both abstract and final.";
        when(chuckNorris.getJoke()).thenReturn(new Joke(chuckJoke, "http://api.icndb.com/jokes/random"));
        assertThat(chuckNorris.getJoke().getReference(), equalTo("http://api.icndb.com/jokes/random"));
        results.add(chuckNorris);
        verify(results).add(chuckNorris);

        when(results.size()).thenReturn(1);
        assertThat(results.size(), equalTo(1));
    }

    @Test
    public void testMomaJokeMock() {
        System.out.println("testMomaJokeMock");
        String momaJoke = "Yo mamas so fat everytime she turns around its her birthday";
        when(moma.getJoke()).thenReturn(new Joke(momaJoke, "http://api.yomomma.info/"));
        assertThat(moma.getJoke().getReference(), equalTo("http://api.yomomma.info/"));
        results.add(moma);
        verify(results).add(moma);

        when(results.size()).thenReturn(1);
        assertThat(results.size(), equalTo(1));
    }

    @Test
    public void testTambalJokeMock() {
        System.out.println("TestTambalJokeMock");
        String tambalJoke = "If you reverse tambal you get labmat, and if you swap places "
                + "with lab and mat you get the programming platform matlab!";
        when(tambal.getJoke()).thenReturn(new Joke(tambalJoke, "http://tambal.azurewebsites.net/joke/random"));
        assertThat(tambal.getJoke().getReference(), equalTo("http://tambal.azurewebsites.net/joke/random"));
        results.add(tambal);
        verify(results).add(tambal);

        when(results.size()).thenReturn(1);
        assertThat(results.size(), equalTo(1));
    }

    @Test
    public void testAvailableTypesMock() {
        System.out.println("TestAvailableTypesMock");
        when(factory.getAvailableTypes()).thenReturn(Arrays.asList("eduprog", "chucknorris", "moma", "tambal"));
        assertThat(factory.getAvailableTypes().size(), equalTo(4));
    }

}
