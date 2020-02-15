package net.mednikov.datastructures.maps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import io.vavr.control.Option;
import net.mednikov.datastructures.core.Person;

public class MapsVavrTest{

    @Test
    public void addToMapTest(){
        Map<String, Person> people = HashMap.of(
        "123 456 789", new Person("Alejandra", "Sanchez"),
        "456 789 123", new Person("Beatriz", "Hidalgo"),
        "789 456 123", new Person("Carmen", "Iglesias"));

        // return new map
        Map<String, Person> updated = people.put("123 111 435", new Person("Maria", "Morales"));

        int peopleSize = people.size(); // 3
        int updatedSize = updated.size(); // 4

        // updated NOT equals to people
        boolean equals = people.equals(updated); // false

        assertFalse(equals);
        assertEquals(3, peopleSize);
        assertEquals(4, updatedSize);
    }

    @Test
    public void removeFromMapTest(){
        Map<String, String> countries = HashMap.of(
            "Spain", "es",
            "Colombia", "es",
            "Argentina", "es",
            "Brazil", "pt",
            "Czech Republic", "cz"
        );

        Map<String, String> result = countries.remove("Czech Republic");
        assertFalse(result.containsKey("Czech Republic"));

        // all elements with values which DO NOT satisfy the given predicate.
        Map<String, String> notSpanishSpeaking = countries.filterNotValues(c->c.equalsIgnoreCase("es"));

        // all elements that DO satisfy
        Map<String, String> spanishSpeaking = countries.filterValues(c->c.equalsIgnoreCase("es"));

        assertEquals(2, notSpanishSpeaking.size());
        assertEquals(3, spanishSpeaking.size());
    }

    @Test
    public void replaceElementTest(){
        Map<String, Person> people = HashMap.of(
        "123 456 789", new Person("Alejandra", "Sanchez"),
        "456 789 123", new Person("Beatriz", "Hidalgo"),
        "789 456 123", new Person("Carmen", "Iglesias"));

        Map<String, Person> result = 
            people.replace("456 789 123",  
                    new Person("Beatriz", "Hidalgo"), 
                    new Person("Katarina", "Marquez"));

        Option<Person> person = result.get("456 789 123");
        assertEquals(person.get().getFirstName(), "Katarina");

    }
}