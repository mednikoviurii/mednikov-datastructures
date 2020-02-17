package net.mednikov.datastructures.queues;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

import net.mednikov.datastructures.core.Car;
import net.mednikov.datastructures.core.Person;

import static org.assertj.core.api.Assertions.*;


public class QueuesJavaTest {

    @Test
    public void enqueueTest(){
        Queue<Person> people = new ArrayDeque<>();

        // people are inserted in the tail, so head is same

        people.offer(new Person("Alejandra", "Morales"));
        people.offer(new Person("Beatriz", "Sanchez"));
        people.offer(new Person("Carmen", "Hidalgo"));
        
        // head of queue is Alejandra Morales
        assertThat(people.peek()).isEqualTo(new Person("Alejandra", "Morales"));
    }

    @Test
    public void getTailTest(){
        Queue<Person> people = new ArrayDeque<>();
        people.offer(new Person("Alejandra", "Morales"));
        people.offer(new Person("Beatriz", "Sanchez"));
        people.offer(new Person("Carmen", "Hidalgo"));

        // step 1 Copy existing queue
        Queue<Person> tail = new ArrayDeque<>(people);

        // step 2 remove head
        tail.poll();

        assertThat(tail).hasSize(2);

    }

    @Test
    public void dequeueTest(){
        Queue<Car> cars = new ArrayDeque<>();
        cars.offer(new Car(4567, "Skoda Rapid"));
        assertEquals(4567, cars.peek().getLicensePlateNumber());
        cars.offer(new Car(1234, "Mazda 3"));
        cars.offer(new Car(2345, "Kia Cerato"));
        
        // remove previous head (Skoda) -> new head = mazda

        cars.poll();
        assertThat(cars.peek().getLicensePlateNumber()).isEqualTo(1234);
    }
}