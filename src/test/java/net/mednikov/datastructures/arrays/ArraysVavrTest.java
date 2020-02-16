package net.mednikov.datastructures.arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.function.Predicate;

import org.junit.Test;

import io.vavr.collection.Array;

public class ArraysVavrTest {

    @Test
    public void addElementsToArrayTest() {
        Array<String> names = Array.of("Alejandra", "Beatriz", "Carmen", "Dolores");
        Array<String> updatedNames = names.append("Isabel");

        Predicate<String> predicate = n -> n.equalsIgnoreCase("Isabel");

        assertFalse(names.existsUnique(predicate));
        assertTrue(updatedNames.existsUnique(predicate));
    }

    @Test
    public void accessElementInArrayTest(){
        Array<String> names = Array.of("Alejandra", "Beatriz", "Carmen", "Dolores");
        String name = names.get(2);

        assertEquals("Carmen", name);
    }

    @Test
    public void filterArrayTest() {
        Array<String> names = Array.of("Alejandra", "Beatriz", "Aneta", "Carmen", "Ana", "Gabriela", "Alisa");
        Array<String> filtered = names.filter(name -> name.startsWith("A"));

        assertEquals(4, filtered.length());
    }

    @Test
    public void getLengthTest(){
        Array<String> names = Array.of("Alejandra", "Beatriz", "Carmen", "Dolores");

        assertEquals(4, names.length());
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

    @Test
    public void equalsTest(){
        Array<Integer> array1 = Array.ofAll(16, 22, 4, 5, 19, 7, 80);
        Array<Integer> array2 = Array.ofAll(16, 22, 4, 5, 19, 7, 80);

        assertTrue(array1.equals(array2));
    }

    @Test
    public void replaceTest(){
        Array<String> names = Array.of("Alejandra", "Beatriz", "Alejandra", "Carmen", "Ana", "Gabriela", "Alejandra");

        Array<String> results1 = names.replace("Alejandra", "Olga");
        int result1 = results1.count(n -> n.equalsIgnoreCase("Olga"));

        assertEquals(1, result1);

        Array<String> results2 = names.replaceAll("Alejandra", "Maria");
        int result2 = results2.count(n -> n.equalsIgnoreCase("Maria"));

        assertEquals(3, result2);
    }
}