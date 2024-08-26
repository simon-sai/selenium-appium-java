/**
 * @author Duc Simon
 */
package core.verify;

public class Verify {

    protected static EqualAssert equalAssert;

    public static EqualAssert GetEqualAssert() {
        if (equalAssert == null) {
            equalAssert = new EqualAssert();
        }
        return equalAssert;
    }

    public static void IsTrue(boolean actual) {
        GetEqualAssert().IsTrue(actual);
    }

    public static void Equal(String textActual, String textExpected) {
        GetEqualAssert().Equal(textActual, textExpected);
    }

    public static void Equal(int numberActual, int numberExpected) {
        GetEqualAssert().Equal(numberActual, numberExpected);
    }
}
