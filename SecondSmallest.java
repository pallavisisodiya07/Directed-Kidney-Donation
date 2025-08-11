import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * secondSmallest returns the second-smallest integer in arr.
 * Assume arr contains only unique elements and has at least 2 integers.
 * For example, if arr is [1, 7, 4, 3, 6], then secondSmallest(arr) == 3.
 * But, if arr is [6, 1, 4, 3, 5, 2], secondSmallest(arr) == 2.
 */
public class SecondSmallest {
    private static final ForkJoinPool POOL = new ForkJoinPool();
    private static int CUTOFF;

    public static int parallelSecondSmallest(int[] arr, int cutoff) {
        SecondSmallest.CUTOFF = cutoff;
        TwoSmallest result = POOL.invoke(new SecondSmallestTask(arr, 0, arr.length));
        return result.secondSmallest;
    }

    public static TwoSmallest sequentialSecondSmallest(int[] arr, int lo, int hi) {
        // TODO: Step 1. Base Case (i.e. Sequential Case)

        return new TwoSmallest(); // TODO: you will want to change this
    }

    private static class SecondSmallestTask extends RecursiveTask<TwoSmallest> {
        private final int[] arr;
        private final int lo, hi;

        public SecondSmallestTask(int[] arr, int lo, int hi) {
            this.arr = arr;
            this.lo = lo;
            this.hi = hi;
        }

        @Override
        protected TwoSmallest compute() {
            if (hi - lo <= SecondSmallest.CUTOFF) {
                // TODO: Step 1. Base Case (i.e. Sequential Case)
                return new TwoSmallest(); // TODO: you will want to change this
            } else {
                // TODO: Step 2. Recursive Case (i.e. Parallel/Forking case)


                // TODO: Step 3. Combining the left and right tasks' results

                return new TwoSmallest(); // TODO: you will want to change this
            }
        }
    }

    public static class TwoSmallest {
        public int smallest;
        public int secondSmallest;

        public TwoSmallest() {
            smallest = secondSmallest = Integer.MAX_VALUE;
        }
    }
}
