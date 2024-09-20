import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        VennDiagram<Integer> numberDiagram = new VennDiagram<>("evens", "primes", "fibonacci");

        System.out.println("Enter numbers separated by space: ");
        String[] numbersInput = scanner.nextLine().split(" ");

        for (String numStr : numbersInput) {
            int num = Integer.parseInt(numStr);

            if (isEven(num)) {
                numberDiagram.add(num, "evens");
            }

            if (isPrime(num)) {
                numberDiagram.add(num, "primes");
            }

            if (isFibonacci(num)) {
                numberDiagram.add(num, "fibonacci");
            }
        }

        System.out.println("Sorted Union of 'evens' and 'primes': " + numberDiagram.sortedUnionOf("evens", "primes"));
        System.out.println("Sorted Intersection of 'primes' and 'fibonacci': " + numberDiagram.sortedIntersectionOf("primes", "fibonacci"));

        Set<Integer> oddFibonacciNumbers = new HashSet<>(numberDiagram.getSet("fibonacci"));
        oddFibonacciNumbers.removeAll(numberDiagram.getSet("evens"));
        System.out.println("Odd Fibonacci Numbers: " + new TreeSet<>(oddFibonacciNumbers));

        Set<Integer> evenPrimeAndFibonacci = new HashSet<>(numberDiagram.getSet("evens"));
        evenPrimeAndFibonacci.retainAll(numberDiagram.getSet("primes"));
        evenPrimeAndFibonacci.retainAll(numberDiagram.getSet("fibonacci"));
        System.out.println("Numbers in 'evens', 'primes', and 'fibonacci': " + new TreeSet<>(evenPrimeAndFibonacci));
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i != 0) return false;
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
