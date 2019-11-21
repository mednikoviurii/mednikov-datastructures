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
            new Person("Aneta", "Fialova"), 
            new Person("Jana", "Dvorakova"), 
            new Person("Patricia", "Shvecova"));
        
        // vavr queues are immutable
        Queue<Person> result = people.enqueue(new Person("Marketa", "Dietrichova"));
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
            new Person("Aneta", "Fialova"), 
            new Person("Jana", "Dvorakova"), 
            new Person("Patricia", "Shvecova"));
        Queue<Person> tail = people.tail();
        assertEquals(2, tail.size());
    }

    @Test
    public void dequeueTest(){
        Queue<Person> people = Queue.of(
            new Person("Aneta", "Fialova"), 
            new Person("Jana", "Dvorakova"), 
            new Person("Patricia", "Shvecova"));

        Tuple2<Person, Queue<Person>> result = people.dequeue();
        // first is head
        Person head = result._1();
        Queue<Person> remainingPeople = result._2();
        assertEquals("Aneta", head.getFirstName());
        assertEquals(2, remainingPeople.size());
        assertEquals("Jana", remainingPeople.head().getFirstName());

    }
}