package net.mednikov.datastructures.sets;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import net.mednikov.datastructures.core.Person;

import static org.assertj.core.api.Assertions.*;

public class SetsJavaTest {

    @Test
    public void addToSetTest(){
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        assertThat(numbers.add(2)).isFalse();
    }

    @Test
    public void removeFromSetTest(){
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        assertThat(numbers.remove(3)).isTrue();
    }

    @Test
    public void getAnElementTest(){
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(50);
        numbers.add(10);
        numbers.add(15);
        numbers.add(8);

        // as treeset has sorted elements,
        // then first = 8
        Iterator<Integer> iterator = numbers.iterator();
        Integer first = iterator.next();
        assertThat(first).isEqualTo(8);

        //use custom objects
        // people are ordered by the first name
        TreeSet<Person> people = new TreeSet<>();
        people.add(new Person("Alejandra", "Morales"));
        people.add(new Person("Katarina", "Rodriguez"));
        people.add(new Person("Maria", "Sanchez"));
        people.add(new Person("Robetra", "Iglesias"));

        Optional<Person> person = people.stream().filter(p -> p.equals(new Person("Maria", "Sanchez"))).findFirst();
        assertThat(person).isPresent();
    }
}