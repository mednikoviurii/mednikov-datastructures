package net.mednikov.datastructures.arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class ArraysJavaTest{

    @Test
    public void addElementToArrayTest(){
        // declare array
        String[] names = {"Anna", "Beata", "Carolina", "Denisa"};

        // add element
        String name = "Zuzka";

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
      String[] cities = {"Madrid", "Moscow", "Prague", "Montreal", "Macao", "Berlin", "Vienna"};
      assertEquals(7, cities.length);
      long res = Arrays.stream(cities).filter(city->city.startsWith("M")).count();
      assertEquals(4, res);
    }

    @Test
    public void sortArrayTest(){
      int[] numbers = {5, 12, 6, 1, 32};
      Arrays.sort(numbers);
      int i3 = numbers[3];
      assertEquals(12, i3);
    }
}