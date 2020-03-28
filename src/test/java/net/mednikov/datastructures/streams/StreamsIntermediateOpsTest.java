package net.mednikov.datastructures.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import net.mednikov.datastructures.core.Person;
import net.mednikov.datastructures.core.Point;

import static org.assertj.core.api.Assertions.*;

class StreamsIntermediateOpsTest {

    @Test
    void createStreamTest() {
        // from collections
        final List<String> names = Arrays.asList("Alejandra", "Beatriz", "Carmen", "Dolores", "Juanita");
        Stream<String> namesStream = names.stream();
        assertThat(namesStream).isInstanceOf(Stream.class);

        // generating
        IntStream rangeStream = IntStream.range(1, 10);
        assertThat(rangeStream.toArray()).hasSize(9).contains(9).doesNotContain(10);

        // of()
        Stream<Point> pointsStream = Stream.of(new Point(1,2), new Point(5, -12), new Point(-9, 4), new Point(6, 1), new Point(0,0));
        assertThat(pointsStream).isInstanceOf(Stream.class);

        // ofNullable
        Person nullPerson = null;
        Stream<Person> nullableStream = Stream.ofNullable(nullPerson);
        assertThat(nullPerson).isNull();
        assertThat(nullableStream).isInstanceOf(Stream.class);

        // iterate
        Stream<Integer> iterateStream = Stream.iterate(0, i -> i + 2);
        assertThat(iterateStream).isInstanceOf(Stream.class);

        // empty
        Stream<Integer> emptyStream = Stream.empty();
        assertThat(emptyStream.toArray()).isEmpty();

        // builder

        // 1. create builder
        Stream.Builder<String> builder = Stream.builder();
        // 2. create stream
        Stream<String> nameStreamBuilder = builder.add("Alejandra").add("Beatriz").add("Carmen").add("Dolores").add("Juanita").build();
        // contains same elements as the first example
        assertThat(namesStream.collect(Collectors.toList())).containsExactlyElementsOf(nameStreamBuilder.collect(Collectors.toList()));
    }

    @Test
    void filterTest(){
        Stream<String> stream = getNames().stream();
        long result = stream.filter(n -> n.startsWith("A")).count();
        assertThat(result).isEqualTo(4);
    }

    @Test
    void mapTest(){
        Stream<String> stream = getNames().stream();
        int result = stream.mapToInt(n -> n.length()).sum();
        assertThat(result).isEqualTo(43);
    }

    @Test
    void distinctTest(){
        List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5); 
        Stream<Integer> stream = numbers.stream();
        long result = stream.distinct().count();
        assertThat(result).isEqualTo(5);
    }

    @Test
    void sortTest(){
        List<Integer> numbers = Arrays.asList(-9, -18, 0, 25, 4); 
        Stream<Integer> stream = numbers.stream();
        List<Integer> result = stream.sorted().collect(Collectors.toList());
        assertThat(result).containsAll(numbers).containsExactly(-18, -9, 0, 4, 25);
    }

    @Test
    void whileTest(){
        Set<Integer> numbers = Set.of(1,2,3,4,5,6,7,8);
        Stream<Integer> stream = numbers.stream();
        Set<Integer> result = stream.takeWhile(x-> x < 5).collect(Collectors.toSet());
        assertThat(result).hasSize(4);
    }

    @Test
    void limitTest(){
        Stream<Integer> stream = getNumbers().stream();
        Set<Integer> result = stream.sorted().limit(5).collect(Collectors.toSet());
        System.out.println(result);
        assertThat(result).contains(-75, -18, -9, -5, 0);
    }

    private List<Integer> getNumbers(){
        List<Integer> numbers = Arrays.asList(-9, -18, 0, 12, -5, 92, 13, 50, -75, 25, 4);
        return numbers;
    }

    private List<String> getNames(){
        List<String> names = Arrays.asList("Alejandra", "Beatriz", "Aneta", "Carmen", "Ana", "Gabriela", "Alisa");
        return names;
    }
}