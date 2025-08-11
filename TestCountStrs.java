public class TestCountStrs {

    public static void main(String[]args){
        System.out.println(testCountStrsSequential1() ? "Passed!" : "Failed");
        System.out.println(testCountStrsSequential2() ? "Passed!" : "Failed");
        System.out.println(testCountStrsParallel1() ? "Passed!" : "Failed");
        System.out.println(testCountStrsParallel2() ? "Passed!" : "Failed");
    }
    
    public static boolean testCountStrsSequential1() {
        String[] arr = {"h", "ee", "llll", "llll", "oo", "llll"};
        return CountStrs.sequentialCountStrs(arr, 0, arr.length, "h") == 1;
    }

    public static boolean testCountStrsSequential2() {
        String[] arr = {"h", "ee", "llll", "llll", "oo", "llll"};
        return 1 == CountStrs.sequentialCountStrs(arr, 0, arr.length, "h");
    }

    public static boolean testCountStrsParallel1() {
        String[] arr = {"h", "ee", "llll", "llll", "oo", "llll"};
        int cutoff = 1; // Putting the cutoff as 1 makes it FULLY parallel
        return 3 == CountStrs.parallelCountStrs(arr, cutoff, "llll") &&
               1 == CountStrs.parallelCountStrs(arr, cutoff, "h");
    }

    public static boolean testCountStrsParallel2() {
        String[] arr = {"h", "ee", "llll", "llll", "oo", "llll"};
        int cutoff = 1; // Putting the cutoff as 1 makes it FULLY parallel
        return 1 == CountStrs.parallelCountStrs(arr, cutoff, "h");
    }
}