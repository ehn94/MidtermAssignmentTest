/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jokes;

import static com.jayway.restassured.RestAssured.given;
import interfaces.IJokeFetcher;
import testex.Joke;

/**
 *
 * @author ehn19
 */
public class ChuckNorris implements IJokeFetcher{
    @Override
    public Joke getJoke() {
        try {
            String joke = given().get("http://api.icndb.com/jokes/random").path("value.joke");
            return new Joke(joke, "http://api.icndb.com/");
        } catch (Exception e) {
            return null;
        }
    }
}
