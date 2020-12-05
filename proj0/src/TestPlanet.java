import java.math.*;

/**
 *  Tests calcForceExertedByXY
 */
public class TestPlanet {

    /**
     *  Tests calcForceExertedByXY.
     */
    public static void main(String[] args) {
        checkpairwiseforces();
    }


    /** Checks whether two doubles are approximately equal. 
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  eps         Tolerance for the double comparison.
     */
    private static boolean approxEqual(double actual, double expected, double eps) {
        return Math.abs(expected - actual) <= eps * Math.max(expected, actual);
    }

    /**
     *  Checks whether or not two Doubles are equal and prints the result.
     *
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  label       Label for the 'test' case
     *  @param  eps         Tolerance for the double comparison.
     */
    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (approxEqual(actual, expected, eps)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
            if (approxEqual(actual, expected, eps)) {
                System.out.println("      Hint: Your answer is exactly opposite of the correct answer.");
            }
        }
    }

    /**
     *  Checks the Planet class to make sure calcForceExertedByXY works.
     */
    private static void checkpairwiseforces() {
        System.out.println("Checking pair wise forces...");

        Planet p1 = new Planet(10.0, 2.0, 3.0, 4.0, 2e18, "jupiter.gif");
        Planet p2 = new Planet(23.0, 9.5, 3.0, 4.0, 6e14, "jupiter.gif");

        checkEquals(p1.calcForceExertedBy(p2), 3.6e22, "calcForceExertedByX()", 0.01);
        checkEquals(p2.calcForceExertedBy(p1), -3.6e22, "calcForceExertedByX()", 0.01);
    }
}