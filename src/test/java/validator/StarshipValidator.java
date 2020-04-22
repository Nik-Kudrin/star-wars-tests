package validator;

import entity.Starship;
import org.testng.asserts.SoftAssert;

public class StarshipValidator extends BaseValidator<Starship> {

    public StarshipValidator(Starship expected, Starship actual) {
        super(expected, actual);
    }

    public void validate() {
        validateBaseInfo();

        var softAssert = new SoftAssert();

        softAssert.assertEquals(actual.getCargoCapacity(), expected.getCargoCapacity());
        softAssert.assertEquals(actual.getManufacturer(), expected.getManufacturer());
        softAssert.assertEquals(actual.getMaxAtmospheringSpeed(), expected.getMaxAtmospheringSpeed());
        softAssert.assertEquals(actual.getMglt(), expected.getMglt());
        softAssert.assertEquals(actual.getModel(), expected.getModel());
        softAssert.assertEquals(actual.getName(), expected.getName());
        softAssert.assertEquals(actual.getCostInCredits(), expected.getCostInCredits());
        softAssert.assertEquals(actual.getCrew(), expected.getCrew());
        softAssert.assertEquals(actual.getHyperdriveRating(), expected.getHyperdriveRating());
        softAssert.assertEquals(actual.getLength(), expected.getLength());
        softAssert.assertEquals(actual.getPassengers(), expected.getPassengers());

        softAssert.assertAll();
    }
}
