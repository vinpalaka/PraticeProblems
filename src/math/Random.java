package math;

public class Random {
    private int[] orig;
    private int[] nums;
    public Random(int[] nums) {
        this.nums = nums;
        this.orig = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        nums = this.orig;
        this.orig = this.orig.clone();
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums.length > 0) {
            int randomIndex = 0;
            int randomIndex2 = 0;
            while(randomIndex == randomIndex2) {
                randomIndex = (int) (Math.random() * (nums.length -1));
                randomIndex2 = (int ) (Math.random() * (nums.length -1));
            }
            swap(nums, randomIndex, randomIndex2);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
