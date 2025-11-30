public class BisectionMethod  {
    // eq = x cube + 4 x square - 3 x + 6
    public static double f(double x) {
        return x*x*x + 4*x*x - 3*x + 6;
    }

    public static void main(String[] args) {
        // choose intervals form -10 to 10 to test
        double a = -3;    // Left bound
        double b = -5;    // Right bound
        double tolerance = 0.0001;
        double c = 0;

        // Check that f(a) and f(b) have opposite signs
        if (f(a) * f(b) >= 0) {
            System.out.println("Bisection Method not applicable. Change interval.");
            return;
        }

        while ((b - a) >= tolerance) {
            // Midpoint
            c = (a + b) / 2;

            // Check if exact root
            if (f(c) == 0.0) {
                break;
            }

            // if true means root lies btw a and c make b = c
            if (f(a) * f(c) < 0)
                b = c;

            // else root lies btw b and c and make a = c
            else
                a = c;
        }

        System.out.printf("Root is approximately: %.6f\n", c);
        System.out.println("f(root) = " + f(c));
    }
}