package base;

import api.client.ApiClient;

import java.net.MalformedURLException;

public class InitTest {
    protected final Config config = Config.Instance();
    protected final ApiClient apiClient = new ApiClient(config.getTimeout(), config.getBaseUrl().toString());

    public InitTest() throws MalformedURLException {
    }
}
