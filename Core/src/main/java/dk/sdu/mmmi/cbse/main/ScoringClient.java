package dk.sdu.mmmi.cbse.main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ScoringClient {
    private static final String BASE_URI = "http://localhost:8082/score";

    private final HttpClient client = HttpClient.newHttpClient();

    public Long getScore() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return Long.parseLong(response.body());
    }

    public Long addScore(Long points) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URI + "/add?point=" + points))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return Long.parseLong(response.body());
    }
}
