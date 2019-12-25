package net.mednikov.datastructures.lists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import io.vavr.collection.List;

public class ListsVavrTest {

    @Test
    public void addElementsToListTest(){
        List<String> names = List.of("Adriana", "Darina", "Maria", "Karla", "Zuzana", "Yeliz");

        // Vavr collections are IMMUTABLE
        // adding of new name DOES NOT modify original collection

        List<String> result = names.append("Stela");
        assertFalse(names.contains("Stela"));
        assertEquals(names.size() + 1, result.size());
    }

    @Test
    public void removeElementFromListTest(){
        List<String> names = List.of("Adriana", "Darina", "Maria", "Karla", "Zuzana", "Yeliz");
        List<String> results = names.remove("Darina");
        assertEquals(names.size() - 1, results.size());
    }

    @Test
    public void filterListTest(){
        List<Integer> numbers = List.of(12, 33, 65, 19, 72, 14, 2, 99, 40, 30, 27);
        List<Integer> evenNumbers = numbers.filter(number->number%2==0);
        assertEquals(6, evenNumbers.size());
    }

    @Test
    public void replaceElementTest(){
        List<String> names = List.of("Adriana", "Darina", "Maria", "Karla", "Zuzana", "Yeliz");
        List<String> results = names.replace("Darina", "Denisa");
        assertFalse(results.contains("Darina"));
    }
}