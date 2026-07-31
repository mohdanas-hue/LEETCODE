import java.util.Arrays;

class Solution {
    public int findClosestNumber(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                i++;
            } else if (Math.abs(nums[i]) < Math.abs(nums[j])) {
                j--;
            } else {
                if (nums[i] < nums[j]) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        return nums[i];
    }
}