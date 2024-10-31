package weekone.labs.concurrency.exercisetwo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
  private final int[] array;

    public SumTask(int[] array) {
    this.array = array;
  }

  @Override
  protected Long compute() {
      int threshold = 10;
      if (array.length > threshold) {
      return ForkJoinTask.invokeAll(createSubTasks()).stream().mapToLong(ForkJoinTask::join).sum();
    } else {
      return sum(array);
    }
  }

  private List<SumTask> createSubTasks() {
    List<SumTask> subTasks = new ArrayList<>();
    int mid = array.length / 2;
    int[] left = new int[mid];
    int[] right = new int[array.length - mid];
    System.arraycopy(array, 0, left, 0, mid);
    System.arraycopy(array, mid, right, 0, array.length - mid);
    subTasks.add(new SumTask(left));
    subTasks.add(new SumTask(right));
    return subTasks;
  }

  private long sum(int[] array) {
    long sum = 0;
    for (int i : array) {
      sum += i;
    }
    return sum;
  }
}
