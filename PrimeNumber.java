public class PrimeNumber {

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        // Negative numbers, 0 and 1 are not prime numbers
        if (number <= 1) {
            return false;
        }
        // Check from 2 to the square root of the number
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Main method to test the isPrime method
    public static void main(String[] args) {
        int num = 29;
        if (isPrime(num)) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }
}
