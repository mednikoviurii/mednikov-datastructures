package net.mednikov.datastructures.lists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class ListsJavaTest {

    @Test
    public void addElementsToListTest () {
        // Approach 1. Create new list and use add() MUTABLE!
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);
        numbers.add(30);
        assertEquals(5, numbers.size());

        //Approach 2. Use Arrays.asList. IMMUTABLE!
        List<String> names = Arrays.asList("Agata", "Emma", "Daniela", "Katarina", "Zsuzsi");
        assertEquals(5, names.size());
    }

    @Test
    public void removeElementFromListTest() {
        List<String> names = new ArrayList<>();
        names.add("Agata");
        names.add("Emma");
        names.add("Daniela");
        names.add("Katarina");
        names.add("Zsuzsi");

        assertEquals(5, names.size());

        // Java lists are mutable

        // Approach 1. Remove by INDEX
        names.remove(1); // Emma
        assertFalse(names.contains("Emma"));
        assertEquals(4, names.size());

        // Approach 2. Remove ELEMENT
        names.remove("Daniela");
        assertFalse(names.contains("Daniela"));
        assertEquals(3, names.size());
    }

    @Test
    public void filterListTest(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(45);
        numbers.add(12);
        numbers.add(80);
        numbers.add(77);
        numbers.add(95);
        numbers.add(4);

        List<Integer> evenNumbers = numbers.stream()
            .filter(number->number%2==0)
            .collect(Collectors.toList());
        
        assertEquals(3, evenNumbers.size());
    }

    @Test
    public void replaceElementTest(){
        List<String> names = new ArrayList<>();
        names.add("Agata");
        names.add("Emma");
        names.add("Daniela");
        names.add("Katarina");
        names.add("Zsuzsi");

        // Appraoch 1 By index
        assertEquals("Emma", names.get(1));
        names.set(1, "Eva");
        assertEquals("Eva", names.get(1));

        // Approach 2 With Collections.replaceAll
        assertEquals("Daniela", names.get(2));
        Collections.replaceAll(names, "Daniela", "Darina");
        assertEquals("Darina", names.get(2));
    }
}