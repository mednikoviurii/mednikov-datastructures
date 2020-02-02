package net.mednikov.datastructures.lists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void searchForElementTest(){
        List<Integer> numbers = Arrays.asList(1, 52, 12, 39, 45, 98, 100, 565, 6, 13);
        int positionOf45 = numbers.indexOf(45);
        assertEquals(4, positionOf45);

        // using lastIndexOf
        List<Integer> numbers2 = Arrays.asList(1, 52, 12, 39, 45, 98, 100, 565, 45, 6, 13);
        // we have 2x 45

        int positionLast = numbers2.lastIndexOf(45);
        assertEquals(8, positionLast);
    }

    @Test
    public void createSublistTest(){
        List<String> original = Arrays.asList("Agata", "Emma", "Daniela", "Katarina", "Zsuzsi");
        List<String> sublist = original.subList(0, 4);
        assertTrue(sublist.contains("Katarina"));
        assertFalse(sublist.contains("Zsuzsi"));
    }

    @Test
    public void compareListsTest(){
        List<Integer> list1 = Arrays.asList(1, 52, 12, 39, 45, 98, 100, 565, 6, 13);
        List<Integer> list2 = Arrays.asList(1, 52, 12, 39, 45, 98, 100, 565, 6, 13);

        // Approach 1. with equals
        boolean areEqual = list1.equals(list2);
        assertTrue(areEqual);

        // Approach 2. with streams
        List<Integer> list3 = Arrays.asList(1, 12, 52, 39, 45, 100, 98, 6, 13, 565);
        // list3 has same selements in the different order
        boolean areEqual2 = list1.equals(list3);
        assertFalse(areEqual2);

        boolean allMatch = list3.stream().allMatch(number -> list1.contains(number));
        assertTrue(allMatch);
    }

    @Test
    public void removeOverloadedTest(){
        List<Integer> numbers =  new ArrayList<>();
        numbers.add(12);
        numbers.add(2);
        numbers.add(3);
        numbers.add(51);
        System.out.println(numbers);
        numbers.remove(Integer.valueOf(2));
        System.out.println(numbers);
    }
}