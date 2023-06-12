package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {
    private int[] nums;
    private int minNumber;

    public MinThread(int[] nums) {
        this.nums = nums;
    }

    public int getMinNumber() {
        return minNumber;
    }

    @Override
    public void run() {
        Arrays.sort(nums);
        minNumber = nums[0];
    }
}
// END
