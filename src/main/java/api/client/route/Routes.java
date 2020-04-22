package api.client.route;

import api.client.ApiClient;

public class Routes {
    private final StarshipRoute starshipRoute;

    public StarshipRoute getStarshipRoute() {
        return starshipRoute;
    }

    public Routes(ApiClient client) {
        starshipRoute = new StarshipRoute(client);
    }
}
