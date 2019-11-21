package net.mednikov.datastructures.sets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import net.mednikov.datastructures.core.FuelableCar;

public class SetsVavrTest{

    @Test
    public void addToSetTest(){

        Set<Integer> numbers = HashSet.ofAll(15, 25, 10, 19, 93);
        assertEquals(5, numbers.size());

        // vavr collections are immutable
        Set<Integer> result = numbers.add(100);
    
        assertEquals(5, numbers.size());
        assertEquals(6, result.size());
    }

    @Test
    public void removeFromSetTest(){

        Set<Integer> numbers = HashSet.ofAll(15, 25, 10, 19, 93);
        // vavr collections are immutable
        Set<Integer> results = numbers.remove(25);
        assertFalse(results.contains(25));
        assertTrue(numbers.contains(25));
    }

    @Test
    public void replaceTest(){
        Set<FuelableCar> cars = HashSet
            .of(new FuelableCar(1234, "Skoda rapid", 100), 
                new FuelableCar(2314, "VW Gold", 100),
                new FuelableCar(8543, "Audi A6", 100));

        System.out.println(cars);
        assertEquals(3, cars.size());

        // now, reduce fuel level in audi
        FuelableCar audi = new FuelableCar(8543, "Audi A6", 85);
        Set<FuelableCar> result = cars.replaceAll(cars.last(), audi);
        System.out.println(result);

    }

}