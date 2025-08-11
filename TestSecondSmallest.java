
public class TestSecondSmallest {

    public static void main(String[]args){
        System.out.println(testSecondSmallestSequential1() ? "Passed!" : "Failed");
        System.out.println(testSecondSmallestSequential2() ? "Passed!" : "Failed");
        System.out.println(testSecondSmallestParallel1() ? "Passed!" : "Failed");
        System.out.println(testSecondSmallestParallel2() ? "Passed!" : "Failed");
    }
    
    public static boolean testSecondSmallestSequential1() {
        int[] arr = new int[]{1, 7, 4, 3, 6};
        return 3 == SecondSmallest.sequentialSecondSmallest(arr, 0, arr.length).secondSmallest;
    }

    public static boolean testSecondSmallestSequential2() {
        int[] arr = new int[]{6, 1, 4, 3, 5, 2};
        return 2 == SecondSmallest.sequentialSecondSmallest(arr, 0, arr.length).secondSmallest;
    }

    public static boolean testSecondSmallestParallel1() {
        int[] arr = new int[]{1, 7, 4, 3, 6};
        return 3 == SecondSmallest.parallelSecondSmallest(arr, 1);
    }

    public static boolean testSecondSmallestParallel2() {
        int[] arr = new int[]{6, 1, 4, 3, 5, 2};
        return 2 == SecondSmallest.parallelSecondSmallest(arr, 1);
    }
}
