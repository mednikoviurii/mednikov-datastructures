package net.mednikov.datastructures.lists;


import org.junit.Test;

import io.vavr.collection.List;

import static org.assertj.core.api.Assertions.*;


public class ListsVavrTest {

    @Test
    public void addElementsToListTest(){
        List<String> names = List.of("Alejandra", "Beatriz", "Carmen", "Dolores");

        // Vavr collections are IMMUTABLE
        // adding of new name DOES NOT modify original collection

        List<String> result = names.append("Susana");

        assertThat(names).doesNotContain("Susana");
        assertThat(result).hasSize(names.length() + 1);
    }

    @Test
    public void removeElementFromListTest(){
        List<String> names = List.of("Alejandra", "Beatriz", "Carmen", "Dolores", "Juanita");

        List<String> results = names.remove("Dolores");

        assertThat(names).contains("Dolores");
        assertThat(results).doesNotContain("Dolores");

        List<String> results2 = names.removeAt(3);
        assertThat(names).contains("Dolores");
        assertThat(results2).doesNotContain("Dolores");
    }

    @Test
    public void filterListTest(){
        List<Integer> numbers = List.of(12, 33, 65, 19, 72, 14, 2, 99, 40, 30, 27);
        List<Integer> evenNumbers = numbers.filter(number->number%2==0);
        assertThat(evenNumbers).hasSize(6);
    }

    @Test
    public void replaceElementTest(){
        List<String> names = List.of("Alejandra", "Beatriz", "Carmen", "Dolores");
        assertThat(names.replace("Beatriz", "Maria")).doesNotContain("Beatriz");
    }

    @Test
    public void searchForElementTest(){
        List<String> names = List.of("Alejandra", "Beatriz", "Carmen", "Dolores", "Juanita");
        assertThat(names.indexOf("Juanita")).isEqualTo(4);
        assertThat(names.indexOfOption("Dolores").isDefined()).isTrue();
    }

    @Test
    public void createSublistTest(){
        List<Integer> original = List.of(54, 12, 29, 13, 95, 65, 285, 90, 5431);
        List<Integer> sublist = original.slice(0, 5); // end index not inlcuded
        assertThat(sublist.existsUnique(number -> number == 65)).isFalse();
        assertThat(sublist.existsUnique(number -> number == 12)).isTrue();
    }

    @Test
    public void compareListsTest(){
        List<Integer> numbers1 = List.of(12, 33, 65, 19, 72, 14, 2, 99, 40, 30, 27);
        List<Integer> numbers2 = List.of(12, 33, 65, 19, 72, 14, 2, 99, 40, 30, 27);
        assertThat(numbers1).isEqualTo(numbers2);
    }
}