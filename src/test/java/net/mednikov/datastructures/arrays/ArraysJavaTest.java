package net.mednikov.datastructures.arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class ArraysJavaTest{

    @Test
    public void addElementToArrayTest(){
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

        assertEquals(name, names2[oldLength]);
    }

    @Test
    public void arrayIsObjectTest(){
      int[] numbers = new int[10];
      boolean result = numbers instanceof Object;

      assertTrue(result);
    }

    @Test
    public void replaceArrayElementTest(){
      int[] numbers = {1,2,3,4,5};
      int i3 = numbers[3];

      assertEquals(4, i3);

      numbers[3] = 15;
      i3 = numbers[3];

      assertEquals(15, i3);
    }

    @Test 
    public void filterArrayTest(){
      String[] names = {"Alejandra", "Beatriz", "Aneta", "Carmen", "Ana", "Gabriela", "Alisa"};

      assertEquals(7, names.length);

      long res = Arrays.stream(names).filter(name->name.startsWith("A")).count();

      assertEquals(4, res);
    }

    @Test
    public void sortArrayTest(){
      int[] numbers = {5, 12, 6, 1, 32};
      Arrays.sort(numbers);
      int i3 = numbers[3];

      assertEquals(12, i3);

      Integer[] numbers2 = {15, 98, 1, 9, 14, 32};
	    Arrays.sort(numbers2, Collections.reverseOrder());
      int i4 = numbers2[4];
      
	    assertEquals(9, i4);
    }

    @Test
    public void equalsTest(){
      int[] numbers = {15, 98, 1, 9, 14, 32};
      int[] numbers2 = {15, 98, 1, 9, 14, 32};
      boolean result = Arrays.equals(numbers, numbers2);
      
      assertTrue(result);
    }
}