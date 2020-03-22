package net.mednikov.datastructures.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import net.mednikov.datastructures.core.Post;

import static org.assertj.core.api.Assertions.*;


public class CollectionsTest {

    @Test
    public void insertTest(){
        // get mock posts
        List<Post> posts = getPosts();

        // Add single element
        Post post = new Post(6, "Phasellus scelerisque", "Phasellus scelerisque eros id lacus auctor");
        posts.add(post);
        assertThat(posts).contains(post).hasSize(6);

        // add multiple elements
        List<Post> newPosts = new ArrayList<>();
        newPosts.addAll(posts);
        assertThat(newPosts).containsAll(posts);
    }

    @Test
    public void removeTest(){
        // get mock posts
        List<Post> posts = getPosts();

        Post post = posts.get(2);
        assertThat(posts).contains(post);

        // remove object
        posts.remove(post);
        assertThat(posts).doesNotContain(post);

        // clear
        posts.clear();
        assertThat(posts).isEmpty();

        // delete with predicate
        posts = getPosts();
        // remove posts with ID 2 and 4
        posts.removeIf(p -> p.getId() % 2 == 0);
        assertThat(posts).hasSize(3);
    }

    @Test
    public void streamTest(){
        List<Post> posts = getPosts();
        Stream<Post> stream = posts.stream();
        assertThat(stream).isInstanceOf(Stream.class);
    }

    @Test
    public void iterationTest(){
        List<Post> posts = getPosts();

        // create iterator
        Iterator<Post> iterator = posts.iterator();
        // Option 1 with hasNext
        System.out.println("Iteration using iterator hasNext");
        while(iterator.hasNext()){
            Post post = iterator.next();
            System.out.println(post);
        }

        Iterator<Post> iterator2 = posts.iterator();
        // Option 2 using forEachRemaining
        System.out.println("Iteration using iterator forEachRemaining");
        iterator2.forEachRemaining(p -> System.out.println(p));

        // using forEach
        System.out.println("Iteration using forEach");
        posts.forEach(System.out::println);

        // using stream
        System.out.println("Iteration using stream");
        posts.stream().forEach(p -> System.out.println(p));
    }

    private List<Post> getPosts(){

        List<Post> posts = new ArrayList<>();

        posts.add(new Post(1, "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."));

        posts.add(new Post(2, "Nulla facilisi", "Nulla facilisi. Phasellus suscipit quis ex sit amet pellentesque. Suspendisse potenti."));

        posts.add(new Post(3, "Vivamus eu convallis lorem.", "Vivamus eu convallis lorem. Duis et vulputate leo."));

        posts.add(new Post(4, "Nullam facilisis", "Nullam facilisis elit ut nunc euismod porttitor ac eget neque."));

        posts.add(new Post(5, "Cras nec malesuada", "Cras nec malesuada tellus. Aenean sit amet est id neque"));

        return posts;
    }
}