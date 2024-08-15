package com.octoperf.jpetstore6.sharedData;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * ScenarioContext is a class used to store and manage shared data between different steps of a scenario.
 * It provides methods to store and retrieve data in the form of simple key-value pairs or as a map of key-value pairs.
 */
@Getter
@Setter
public class ScenarioContext {

    /**
     * A map to store key-value pairs where the key is a String and the value is an Object.
     */
    private final Map<String, Object> map = new HashMap<>();

    /**
     * A map to store key-value pairs where the key is a String and the value is another map with String keys and values.
     */
    private final Map<String, Map<String, String>> listOfMap = new HashMap<>();

    /**
     * Stores a value in the map with the specified key.
     *
     * @param key   the key to associate with the value
     * @param value the value to store
     */
    public void setMap(String key, Object value) {
        map.put(key, value);
    }

    /**
     * Retrieves a value from the map associated with the specified key.
     *
     * @param key the key of the value to retrieve
     * @return the value associated with the key, cast to a String
     */
    public String getMap(String key) {
        return (String) map.get(key);
    }

    /**
     * Retrieves a map of key-value pairs associated with the specified key from the listOfMap.
     *
     * @param key the key of the map to retrieve
     * @return the map associated with the key, or null if the key is not found
     */
    public Map<String,String> getListOfMap(String key) {
        return listOfMap.get(key);
    }

    /**
     * Stores a map of key-value pairs in the listOfMap with the specified key.
     *
     * @param key   the key to associate with the map
     * @param value the map of key-value pairs to store
     */
    public void setListOfMap(String key, Map<String, String> value) {
        listOfMap.put(key, value);
    }
}
