public class TestPowMod {

    public static void main(String[]args){
        System.out.println(testPowModSequential() ? "Passed!" : "Failed");
        System.out.println(testPowModParallel() ? "Passed!" : "Failed");
    }

    public static boolean testPowModSequential() {
        int[] arr = {1, 7, 4, 3, 6};
        int pow = 6;
        int mod = 5000;
        int[] expected = {1, 2649, 4096, 729, 1656};

        PowMod.sequentialPowMod(arr, 0, arr.length, pow, mod);
        if(expected.length != arr.length){
            return false;
        }
        for(int i = 0; i < expected.length; i++){
            if(arr[i] != expected[i]){
                return false;
            }
        }
        return true;
    }


    public static boolean testPowModParallel() {
        int[] arr = {1, 7, 4, 3, 6};
        int cutoff = 1; // Putting the cutoff as 1 makes it FULLY parallel
        int pow = 6;
        int mod = 5000;
        int[] expected = {1, 2649, 4096, 729, 1656};

        PowMod.parallelPowMod(arr, cutoff, pow, mod);
        if(expected.length != arr.length){
            return false;
        }
        for(int i = 0; i < expected.length; i++){
            if(arr[i] != expected[i]){
                return false;
            }
        }
        return true;
    }
}