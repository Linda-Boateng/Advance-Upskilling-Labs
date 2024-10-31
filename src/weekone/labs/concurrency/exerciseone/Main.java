package weekone.labs.concurrency.exerciseone;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

/**
 * Main class to run the Fibonacci program using fork/join framework
 * to calculate the nth Fibonacci number
 * The fork/join framework is a parallel programming framework that is part of the Java SE 7
 * Fork/join framework is designed to recursively split a task into smaller independent tasks
 * and then combine the results of subtasks to produce the final result
 * The fork/join framework is based on the ExecutorService interface and the ForkJoinPool class
 * The ForkJoinPool class is similar to the ExecutorService interface but is designed to work with ForkJoinTask.
 * ForkJoinTask is an abstract class that represents a task that can be forked and joined
 * RecursiveTask is a subclass of ForkJoinTask that represents a task that returns a result
 * RecursiveAction is a subclass of ForkJoinTask that represents a task that does not return a result
 * In this example, we use the RecursiveTask class to calculate the nth Fibonacci number
 */
public class Main {
    public static void main(String[] args) {
        int n;
        int result;
        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the number of Fibonacci numbers to generate: ");
            n = scanner.nextInt();
            Fibonacci fibonacci = new Fibonacci(n);
            result = forkJoinPool.invoke(fibonacci);
        }
        System.out.println("The " + n + "th Fibonacci number is: " + result);

    }
}
