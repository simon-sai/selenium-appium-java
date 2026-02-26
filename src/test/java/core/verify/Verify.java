/**
 * @author Duc Simon
 */
package core.verify;

public class Verify {

    public static EqualAssert GetEqualAssert() {
        return new EqualAssert();
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
