package net.mednikov.datastructures.sets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import net.mednikov.datastructures.core.Person;

public class SetsJavaTest {

    @Test
    public void addToSetTest(){
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2); // allows no duplicates
        int length = numbers.size();
        assertEquals(3, length);
    }

    @Test
    public void removeFromSetTest(){
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        boolean removed = numbers.remove(3);
        assertTrue(removed);
        assertEquals(2, numbers.size());
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
        assertEquals(Integer.valueOf(8), first);

        //use custom objects
        // people are ordered by the first name
        TreeSet<Person> people = new TreeSet<>();
        people.add(new Person("Jana", "Cermakova"));
        people.add(new Person("Tereza", "Vodickova"));
        people.add(new Person("Zuzana", "Novakova"));
        people.add(new Person("Jana", "Vojtechova"));

        people.stream().forEach(System.out::println);
    }
}