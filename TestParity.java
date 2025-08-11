public class TestParity {
    
    public static void main(String[]args){
        System.out.println(testParitySequentialTrue() ? "Passed!" : "Failed");
        System.out.println(testParitySequentialFalse() ? "Passed!" : "Failed");
        System.out.println(testParityParallelTrue() ? "Passed!" : "Failed");
        System.out.println(testParityParallelFalse() ? "Passed!" : "Failed");
    }

    public static boolean testParitySequentialTrue() {
        int[] arr = new int[]{1, 7, 4, 3, 6};
        return Parity.sequentialParityTask(arr, 0, arr.length);
    }

    
    public static boolean testParitySequentialFalse() {
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
        return !Parity.sequentialParityTask(arr, 0, arr.length);
    }

    
    public static boolean testParityParallelTrue() {
        int[] arr = new int[]{1, 7, 4, 3, 6};
        int cutoff = 1; // Putting the cutoff as 1 makes it FULLY parallel
        return Parity.parallelParityTask(arr, cutoff);
    }

    
    public static boolean testParityParallelFalse() {
        int[] arr = new int[]{6, 5, 4, 3, 2, 1};
        int cutoff = 1; // Putting the cutoff as 1 makes it FULLY parallel
        return !Parity.parallelParityTask(arr, cutoff);
    }
}