import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * parity returns true if there are even number of even numbers and false otherwise.
 * For example, if arr is [1, 7, 4, 3, 6], then parity(arr) == true.
 * But, if arr is [6, 5, 4, 3, 2, 1], parity(arr) == false.
 */
public class Parity {
    private static final ForkJoinPool POOL = new ForkJoinPool();
    private static int CUTOFF;

    public static boolean parallelParityTask(int[] arr, int cutoff) {
        Parity.CUTOFF = cutoff;
        return POOL.invoke(new ParityTask(arr, 0, arr.length));
    }

    public static boolean sequentialParityTask(int[] arr, int lo, int hi) {
        // TODO: Step 1. Base Case (i.e. Sequential Case)

        return true; // TODO: you will want to change this
    }

    private static class ParityTask extends RecursiveTask<Boolean> {
        private final int[] arr;
        private final int lo, hi;

        public ParityTask(int[] arr, int lo, int hi) {
            this.arr = arr;
            this.lo = lo;
            this.hi = hi;
        }

        @Override
        protected Boolean compute() {
            if (hi - lo <= CUTOFF) {
                // TODO: Step 1. Base Case (i.e. Sequential Case)
                return true; // TODO: you will want to change this
            } else {
                // TODO: Step 2. Recursive Case (i.e. Parallel/Forking case)


                // TODO: Step 3. Combining the left and right tasks' results

                return true; // TODO: you will want to change this
            }
        }
    }
}
