package net.mednikov.datastructures.arrays;

import java.util.function.Predicate;

import org.junit.Test;

import io.vavr.collection.Array;

import static org.assertj.core.api.Assertions.*;

public class ArraysVavrTest {

    @Test
    public void addElementsToArrayTest() {
        Array<String> names = Array.of("Alejandra", "Beatriz", "Carmen", "Dolores");
        Array<String> updatedNames = names.append("Isabel");

        Predicate<String> predicate = n -> n.equalsIgnoreCase("Isabel");

        assertThat(names.existsUnique(predicate)).isFalse();
        assertThat(updatedNames.existsUnique(predicate)).isTrue();
    }

    @Test
    public void accessElementInArrayTest(){
        Array<String> names = Array.of("Alejandra", "Beatriz", "Carmen", "Dolores");
        assertThat(names.get(2)).isEqualToIgnoringCase("Carmen");
    }

    @Test
    public void filterArrayTest() {
        Array<String> names = Array.of("Alejandra", "Beatriz", "Aneta", "Carmen", "Ana", "Gabriela", "Alisa");
        Array<String> filtered = names.filter(name -> name.startsWith("A"));
        assertThat(filtered).contains("Alejandra", "Aneta", "Ana", "Alisa");
    }

    @Test
    public void getLengthTest(){
        Array<String> names = Array.of("Alejandra", "Beatriz", "Carmen", "Dolores");
        int size = names.size();
        assertThat(size).isEqualTo(4);
    }

    @Test
    public void sortTest(){
        Array<Integer> numbers = Array.ofAll(16, 22, 4, 5, 19, 7, 80);
        Array<Integer> sorted = numbers.sorted();
        assertThat(sorted).containsExactly(4,5,7,16,19,22,80);
    }

    @Test
    public void equalsTest(){
        Array<Integer> array1 = Array.ofAll(16, 22, 4, 5, 19, 7, 80);
        Array<Integer> array2 = Array.ofAll(16, 22, 4, 5, 19, 7, 80);
        assertThat(array1).isEqualTo(array2);
    }

    @Test
    public void replaceTest(){
        Array<String> names = Array.of("Alejandra", "Beatriz", "Alejandra", "Carmen", "Ana", "Gabriela", "Alejandra");

        Array<String> results1 = names.replace("Alejandra", "Olga");
        assertThat(results1.count(n -> n.equalsIgnoreCase("Olga"))).isEqualTo(1);

        Array<String> results2 = names.replaceAll("Alejandra", "Maria");
        assertThat(results2.count(n -> n.equalsIgnoreCase("Maria"))).isEqualTo(3);
    }
}