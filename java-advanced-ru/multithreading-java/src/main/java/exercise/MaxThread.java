package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread {
    private int[] nums;
    private int maxNumber;

    public MaxThread(int[] nums) {
        this.nums = nums;
    }

    public int getMaxNumber() {
        return this.maxNumber;
    }

    @Override
    public void run() {
        Arrays.sort(nums);
        this.maxNumber = nums[nums.length - 1];
    }
}
// END
