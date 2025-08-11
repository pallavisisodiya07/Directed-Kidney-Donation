public class TestLessThan7 {

    public static void main(String[]args){
        System.out.println(testSequentialLessThan7() ? "Passed!" : "Failed");
        System.out.println(testParallelLessThan7() ? "Passed!" : "Failed");
    }

    public static boolean testSequentialLessThan7() {
        int[] arr = new int[]{21, 7, 6, 8, 17, 1, 7, 7, 1, 1, 7};
        return 4 == LessThan7.sequentialLessThan7(arr, 0, arr.length);
    }

    public static boolean testParallelLessThan7() {
        int[] arr = new int[]{21, 7, 6, 8, 17, 1, 7, 7, 1, 1, 7};
        int cutoff = 1; // Putting the cutoff as 1 makes it FULLY parallel
        return 4 == LessThan7.parallelLessThan7(arr, cutoff);
    }
}