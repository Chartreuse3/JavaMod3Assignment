import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String carby = "carby";
        String tomatoey = "tomatoey";
        String cheesy = "cheesy";

        VennDiagram<String> foodDiagram = new VennDiagram<>(carby, tomatoey, cheesy);

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

        System.out.println(foodDiagram.unionOf(carby, tomatoey));
        System.out.println(foodDiagram.intersectionOf(tomatoey, cheesy));
        System.out.println(foodDiagram.complementOf(cheesy, carby));
        System.out.println(foodDiagram.diagramCenter());

        VennDiagram<Integer> numberDiagram = new VennDiagram<>("evens", "primes", "fibonacci");

        Set<Integer> evens = new HashSet<>();
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                evens.add(i);
            }
        }

        Set<Integer> primes = new HashSet<>();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);

        Set<Integer> fibonacci = new HashSet<>();
        fibonacci.add(1);
        fibonacci.add(2);
        fibonacci.add(3);
        fibonacci.add(5);
        fibonacci.add(8);

        for (Integer number : evens) numberDiagram.add(number, "evens");
        for (Integer number : primes) numberDiagram.add(number, "primes");
        for (Integer number : fibonacci) numberDiagram.add(number, "fibonacci");

        System.out.println(numberDiagram.unionOf("evens", "primes"));

        System.out.println(numberDiagram.intersectionOf("primes", "fibonacci"));

        Set<Integer> oddFibonacciNumbers = new HashSet<>(numberDiagram.getSet("fibonacci"));
        oddFibonacciNumbers.removeAll(numberDiagram.getSet("evens"));
        System.out.println(oddFibonacciNumbers);

        Set<Integer> evenPrimeAndFibonacci = new HashSet<>(numberDiagram.getSet("evens"));
        evenPrimeAndFibonacci.retainAll(numberDiagram.getSet("primes"));
        evenPrimeAndFibonacci.retainAll(numberDiagram.getSet("fibonacci"));
        System.out.println(evenPrimeAndFibonacci);
    }
}
