/**
 * @author Duc Simon
 */
package core.verify;

public class EqualAssert extends AbstractAssert {
    public void IsTrue(boolean actual) {
        boolean status = actual == true;
        if (status) {
            this.VerifyPass(String.format("actual result is [%s], which is correct", actual));
        } else {
            this.VerifyFail(String.format("actual result is [%s], it supposed to be [True]", actual));
        }
    }

    public void IsNotTrue(boolean actual) {
        boolean status = actual != true;
        if (status) {
            this.VerifyPass(String.format("actual result is [%s], which is correct", actual));
        } else {
            this.VerifyFail(String.format("actual result is [%s], it supposed to be [False]", actual));
        }
    }

    public void Equal(String textActual, String textExpected) {
        String lowerTExtActual = textActual.toLowerCase();
        boolean status = lowerTExtActual.equals(textExpected.toLowerCase());
        if (status) {
            this.VerifyPass(String.format("actual text `%s` equal to expect text `%s`", textActual, textExpected));
        } else {
            this.VerifyFail(String.format("actual text `%s` NOT equal to expect text `%s`", textActual, textExpected));
        }
    }

    public void Equal(int numberActual, int numberExpected) {
        boolean status = numberActual == numberExpected;
        if (status) {
            this.VerifyPass(
                    String.format("actual number `%d` equal to expect number `%d`", numberActual, numberExpected));
        } else {
            this.VerifyFail(
                    String.format("actual number `%s` NOT equal to expect number `%s`", numberActual, numberExpected));
        }
    }

    public void NotEmpty(String textActual) {
        boolean status = !textActual.isEmpty();
        if (status) {
            this.VerifyPass(String.format("actual text NOT empty `%s`", textActual));
        } else {
            this.VerifyFail(String.format("actual text IS empty `%s`", textActual));
        }
    }

    public void IsEmpty(String textActual) {
        boolean status = textActual.isEmpty();
        if (status) {
            this.VerifyPass(String.format("actual text IS empty `%s`", textActual));
        } else {
            this.VerifyFail(String.format("actual text NOT empty `%s`", textActual));
        }
    }
}
