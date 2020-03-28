package net.mednikov.datastructures.maps;

import org.junit.jupiter.api.Test;


import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import io.vavr.control.Option;
import net.mednikov.datastructures.core.Person;

import static org.assertj.core.api.Assertions.*;


class MapsVavrTest{

    @Test
    void addToMapTest(){
        Map<String, Person> people = HashMap.of(
        "123 456 789", new Person("Alejandra", "Sanchez"),
        "456 789 123", new Person("Beatriz", "Hidalgo"),
        "789 456 123", new Person("Carmen", "Iglesias"));

        // return new map
        Map<String, Person> updated = people.put("123 111 435", new Person("Maria", "Morales"));
        assertThat(people.toJavaMap()).doesNotContainKey("123 111 435");
    }

    @Test
    void removeFromMapTest(){
        Map<String, String> countries = HashMap.of(
            "Spain", "es",
            "Colombia", "es",
            "Argentina", "es",
            "Brazil", "pt",
            "Czech Republic", "cz"
        );

        Map<String, String> result = countries.remove("Czech Republic");
        assertThat(result.toJavaMap()).doesNotContainKey("Czech Republic");

        // all elements with values which DO NOT satisfy the given predicate.
        // Map<String, String> notSpanishSpeaking = countries.filterNotValues(c->c.equalsIgnoreCase("es"));
        assertThat(countries.filterNotValues(c->c.equalsIgnoreCase("es"))).hasSize(2);
        assertThat(countries.filterValues(c->c.equalsIgnoreCase("es"))).hasSize(3);
    }

    @Test
    void replaceElementTest(){
        Map<String, Person> people = HashMap.of(
        "123 456 789", new Person("Alejandra", "Sanchez"),
        "456 789 123", new Person("Beatriz", "Hidalgo"),
        "789 456 123", new Person("Carmen", "Iglesias"));

        Map<String, Person> result = 
            people.replace("456 789 123",  
                    new Person("Beatriz", "Hidalgo"), 
                    new Person("Katarina", "Marquez"));

        Option<Person> person = result.get("456 789 123");
        assertThat(person.get().getFirstName()).isEqualToIgnoringCase("Katarina");

    }
}