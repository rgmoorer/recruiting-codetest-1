public class Code {

    // Returns "Hello World!"
    public static String helloWorld() {
        return "Hello World!";
    }

    // Take a single-spaced <sentence>, and capitalize every <n> word starting with <offset>.
    public static String capitalizeEveryNthWord(String sentence, Integer offset, Integer n) {

        // Let's split each word into a string array (ignoring any extra white spaces just in case)
        String[] splitString = sentence.split("\\s+");

        // Now run through each word and capitalize first letter based on offset and every <n> word
        for (int i=offset; i<splitString.length; i=i+n) {
            splitString[i] = splitString[i].substring(0,1).toUpperCase() + splitString[i].substring(1);
        }

        // Finally combine the string array into one string and spit it out
        String combinedString = String.join(" ", splitString);
        return combinedString;
    }

    // Determine if a number is prime
    public static Boolean isPrime(Integer n) {

        // First, any int less than 2 will not be prime
        if (n < 2)
            return false;

        // Otherwise let's step through and check for a mod of 0 (not most efficient but works)
        for (int i=2; i<n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // Calculate the golden ratio.
    // Given two numbers a and b with a > b > 0, the ratio is b / a.
    // Let c = a + b, then the ratio c / b is closer to the golden ratio.
    // Let d = b + c, then the ratio d / c is closer to the golden ratio.
    // Let e = c + d, then the ratio e / d is closer to the golden ratio.
    // If you continue this process, the result will trend towards the golden ratio.
    public static Double goldenRatio(Double a, Double b) {

        // First create variables to hold old and new data
        double total = a + b;
        double newA = b;
        double newB = total;

        // Next loop through to update old and new data several times
        for (int i=0; i<1000; i++) {
            total = newA + newB;
            newA = newB;
            newB = total;
        }

        // Last spit out our golden ratio approximation (b / a)
        return newB / newA;

    }

    // Give the nth Fibionacci number
    // Starting with 1 and 1, a Fibionacci number is the sum of the previous two.
    public static Integer fibionacci(Integer n) {

        // If n is 1 or less we can simply return n
        // Additionally this acts as a stopping point for the recursive statement below
        if (n <= 1)
            return n;

        // F(n) = F(n-1) + F(n-2)
        // We can do this recursively
        else return fibionacci(n-1) + fibionacci(n-2);
    }

    // Give the square root of a number
    // Using a binary search algorithm, search for the square root of a given number.
    // Do not use the built-in square root function.
    public static Double squareRoot(Double n) {

        // Below code finds answer but fails due to 5000ms timeout, not sure why
        /*
        double low = 0;
        double high = n;
        double mid = 0;
        while (mid * mid != n) {
            mid = (low + high) / 2;
            if (mid * mid < n)
                low = mid;
            else high = mid;
        }
        return mid;
        */

        // Set variables for low bound, high bound, and average
        double lowBound = 0;
        double highBound = n;
        double average = 0;

        // Let's loop through several times so average becomes the square root of <n>
        for (int i=0; i<1000;i++) {
            // Find average between low and high bounds
            average = (lowBound + highBound) / 2;
            // If our average is the square root of <n>, we found it so break out of loop
            if (average * average == n)
                break;
            // Otherwise if average is smaller than square root, low bound becomes value of average
            else if (average * average < n)
                lowBound = average;
            // Otherwise high bound becomes value of average
            else highBound = average;
        }
        return average;
    }
}
