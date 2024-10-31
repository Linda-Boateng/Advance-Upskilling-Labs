package weekone.labs.concurrency.exercisetwo;
/**
 * Main class for the exercise two.
 * This exercise implements RecursiveTask to sum an array of integers.
 * The array is divided into sub-arrays until the threshold is reached.
 * The threshold is set to 10.
 * If the array length is greater than the threshold, the array is divided into two sub-arrays.
 * The sum of the sub-arrays is calculated using ForkJoinTask.invokeAll() and ForkJoinTask::join.
 * If the array length is less than or equal to the threshold, the sum is calculated using a for loop.
 * The sum of the sub-arrays is returned.
 *
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,32,7,11,23,45,67,89,50};
        SumTask task = new SumTask(array);
        long result = task.compute();
        System.out.println("Sum: " + result);
    }
}
