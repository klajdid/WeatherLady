package services;

import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class ServiceCall implements Iservice {

    private String url;

    public ServiceCall(String url) {
        this.url = url;
    }

    public String getResponse() throws Exception {
        return get(url);
    }

    private String get(String uri) throws Exception {

        URL url = new URL(uri);

        URI _uri = url.toURI();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(_uri)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

}
