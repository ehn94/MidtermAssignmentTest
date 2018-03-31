/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author ehn19
 */
public interface IFetcherFactory {

    List<String> getAvailableTypes();

    List<IJokeFetcher> getJokeFetchers(String jokesToFetch);
}
