package net.mednikov.datastructures.sets;


import org.junit.jupiter.api.Test;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import net.mednikov.datastructures.core.FuelableCar;

import static org.assertj.core.api.Assertions.*;


class SetsVavrTest{

    @Test
    void addToSetTest(){
        Set<Integer> numbers = HashSet.ofAll(15, 25, 10, 19, 93);
        assertThat(numbers.add(100)).contains(100);
        assertThat(numbers).doesNotContain(100);
    }

    @Test
    void removeFromSetTest(){
        Set<Integer> numbers = HashSet.ofAll(15, 25, 10, 19, 93);
        assertThat(numbers.remove(25)).doesNotContain(25);
        assertThat(numbers).contains(25);
    }

    @Test
    void replaceTest(){
        Set<FuelableCar> cars = HashSet
            .of(new FuelableCar(1234, "Skoda rapid", 100), 
                new FuelableCar(2314, "VW Gold", 100),
                new FuelableCar(8543, "Audi A6", 100));

        // now, reduce fuel level in audi
        FuelableCar audi = new FuelableCar(8543, "Audi A6", 85);
        Set<FuelableCar> result = cars.replaceAll(cars.last(), audi);
        assertThat(result.last()).isEqualTo(audi);
    }

}