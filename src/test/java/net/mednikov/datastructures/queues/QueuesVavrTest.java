package net.mednikov.datastructures.queues;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.vavr.Tuple2;
import io.vavr.collection.Queue;
import net.mednikov.datastructures.core.Person;

public class QueuesVavrTest{

    @Test
    public void enqueueTest(){
        Queue<Person> people = Queue.of(
            new Person("Alejandra", "Velasquez"), 
            new Person("Beatriz", "Hidalgo"), 
            new Person("Carmen", "Sanchez"));
        
        // vavr queues are immutable
        Queue<Person> result = people.enqueue(new Person("Juanita", "Iglesias"));
        assertEquals(3, people.size());
        assertEquals(4, result.size());

        // queue is FIFO; elements are added to tail
        Person peopleHead = people.head();
        Person resultHead = result.head();
        assertEquals(peopleHead, resultHead);
    }

    @Test
    public void getTailTest(){
        Queue<Person> people = Queue.of(
            new Person("Alejandra", "Velasquez"), 
            new Person("Beatriz", "Hidalgo"), 
            new Person("Carmen", "Sanchez"));
        Queue<Person> tail = people.tail();
        assertEquals(2, tail.size());
    }

    @Test
    public void dequeueTest(){
        Queue<Person> people = Queue.of(
            new Person("Alejandra", "Velasquez"), 
            new Person("Beatriz", "Hidalgo"), 
            new Person("Carmen", "Sanchez"));

        Tuple2<Person, Queue<Person>> result = people.dequeue();
        // first is head
        Person head = result._1();
        Queue<Person> remainingPeople = result._2();
        assertEquals("Alejandra", head.getFirstName());
        assertEquals(2, remainingPeople.size());
        assertEquals("Beatriz", remainingPeople.head().getFirstName());

    }
}