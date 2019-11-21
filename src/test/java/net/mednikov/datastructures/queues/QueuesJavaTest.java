package net.mednikov.datastructures.queues;

import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

import net.mednikov.datastructures.core.Car;
import net.mednikov.datastructures.core.Person;

public class QueuesJavaTest {

    @Test
    public void enqueueTest(){
        Queue<Person> people = new ArrayDeque<>();

        // people are inserted in the tail, so head is same

        people.offer(new Person("Zuzana", "Cermakova"));
        people.offer(new Person("Tereza", "Vodickova"));
        people.offer(new Person("Carolina", "Prokopova"));
        
        Person head = people.peek();

        // head of queue is Zuzana Cermakova

        assertEquals("Zuzana", head.getFirstName());
        assertEquals("Cermakova", head.getLastName());
    }

    @Test
    public void getTailTest(){
        Queue<Person> people = new ArrayDeque<>();
        people.offer(new Person("Zuzana", "Cermakova"));
        people.offer(new Person("Tereza", "Vodickova"));
        people.offer(new Person("Carolina", "Prokopova"));

        // step 1 Copy existing queue
        Queue<Person> tail = new ArrayDeque<>(people);

        // step 2 remove head
        tail.poll();

        assertEquals(2, tail.size());
        assertEquals("Tereza", tail.peek().getFirstName());
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
        Car head = cars.peek();
        assertEquals(1234, head.getLicensePlateNumber());
    }
}