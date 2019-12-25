package net.mednikov.datastructures.arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import io.vavr.collection.Array;

public class ArraysVavrTest {

    @Test
    public void addElementsToArrayTest() {
        Array<String> names = Array.of("Anna", "Barbora", "Carolina", "Denisa", "Eva");
        Array<String> updatedNames = names.append("Hana");
        assertFalse(names.equals(updatedNames));
    }

    @Test
    public void accessElementInArrayTest(){
        Array<String> names = Array.of("Anna", "Barbora", "Carolina", "Denisa", "Eva");
        String name = names.get(2);
        assertEquals("Carolina", name);
    }

    @Test
    public void filterArrayTest() {
        Array<String> names = Array.of("Aneta", "Barbora", "Agata", "Denisa", "Anna");
        Array<String> filtered = names.filter(name -> name.startsWith("A"));
        assertEquals(3, filtered.length());
    }

    @Test
    public void sortTest(){
        Array<Integer> numbers = Array.ofAll(16, 22, 4, 5, 19, 7, 80);
        Array<Integer> sorted = numbers.sorted();
        assertEquals(4, sorted.get(0).intValue());
        assertEquals(5, sorted.get(1).intValue());
        assertEquals(7, sorted.get(2).intValue());
        assertEquals(16, sorted.get(3).intValue());
        assertEquals(19, sorted.get(4).intValue());
        assertEquals(22, sorted.get(5).intValue());
        assertEquals(80, sorted.get(6).intValue());
    }
}