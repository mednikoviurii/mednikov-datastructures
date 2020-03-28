package net.mednikov.datastructures.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ArraysJavaTest{

    @Test
    void addElementToArrayTest(){
        // declare array
        String[] names = {"Alejandra", "Beatriz", "Carmen", "Dolores"};

        // add element
        String name = "Elena";

        // step 1. get old array length
        int oldLength = names.length;

        // step 2. create new array from old
        String[] names2 = Arrays.copyOf(names, oldLength+1);

        // step 3. add new element
        names2[oldLength] = name;

        assertThat(name).isEqualToIgnoringCase(names2[oldLength]);
    }

    @Test
    void arrayIsObjectTest(){
      int[] numbers = new int[10];
      assertThat(numbers).isInstanceOf(Object.class);
    }

    @Test
    void replaceArrayElementTest(){
      int[] numbers = {1,2,3,4,5};
      int i3 = numbers[3];
      assertThat(i3).isEqualTo(4);

      numbers[3] = 15;
      i3 = numbers[3];
      assertThat(i3).isEqualTo(15);
    }

    @Test 
    void filterArrayTest(){
      String[] names = {"Alejandra", "Beatriz", "Aneta", "Carmen", "Ana", "Gabriela", "Alisa"};
      List<String> result = Arrays.stream(names).filter(name->name.startsWith("A")).collect(Collectors.toList());
      assertThat(result).contains("Alejandra", "Ana", "Alisa", "Aneta");
    }

    @Test
    void sortArrayTest(){
      int[] numbers = {5, 12, 6, 1, 32};
      Arrays.sort(numbers);
      int i3 = numbers[3];
      assertThat(i3).isEqualTo(12);

      Integer[] numbers2 = {15, 98, 1, 9, 14, 32};
	    Arrays.sort(numbers2, Collections.reverseOrder());
      int i4 = numbers2[4];
      assertThat(i4).isEqualTo(9);
    }

    @Test
    void equalsTest(){
      int[] numbers = {15, 98, 1, 9, 14, 32};
      int[] numbers2 = {15, 98, 1, 9, 14, 32};
      assertThat(numbers).isEqualTo(numbers2);
    }

    @Test
    void accessElementTest(){
      int[] numbers = {1,2,3,4,5};
      int value = numbers[2];
      assertThat(value).isEqualTo(3);
    }

    @Test
    void getArrayLengthTest() {
      int[] numbers = {15, 98, 1, 9, 14, 32};
      int length = numbers.length;
      assertThat(length).isEqualTo(6);
    }
}