package net.mednikov.datastructures.http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HttpClientTest {

    private static final URI URL = URI.create("https://jsonplaceholder.typicode.com/todos");
    private static HttpClient client;

    @BeforeAll
    static void setup() {
        client = HttpClient.newHttpClient();
    }

    @Test
    void getTest() throws Exception{
        URI url = URI.create("https://jsonplaceholder.typicode.com/todos/1");
        Gson gson = new Gson();
        HttpRequest request = HttpRequest.newBuilder().GET().uri(url).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        Todo todo = gson.fromJson(body, Todo.class);
        
        assertThat(todo).isNotNull();
    }

    @Test
    void postTest() throws Exception{
        Todo todo = new Todo(201, 1, "quis ut nam facilis et officia qui", false);
        Gson gson = new Gson();
        String body = gson.toJson(todo);
        HttpRequest request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(body)).uri(URL).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        String result = response.body();

        assertThat(statusCode).isEqualTo(201);
        assertThat(result).isNotNull();
    }

    @Test
    void deleteTest() throws Exception{
        URI url = URI.create("https://jsonplaceholder.typicode.com/todos/1");
        HttpRequest request = HttpRequest.newBuilder().DELETE().uri(url).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();

        assertThat(statusCode).isEqualTo(200);
    }

    @Test
    void headersTest() throws Exception{
        String token = "token";
        HttpRequest request = HttpRequest.newBuilder().GET().header("Authorization", token).uri(URL).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        assertThat(body).isNotNull();
    }
}