import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * countStrs returns the number of elements in arr that equal targetStr.
 * For example, if arr is ["h", "ee", "llll", "llll", "oo", "llll"],
 * then countStrs(arr, "llll") == 3 and countStrs(arr, "h") == 1.
 */
public class CountStrs {
    private static final ForkJoinPool POOL = new ForkJoinPool();
    private static int CUTOFF;
    private static String targetStr;

    public static int parallelCountStrs(String[] arr, int cutoff, String targetStr) {
        CountStrs.CUTOFF = cutoff;
        CountStrs.targetStr = targetStr;
        return POOL.invoke(new CountStrsTask(arr, 0, arr.length));
    }

    public static int sequentialCountStrs(String[] arr, int lo, int hi, String targetStr) {
        // TODO: Step 1. Base Case (i.e. Sequential Case)
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (targetStr.equals(arr[i])) {
                count++;
            }
        }
        return count; // TODO: you will want to change this
    }

    private static class CountStrsTask extends RecursiveTask<Integer> {
        private final String[] arr;
        private final int lo, hi;

        public CountStrsTask(String[] arr, int lo, int hi) {
            this.arr = arr;
            this.lo = lo;
            this.hi = hi;
        }

        @Override
        protected Integer compute() {
            if (hi - lo <= CountStrs.CUTOFF) {
                return CountStrsTask(arr,lo,hi,targetStr)
            } else {

                    int mid = lo + (hi - lo) / 2;
                    CountStrsTask leftTask = new CountStrsTask(arr, lo, mid);
                    CountStrsTask rightTask = new CountStrsTask(arr, mid , hi);

                    leftTask.fork();
                    int rightResult = rightTask.compute();
                    int leftResult = leftTask.join();


                return rightResult + leftResult; // TODO: you will want to change this
            }
        }
    }
}
