package net.mednikov.datastructures.optional;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.google.common.collect.Lists;

import org.junit.jupiter.api.Test;

class OptionalTest {

    @Test
    void createOptionalTest(){
        // using of
        Optional<Integer> result1 = Optional.of(10);
        assertThat(result1).isInstanceOf(Optional.class).isPresent().contains(10);

        // from streams
        List<Integer> numbers = Lists.newArrayList(1, 2, 3, 4, 5);
        Optional<Integer> result2 = numbers.stream().filter(n -> n>2).findFirst();
        assertThat(result2).isInstanceOf(Optional.class).isPresent().contains(3);

        // ofNullable
        String name = null;
        Optional<String> result3 = Optional.ofNullable(name);
        assertThat(result3).isInstanceOf(Optional.class).isEmpty();

        // empty
        Optional<String> result4 = Optional.empty();
        assertThat(result4).isInstanceOf(Optional.class).isEmpty();
    }

    @Test
    void onPresentTest(){
        String name = "Diana";
        Optional<String> result = Optional.of(name);
        result.ifPresent(n -> System.out.println(n));
    }

    @Test
    void onPresentOrElseTest(){
        Optional<Integer> result = Optional.empty();
        result.ifPresentOrElse(n -> System.out.println("Result is: " + n), 
                              () -> System.out.println("No result found"));
    }

    @Test
    void onElseGetTest(){
        Optional<Integer> result = Optional.empty();
        Integer value = result.orElse(10);
        assertThat(value).isEqualTo(10);
    }

    @Test
    void onElseThrowTest(){
        Optional<String> result = Optional.empty();
        assertThatExceptionThrownBy(() -> result.orElseThrow()).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void mapTest(){
        Optional<String> name = Optional.of("Diana");
        Optional<String> result = name.map(n -> n.toUpperCase());
        assertThat(result).isPresent().contains("DIANA");
    }

    @Test
    void streamTest(){
        Optional<Integer> number = Optional.of(10);
        long result = number.stream().count();
        assertThat(result).isEqualTo(1);
    }
}