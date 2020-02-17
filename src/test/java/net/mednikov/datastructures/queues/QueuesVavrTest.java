package net.mednikov.datastructures.queues;

import org.junit.Test;

import io.vavr.Tuple2;
import io.vavr.collection.Queue;
import net.mednikov.datastructures.core.Person;

import static org.assertj.core.api.Assertions.*;


public class QueuesVavrTest{

    @Test
    public void enqueueTest(){
        Queue<Person> people = Queue.of(
            new Person("Alejandra", "Velasquez"), 
            new Person("Beatriz", "Hidalgo"), 
            new Person("Carmen", "Sanchez"));
        
        // vavr queues are immutable
        Queue<Person> result = people.enqueue(new Person("Juanita", "Iglesias"));
        assertThat(people).doesNotContain(new Person("Juanita", "Iglesias"));
        assertThat(result).hasSize(4);

        // queue is FIFO; elements are added to tail
        assertThat(people.head()).isEqualTo(result.head());
    }

    @Test
    public void getTailTest(){
        Queue<Person> people = Queue.of(
            new Person("Alejandra", "Velasquez"), 
            new Person("Beatriz", "Hidalgo"), 
            new Person("Carmen", "Sanchez"));
        assertThat(people.tail()).hasSize(2);
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
        assertThat(head.getFirstName()).isEqualToIgnoringCase("Alejandra");
        assertThat(remainingPeople).hasSize(2);

    }
}