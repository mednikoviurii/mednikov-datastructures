package net.mednikov.datastructures.lists;

import org.assertj.core.api.Assertions;
import org.assertj.vavr.api.VavrAssertions;
import org.junit.jupiter.api.Test;

import io.vavr.collection.List;
import io.vavr.control.Option;


class ListsVavrTest {

    @Test
    void addElementsToListTest(){
        List<String> names = List.of("Alejandra", "Beatriz", "Carmen", "Dolores");

        // Vavr collections are IMMUTABLE
        // adding of new name DOES NOT modify original collection

        List<String> result = names.append("Susana");

        VavrAssertions.assertThat(names).doesNotContain("Susana");
        VavrAssertions.assertThat(result).hasSize(names.size() + 1);
    }

    @Test
    void removeElementFromListTest(){
        List<String> names = List.of("Alejandra", "Beatriz", "Carmen", "Dolores", "Juanita");

        List<String> results = names.remove("Dolores");

        VavrAssertions.assertThat(names).contains("Dolores");
        VavrAssertions.assertThat(results).doesNotContain("Dolores");

        List<String> results2 = names.removeAt(3);
        VavrAssertions.assertThat(names).contains("Dolores");
        VavrAssertions.assertThat(results2).doesNotContain("Dolores");
    }

    @Test
    void filterListTest(){
        List<Integer> numbers = List.of(12, 33, 65, 19, 72, 14, 2, 99, 40, 30, 27);
        List<Integer> evenNumbers = numbers.filter(number->number%2==0);
        VavrAssertions.assertThat(evenNumbers).hasSize(6);
    }

    @Test
    void replaceElementTest(){
        List<String> names = List.of("Alejandra", "Beatriz", "Carmen", "Dolores");
        List<String> results = names.replace("Beatriz", "Maria");
        VavrAssertions.assertThat(results).doesNotContain("Beatriz");
    }

    @Test
    void searchForElementTest(){
        List<String> names = List.of("Alejandra", "Beatriz", "Carmen", "Dolores", "Juanita");
        int index = names.indexOf("Juanita");
        Assertions.assertThat(index).isEqualTo(4);

        Option<Integer> option = names.indexOfOption("Dolores");
        VavrAssertions.assertThat(option).isDefined();
    }

    @Test
    void createSublistTest(){
        List<Integer> original = List.of(54, 12, 29, 13, 95, 65, 285, 90, 5431);
        List<Integer> sublist = original.slice(0, 5); // end index not inlcuded
        VavrAssertions.assertThat(sublist).containsExactly(54, 12, 29, 13, 95).doesNotContain(65);

    }

    @Test
    void compareListsTest(){
        List<Integer> numbers1 = List.of(12, 33, 65, 19, 72, 14, 2, 99, 40, 30, 27);
        List<Integer> numbers2 = List.of(12, 33, 65, 19, 72, 14, 2, 99, 40, 30, 27);
        VavrAssertions.assertThat(numbers1).isEqualTo(numbers2);
    }
}