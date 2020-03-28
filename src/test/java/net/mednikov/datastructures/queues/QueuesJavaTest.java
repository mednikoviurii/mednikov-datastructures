package net.mednikov.datastructures.queues;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.jupiter.api.Test;

import net.mednikov.datastructures.core.Car;
import net.mednikov.datastructures.core.Person;

import static org.assertj.core.api.Assertions.*;


class QueuesJavaTest {

    @Test
    void enqueueTest(){
        Queue<Person> people = new ArrayDeque<>();

        // people are inserted in the tail, so head is same

        people.offer(new Person("Alejandra", "Morales"));
        people.offer(new Person("Beatriz", "Sanchez"));
        people.offer(new Person("Carmen", "Hidalgo"));
        
        // head of queue is Alejandra Morales
        assertThat(people.peek()).isEqualTo(new Person("Alejandra", "Morales"));
    }

    @Test
    void getTailTest(){
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
    void dequeueTest(){
        Queue<Car> cars = new ArrayDeque<>();
        Car skoda = new Car(4567, "Skoda Rapid");
        cars.offer(skoda);
        assertThat(cars.peek()).isEqualTo(skoda);
        cars.offer(new Car(1234, "Mazda 3"));
        cars.offer(new Car(2345, "Kia Cerato"));
        
        // remove previous head (Skoda) -> new head = mazda

        cars.poll();
        assertThat(cars.peek().getLicensePlateNumber()).isEqualTo(1234);
    }

    @Test
    void getHeadTest(){
        Queue<Person> people = new ArrayDeque<>();
        people.offer(new Person("Alejandra", "Morales"));
        people.offer(new Person("Beatriz", "Sanchez"));
        people.offer(new Person("Carmen", "Hidalgo"));

        Person element = people.element();
        Person peek = people.peek();
        assertThat(element).isEqualTo(peek);
    }
}