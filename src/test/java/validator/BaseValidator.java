package validator;

import entity.EntityBase;
import org.testng.asserts.SoftAssert;

public class BaseValidator<T extends EntityBase> {
    protected final T actual;
    protected final T expected;

    public BaseValidator(T expected, T actual) {
        this.expected = expected;
        this.actual = actual;
    }

    public void validateBaseInfo() {
        var softAssert = new SoftAssert();

        softAssert.assertEquals(actual.url, expected.url, "Url should be the same");
        softAssert.assertEquals(actual.getCreated(), expected.getCreated(), "Created date should be the same");
        softAssert.assertEquals(actual.getEdited(), expected.getEdited(), "Edited date should be the same");

        softAssert.assertAll();
    }
}
