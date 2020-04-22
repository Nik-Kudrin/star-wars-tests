package api.client.route;

import api.client.ApiClient;
import entity.Starship;
import entity.Starships;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class StarshipRoute {
    private String route = "starships";
    private final ApiClient client;

    public StarshipRoute(ApiClient client) {
        this.client = client;
    }

    /**
     * Get all starships
     *
     * @return
     * @throws InterruptedException
     * @throws IOException
     * @throws URISyntaxException
     */
    public ArrayList<Starship> getAll() throws InterruptedException, IOException, URISyntaxException {
        var allStarShips = new ArrayList<Starship>();
        Starships pagedResponse;

        var absoluteUrl = new URL(client.getBaseUrl(), String.format("%s/", route));
        do {
            pagedResponse = client.executeGetRequest(absoluteUrl, Starships.class);
            allStarShips.addAll(pagedResponse.items);
            absoluteUrl = pagedResponse.next;
        }
        while (pagedResponse.next != null);

        return allStarShips;
    }

    /**
     * Get specific starship by ID
     *
     * @param id
     * @return
     * @throws InterruptedException
     * @throws IOException
     * @throws URISyntaxException
     */
    public Starship getById(int id) throws InterruptedException, IOException, URISyntaxException {
        return client.executeGetRequest(String.format("%s/%s/", route, id), Starship.class);
    }
}
