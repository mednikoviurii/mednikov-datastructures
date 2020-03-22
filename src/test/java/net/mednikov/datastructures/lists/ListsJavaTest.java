package net.mednikov.datastructures.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ListsJavaTest {

    @Test
    public void accessElementTest() {
        List<Integer> numbers = Arrays.asList(1, 52, 12, 39, 45, 98, 100, 565, 6, 13);
        int beginning = numbers.get(0);
        int value = numbers.get(5);
        int end = numbers.get(numbers.size()-1);
        assertThat(beginning).isEqualTo(1);
        assertThat(value).isEqualTo(98);
        assertThat(end).isEqualTo(13);
    }

    @Test
    public void addElementsToListTest () {
        // Approach 1. Create new list and use add() MUTABLE!
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);
        numbers.add(30);
        assertThat(numbers.add(66)).isTrue();

        //Approach 2. Use Arrays.asList. IMMUTABLE!
        List<String> names = Arrays.asList("Alejandra", "Beatriz", "Carmen", "Dolores", "Juanita");
        assertThatExceptionThrownBy(() -> names.add("Maria")).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    public void removeElementFromListTest() {
        List<String> names = new ArrayList<>();
        names.add("Alejandra");
        names.add("Beatriz");
        names.add("Carmen");
        names.add("Dolores");
        names.add("Juanita");

        // Approach 1. Remove by INDEX
        assertThat(names.remove(1)).isEqualToIgnoringCase("Beatriz");

        // Approach 2. Remove ELEMENT
        assertThat(names.remove("Juanita")).isTrue();
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
        
        assertThat(evenNumbers).hasSize(3);
    }

    @Test
    public void replaceElementTest(){
        List<String> names = new ArrayList<>();
        names.add("Alejandra");
        names.add("Beatriz");
        names.add("Carmen");
        names.add("Dolores");
        names.add("Juanita");

        // Appraoch 1 By index
        names.set(1, "Maria");
        assertThat(names.get(1)).isEqualToIgnoringCase("Maria");

        // Approach 2 With Collections.replaceAll
        Collections.replaceAll(names, "Carmen", "Sofia");
        assertThat(names).containsExactly("Alejandra", "Maria", "Sofia", "Dolores", "Juanita");
    }

    @Test
    public void searchForElementTest(){
        List<Integer> numbers = Arrays.asList(1, 52, 12, 39, 45, 98, 100, 565, 6, 13);
        assertThat(numbers.indexOf(45)).isEqualTo(4);

        // using lastIndexOf
        List<Integer> numbers2 = Arrays.asList(1, 52, 12, 39, 45, 98, 100, 565, 45, 6, 13);
        assertThat(numbers2.lastIndexOf(45)).isEqualTo(8);
    }

    @Test
    public void createSublistTest(){
        List<String> original = Arrays.asList("Alejandra", "Beatriz", "Carmen", "Dolores", "Juanita", "Katarina", "Maria");
        List<String> sublist = original.subList(0, 5);
        assertThat(sublist).contains("Juanita").doesNotContain("Katarina");
    }

    @Test
    public void compareListsTest(){
        List<Integer> list1 = Arrays.asList(1, 52, 12, 39, 45, 98, 100, 565, 6, 13);
        List<Integer> list2 = Arrays.asList(1, 52, 12, 39, 45, 98, 100, 565, 6, 13);

        // Approach 1. with equals
        assertThat(list1).isEqualTo(list2);

        // Approach 2. with streams
        List<Integer> list3 = Arrays.asList(1, 12, 52, 39, 45, 100, 98, 6, 13, 565);
        assertThat(list1).isNotEqualTo(list3);

        // boolean allMatch = list3.stream().allMatch(number -> list1.contains(number));;
        assertThat(list3.stream().allMatch(number -> list1.contains(number))).isTrue();
    }

    @Test
    public void removeOverloadedTest(){
        List<Integer> numbers =  new ArrayList<>();
        numbers.add(12);
        numbers.add(2);
        numbers.add(3);
        numbers.add(51);
        numbers.remove(Integer.valueOf(2));
        assertThat(numbers).doesNotContain(2);
    }
}