package net.mednikov.datastructures.sets;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;

import org.junit.jupiter.api.Test;

import net.mednikov.datastructures.core.Person;

import static org.assertj.core.api.Assertions.*;

class SetsJavaTest {

    @Test
    void addToSetTest(){
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        assertThat(numbers.add(2)).isFalse();
    }

    @Test
    void removeFromSetTest(){
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        assertThat(numbers.remove(3)).isTrue();
    }

    @Test
    void getAnElementTest(){
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

    @Test
    void getSizeTest(){
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        int size = numbers.size();
        assertThat(size).isEqualTo(5);
    }

    @Test
    void createSubsetTest(){
        // use Guava to create hash set
        Set<Integer> numbers = Sets.newHashSet(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // approach 1: streams
        Set<Integer> streamSubset = numbers.stream().limit(5).collect(Collectors.toSet());
        assertThat(streamSubset).hasSize(5).contains(1,2,3,4,5);

        // approach 2: iterators
        Iterator<Integer> iterator = numbers.iterator();
        Set<Integer> iteratorSubset = new HashSet<>();
        int limit = 5;
        for (int i = 0; i<limit && iterator.hasNext(); i++){
            iteratorSubset.add(iterator.next());
        }
        assertThat(iteratorSubset).hasSize(5).hasSameElementsAs(streamSubset);
    }
}