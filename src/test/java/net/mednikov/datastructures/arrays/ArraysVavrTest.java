package net.mednikov.datastructures.arrays;

import org.assertj.core.api.Assertions;
import org.assertj.vavr.api.VavrAssertions;
import org.junit.Test;

import io.vavr.collection.Array;

public class ArraysVavrTest {

    @Test
    public void addElementsToArrayTest() {
        Array<String> names = Array.of("Alejandra", "Beatriz", "Carmen", "Dolores");
        Array<String> updatedNames = names.append("Isabel");

        VavrAssertions.assertThat(names).doesNotContain("Isabel");
        VavrAssertions.assertThat(updatedNames).contains("Isabel");
    }

    @Test
    public void accessElementInArrayTest(){
        Array<String> names = Array.of("Alejandra", "Beatriz", "Carmen", "Dolores");

        String element = names.get(2);
        Assertions.assertThat(element).isEqualToIgnoringCase("Carmen");
    }

    @Test
    public void filterArrayTest() {
        Array<String> names = Array.of("Alejandra", "Beatriz", "Aneta", "Carmen", "Ana", "Gabriela", "Alisa");
        Array<String> filtered = names.filter(name -> name.startsWith("A"));

        VavrAssertions.assertThat(filtered).containsOnly("Alejandra", "Aneta", "Ana", "Alisa");
    }

    @Test
    public void getLengthTest(){
        Array<String> names = Array.of("Alejandra", "Beatriz", "Carmen", "Dolores");
        int size = names.size();
        Assertions.assertThat(size).isEqualTo(4);
    }

    @Test
    public void sortTest(){
        Array<Integer> numbers = Array.ofAll(16, 22, 4, 5, 19, 7, 80);
        Array<Integer> sorted = numbers.sorted();
        VavrAssertions.assertThat(sorted).containsExactly(4,5,7,16,19,22,80);
    }

    @Test
    public void equalsTest(){
        Array<Integer> array1 = Array.ofAll(16, 22, 4, 5, 19, 7, 80);
        Array<Integer> array2 = Array.ofAll(16, 22, 4, 5, 19, 7, 80);
        VavrAssertions.assertThat(array1).isEqualTo(array2);
    }

    @Test
    public void replaceTest(){
        Array<String> names = Array.of("Alejandra", "Beatriz", "Alejandra", "Carmen", "Ana", "Gabriela", "Alejandra");

        Array<String> results1 = names.replace("Alejandra", "Olga");
        VavrAssertions.assertThat(results1).containsOnlyOnce("Olga");

        Array<String> results2 = names.replaceAll("Alejandra", "Maria");
        VavrAssertions.assertThat(results2).doesNotContain("Alejandra").contains("Maria");
    }
}