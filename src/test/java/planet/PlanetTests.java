package planet;

import base.InitTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PlanetTests extends InitTest {
    private final Logger log = LogManager.getLogger(PlanetTests.class);

    public PlanetTests() throws MalformedURLException {
    }

    @Test(groups = {"Smoke"})
    public void checkThereIsNoPlanetWithZeroId() throws InterruptedException, IOException, URISyntaxException {
        var url = new URL(config.getBaseUrl(), "planets/0/");

        var client = apiClient.getRawClient();
        var request = HttpRequest.newBuilder(url.toURI())
                .GET().build();

        var httpStatusCode = client.send(request, HttpResponse.BodyHandlers.ofString())
                .statusCode();

        Assert.assertEquals(httpStatusCode, 404, "Planet with id = 0 should not exist");
    }
}
