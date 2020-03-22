package net.mednikov.datastructures.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class StreamsTerminalOpsTest {
    
    private List<String> getNames(){
        List<String> names = Arrays.asList("Anna", "Bob", "Carolina", "Denis", "Anna", "Jack", "Marketa", "Simon", "Anna"); 
        return names;
    }

    @Test
    public void forEachTest(){
        Stream<String> stream = getNames().stream();

        stream.filter(n -> !n.equalsIgnoreCase("Anna"))
                .map(n -> n.toUpperCase())
                .forEach(n -> System.out.println(n));
    }

    @Test
    public void collectTest(){
        Stream<String> stream = getNames().stream();
        List<Integer> result = stream.filter(n -> n.length() <= 4)
                        .map(n -> n.length()).collect(Collectors.toList());
        assertThat(result).hasSize(5);
    }

    @Test
    public void findTest(){
        Stream<String> stream = getNames().stream();
        Optional<String> result = stream.filter(n -> n.length() < 4).findFirst();
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualToIgnoringCase("Bob");
    }
}