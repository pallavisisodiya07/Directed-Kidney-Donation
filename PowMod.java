import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * powMod replaces every element of arr with arr[i]^p mod m.
 * For example, if arr is [1, 7, 4, 3, 6], then powmod(arr, 2, 5)
 * would result in arr = [1, 4, 1, 4, 1].
 */
public class PowMod {
    private static final ForkJoinPool POOL = new ForkJoinPool();
    private static int CUTOFF;
    private static int pow, mod;

    public static void parallelPowMod(int[] arr, int cutoff, int pow, int mod) {
        CUTOFF = cutoff;
        PowMod.pow = pow;
        PowMod.mod = mod;
        POOL.invoke(new PowModTask(arr, 0, arr.length));
    }

    public static void sequentialPowMod(int[] arr, int lo, int hi, int pow, int mod) {
        for (int i = lo; i <= hi; i++) {
            arr[i] = math.pow(arr[i],pow)%mod;
        }
        POOL.invoke(new PowModTask(arr, 0, arr.length));

    }

    private static class PowModTask extends RecursiveAction {
        private final int[] arr;
        private final int lo, hi;

        public PowModTask(int[] arr, int lo, int hi) {
            this.arr = arr;
            this.lo = lo;
            this.hi = hi;
        }

        @Override
        protected void compute() {
            if (hi - lo <= PowMod.CUTOFF) {
                return sequentialPowMod(arr, lo, hi, pow, mod)

            } else {
                // TODO: Step 2. Recursive Case (i.e. Parallel/Forking case)
                int mid = lo + (hi - lo) / 2;
                PowModTask leftTask = new PowModTask(arr, lo, mid);
                PowModTask rightTask = new PowModTask(arr, mid + 1, hi);
                leftTask.fork();
                rightTask.compute();
                leftTask.join();

            }
        }
    }
}
