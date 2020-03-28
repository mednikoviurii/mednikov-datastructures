package net.mednikov.datastructures.collections;

import java.util.List;

import com.google.common.collect.Lists;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AssertJExampleTest { 

    @Test
    void containsElementTest(){
        List<Integer> numbers = Lists.newArrayList(1, 52, 12, 39, 45, 98, 100, 565, 6, 13);
        assertThat(numbers).contains(12);
        assertThat(numbers).doesNotContain(50);
    }

    @Test
    void containsAllElementsNoMatterOrderTest(){
        List<Integer> numbers = Lists.newArrayList(1, 52, 12, 39, 45, 98, 100, 565, 6, 13);
        List<Integer> values = Lists.newArrayList(52, 39, 12, 1, 100);
        assertThat(numbers).containsAll(values);
    }

    @Test
    void containsAllElementsInOrderTest(){
        List<Integer> numbers = Lists.newArrayList(1, 52, 12, 39, 45, 98, 100, 565, 6, 13);
        List<Integer> values = Lists.newArrayList(numbers);
        assertThat(numbers).containsExactlyElementsOf(values);
    }

    @Test
    void containsOnlyOnceTest(){
        List<Integer> numbers = Lists.newArrayList(1, 1, 52, 12, 12, 45, 45);
        assertThat(numbers).containsOnlyOnce(52);
    }

    @Test
    void noDuplicatesTest(){
        List<Integer> numbers = Lists.newArrayList(1, 52, 12, 39, 45, 98, 100, 565, 6, 13);
        assertThat(numbers).doesNotHaveDuplicates();
    }

}