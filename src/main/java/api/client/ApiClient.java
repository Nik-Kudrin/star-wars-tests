package api.client;

import api.client.route.Routes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;

public class ApiClient {
    private final HttpClient client;

    public HttpClient getRawClient() {
        return client;
    }

    private final URL baseUrl;

    public URL getBaseUrl() {
        return baseUrl;
    }

    private final Logger log = LogManager.getLogger(ApiClient.class);

    private Routes routes;

    public Routes getRoutes() {
        return routes;
    }

    public ApiClient(Duration timeout, String baseUrl) throws MalformedURLException {
        client = HttpClient.newBuilder()
                .connectTimeout(timeout)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        this.baseUrl = new URL(baseUrl);
        routes = new Routes(this);
    }

    public <T> T executeGetRequest(URL fullUrl, Class<T> targetType) throws URISyntaxException, IOException, InterruptedException {
        var request = HttpRequest.newBuilder(fullUrl.toURI())
                .GET()
                .build();

        log.info("Send request to: " + fullUrl);

        var object = client.send(request, new JsonBodyHandler<>(targetType))
                .body()
                .get();

        return object;
    }

    public <T> T executeGetRequest(String relativeUrl, Class<T> targetType) throws URISyntaxException, IOException, InterruptedException {
        var url = new URL(baseUrl, relativeUrl);
        return executeGetRequest(url, targetType);
    }
}
