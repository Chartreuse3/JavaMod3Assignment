import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // Food example
        String carby = "carby";
        String tomatoey = "tomatoey";
        String cheesy = "cheesy";

        VennDiagram<String> foodDiagram = new VennDiagram<>(carby, tomatoey, cheesy);
        // Add food items (hardcoded)
        foodDiagram.add("Croissant", carby);
        foodDiagram.add("Roll", carby);
        foodDiagram.add("Toast", carby);
        foodDiagram.add("Grilled Cheese", carby, cheesy);
        foodDiagram.add("Mac and Cheese", carby, cheesy);
        foodDiagram.add("Cheese and Crackers", carby, cheesy);
        foodDiagram.add("Bagel and Cream Cheese", carby, cheesy);
        foodDiagram.add("Spaghetti Marinara", carby, tomatoey);
        foodDiagram.add("Tomato Sandwich", carby, tomatoey);
        foodDiagram.add("Lasagna", carby, tomatoey, cheesy);
        foodDiagram.add("Tomato Soup and Goldfish Crackers", carby, tomatoey, cheesy);
        foodDiagram.add("Pizza Margherita", carby, tomatoey, cheesy);
        foodDiagram.add("Tomato and Mozzarella Sandwich", carby, tomatoey, cheesy);
        foodDiagram.add("Tomato Slices", tomatoey);
        foodDiagram.add("Tomato Wedges", tomatoey);
        foodDiagram.add("Grape Tomatoes", tomatoey);
        foodDiagram.add("Caprese Salad", tomatoey, cheesy);
        foodDiagram.add("Greek Salad", tomatoey, cheesy);
        foodDiagram.add("Mozzarella Sticks", cheesy);
        foodDiagram.add("String Cheese", cheesy);
        foodDiagram.add("Cheese Cubes", cheesy);
        foodDiagram.add("Fresh Mozzarella", cheesy);

        // Output for food items
        System.out.println("Food Diagram Results:");
        System.out.println("Union of 'carby' and 'tomatoey': " + foodDiagram.unionOf(carby, tomatoey));
        System.out.println("Intersection of 'tomatoey' and 'cheesy': " + foodDiagram.intersectionOf(tomatoey, cheesy));
        System.out.println("Complement of 'cheesy' from 'carby': " + foodDiagram.complementOf(cheesy, carby));
        System.out.println("Center of the Food Diagram: " + foodDiagram.diagramCenter());

        // Integer example with hardcoded values for evens, primes, and Fibonacci
        VennDiagram<Integer> numberDiagram = new VennDiagram<>("evens", "primes", "fibonacci");

        // Hardcoded values
        int[] predefinedNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] evens = {2, 4, 6, 8, 10};
        int[] primes = {2, 3, 5, 7};
        int[] fibonacci = {1, 1, 2, 3, 5, 8};

        // Add hardcoded values to the Venn diagram
        for (int num : evens) numberDiagram.add(num, "evens");
        for (int num : primes) numberDiagram.add(num, "primes");
        for (int num : fibonacci) numberDiagram.add(num, "fibonacci");

        // Display results for predefined numbers
        System.out.println("\nPredefined Numbers Results:");
        System.out.println("Sorted Union of 'evens' and 'primes': " + numberDiagram.unionOf("evens", "primes"));
        System.out.println("Sorted Intersection of 'primes' and 'fibonacci': " + numberDiagram.intersectionOf("primes", "fibonacci"));

        // User input
        Scanner scanner = new Scanner(System.in);
        VennDiagram<Integer> userNumberDiagram = new VennDiagram<>("evens", "primes", "fibonacci");

        System.out.println("\nEnter numbers separated by space: ");
        String[] numbersInput = scanner.nextLine().split(" ");

        for (String numStr : numbersInput) {
            int num = Integer.parseInt(numStr);
            if (isEven(num)) userNumberDiagram.add(num, "evens");
            if (isPrime(num)) userNumberDiagram.add(num, "primes");
            if (isFibonacci(num)) userNumberDiagram.add(num, "fibonacci");
        }

        // Display results for user input
        System.out.println("\nUser Input Results:");
        System.out.println("Sorted Union of 'evens' and 'primes': " + userNumberDiagram.unionOf("evens", "primes"));
        System.out.println("Sorted Intersection of 'primes' and 'fibonacci': " + userNumberDiagram.intersectionOf("primes", "fibonacci"));

        Set<Integer> oddFibonacciNumbers = new HashSet<>(userNumberDiagram.getSet("fibonacci"));
        oddFibonacciNumbers.removeAll(userNumberDiagram.getSet("evens"));
        System.out.println("User Input Odd Fibonacci Numbers: " + oddFibonacciNumbers);

        Set<Integer> evenPrimeAndFibonacci = new HashSet<>(userNumberDiagram.getSet("evens"));
        evenPrimeAndFibonacci.retainAll(userNumberDiagram.getSet("primes"));
        evenPrimeAndFibonacci.retainAll(userNumberDiagram.getSet("fibonacci"));
        System.out.println("User Input Numbers in 'evens', 'primes', and 'fibonacci': " + evenPrimeAndFibonacci);
    }

    // Helper methods
    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private static boolean isFibonacci(int num) {
        int x1 = 5 * num * num + 4;
        int x2 = 5 * num * num - 4;
        return isPerfectSquare(x1) || isPerfectSquare(x2);
    }

    private static boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return s * s == x;
    }
}
