package net.mednikov.datastructures.maps;


import java.util.HashMap;
import java.util.TreeMap;

import org.junit.Test;

import net.mednikov.datastructures.core.Person;

import static org.assertj.core.api.Assertions.*;


public class MapsJavaTest{

    @Test
    public void addToMapTest(){
        HashMap<Integer, Person> people = new HashMap<>();
        people.put(1, new Person("Alejandra", "Gutierrez"));
        people.put(2, new Person("Beatriz", "Gomez"));
        people.put(3, new Person("Carmen", "Hidalgo"));
        people.put(4, new Person("Dolores", "Sanchez"));
        assertThat(people.get(3)).isEqualTo(new Person("Carmen", "Hidalgo"));
    }

    @Test
    public void removeFromMapTest(){
        HashMap<Integer, Person> people = new HashMap<>();
        people.put(1, new Person("Alejandra", "Gutierrez"));
        people.put(2, new Person("Beatriz", "Gomez"));
        people.put(3, new Person("Carmen", "Hidalgo"));
        assertThat(people).hasSize(3);
        people.remove(3);
        assertThat(people).doesNotContainKey(3);
    }

    @Test
    public void getFromMapTest(){
        TreeMap<String, String> words = new TreeMap<>();
        words.put("apple", "manzana");
        words.put("orange", "naranja");
        words.put("pineapple", "pina");
        words.put("lemon", "limon");

        assertThat(words.get("cucumber")).isNull();
        assertThat(words.getOrDefault("cucumber", "not a fruit")).isEqualToIgnoringCase("not a fruit");
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

        assertThat(limon).isEqualToIgnoringCase("limón");

        boolean result = words.replace("lemon", "limon", "un limon");
        assertThat(result).isFalse();
    }
}