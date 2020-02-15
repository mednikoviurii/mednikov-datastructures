package net.mednikov.datastructures.lists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.vavr.collection.List;
import io.vavr.control.Option;

public class ListsVavrTest {

    @Test
    public void addElementsToListTest(){
        List<String> names = List.of("Alejandra", "Beatriz", "Carmen", "Dolores");

        // Vavr collections are IMMUTABLE
        // adding of new name DOES NOT modify original collection

        List<String> result = names.append("Susana");
        
        assertFalse(names.existsUnique(name->name.equalsIgnoreCase("Susana")));
        assertEquals(names.size() + 1, result.size());
    }

    @Test
    public void removeElementFromListTest(){
        List<String> names = List.of("Alejandra", "Beatriz", "Carmen", "Dolores", "Juanita");

        List<String> results = names.remove("Dolores");

        assertEquals(names.size() - 1, results.size());

        List<String> results2 = names.removeAt(3);

        assertFalse(results2.existsUnique(name -> name.equalsIgnoreCase("Dolores")));
    }

    @Test
    public void filterListTest(){
        List<Integer> numbers = List.of(12, 33, 65, 19, 72, 14, 2, 99, 40, 30, 27);
        List<Integer> evenNumbers = numbers.filter(number->number%2==0);

        assertEquals(6, evenNumbers.size());
    }

    @Test
    public void replaceElementTest(){
        List<String> names = List.of("Alejandra", "Beatriz", "Carmen", "Dolores");
        List<String> results = names.replace("Beatriz", "Maria");

        assertFalse(results.existsUnique(name -> name.equalsIgnoreCase("Beatriz")));
    }

    @Test
    public void searchForElementTest(){
        List<String> names = List.of("Alejandra", "Beatriz", "Carmen", "Dolores", "Juanita");
        int position = names.indexOf("Juanita");
        Option<Integer> positionOption = names.indexOfOption("Dolores");

        assertEquals(4, position);
        assertTrue(positionOption.isDefined());
    }

    @Test
    public void createSublistTest(){
        List<Integer> original = List.of(54, 12, 29, 13, 95, 65, 285, 90, 5431);
        List<Integer> sublist = original.slice(0, 5); // end index not inlcuded

        assertFalse(sublist.existsUnique(number -> number == 65));
        assertTrue(sublist.existsUnique(number -> number == 12));
    }

    @Test
    public void compareListsTest(){
        List<Integer> numbers1 = List.of(12, 33, 65, 19, 72, 14, 2, 99, 40, 30, 27);
        List<Integer> numbers2 = List.of(12, 33, 65, 19, 72, 14, 2, 99, 40, 30, 27);

        boolean areEqual = numbers1.equals(numbers2);
        assertTrue(areEqual);
    }
}