package net.mednikov.datastructures.maps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.TreeMap;

import org.junit.Test;

import net.mednikov.datastructures.core.Person;

public class MapsJavaTest{

    @Test
    public void addToMapTest(){
        HashMap<Integer, Person> people = new HashMap<>();
        people.put(1, new Person("Alejandra", "Gutierrez"));
        people.put(2, new Person("Beatriz", "Gomez"));
        people.put(3, new Person("Carmen", "Hidalgo"));
        people.put(4, new Person("Dolores", "Sanchez"));
        assertEquals(new Person("Carmen", "Hidalgo"), people.get(3));
    }

    @Test
    public void removeFromMapTest(){
        HashMap<Integer, Person> people = new HashMap<>();
        people.put(1, new Person("Alejandra", "Gutierrez"));
        people.put(2, new Person("Beatriz", "Gomez"));
        people.put(3, new Person("Carmen", "Hidalgo"));
        assertEquals(3, people.size());
        people.remove(3);
        assertEquals(2, people.size());
        assertFalse(people.containsKey(3));
    }

    @Test
    public void getFromMapTest(){
        TreeMap<String, String> words = new TreeMap<>();
        words.put("apple", "manzana");
        words.put("orange", "naranja");
        words.put("pineapple", "pina");
        words.put("lemon", "limon");

        String cucumber = words.get("cucumber");
        assertNull(cucumber);

        String fruit = words.getOrDefault("cucumber", "not a fruit");
        assertEquals("not a fruit", fruit);
    }

    @Test
    public void replaceElementTest(){
        TreeMap<String, String> words = new TreeMap<>();
        words.put("apple", "manzana");
        words.put("orange", "naranja");
        words.put("pineapple", "pina");
        words.put("lemon", "limon");

        words.replace("lemon", "limón");
        String limon = words.get("lemon");

        assertEquals("limón", limon);

        boolean result = words.replace("lemon", "limon", "un limon");
        assertFalse(result);
    }
}