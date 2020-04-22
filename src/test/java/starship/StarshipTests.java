package starship;

import base.InitTest;
import entity.Starship;
import entity.StarshipClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import validator.StarshipValidator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import static java.util.stream.Collectors.toList;

public class StarshipTests extends InitTest {
    private final Logger log = LogManager.getLogger(StarshipTests.class);

    public StarshipTests() throws MalformedURLException {
    }

    @DataProvider(name = "starShipClassCases")
    public static Object[][] getNumberPairs() {
        return new Object[][]{{StarshipClass.STARFIGHTER, 5}};
    }

    @Test(dataProvider = "starShipClassCases")
    public void searchStarshipByShipClass(StarshipClass starShipClass, int expectedShipsCount) throws InterruptedException, IOException, URISyntaxException {
        var ships = apiClient.getRoutes().getStarshipRoute().getAll();
        var starFighters = ships.stream()
                .filter(item -> item.starshipClass == starShipClass)
                .collect(toList());

        Assert.assertEquals(starFighters.size(), expectedShipsCount);
    }

    @Test(groups = {"Smoke"})
    public void fullFieldsValidation() throws InterruptedException, IOException, URISyntaxException {
        var expectedStarShip = new Starship();
        expectedStarShip.setName("Naboo fighter");
        expectedStarShip.setModel("N-1 starfighter");
        expectedStarShip.setManufacturer("Theed Palace Space Vessel Engineering Corps");
        expectedStarShip.setCostInCredits("200000");
        expectedStarShip.setLength("11");
        expectedStarShip.setMaxAtmospheringSpeed("1100");
        expectedStarShip.setCrew("1");
        expectedStarShip.setPassengers("0");
        expectedStarShip.setCargoCapacity("65");
        expectedStarShip.setHyperdriveRating("1.0");
        expectedStarShip.setMglt("unknown");
        expectedStarShip.starshipClass = StarshipClass.STARFIGHTER;
        expectedStarShip.setCreated("2014-12-19T17:39:17.582000Z");
        expectedStarShip.setEdited("2014-12-20T21:23:49.917000Z");
        expectedStarShip.url = new URL("http://swapi.dev/api/starships/39/");

        var actualStarship = apiClient.getRoutes().getStarshipRoute().getById(39);

        var validator = new StarshipValidator(expectedStarShip, actualStarship);
        validator.validate();
    }
}
