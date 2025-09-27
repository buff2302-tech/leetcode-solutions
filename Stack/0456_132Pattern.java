import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE; // candidate for nums[k]

        // Traverse from right to left
        for (int j = n - 1; j >= 0; j--) {
            // nums[i] < third means 132 exists
            if (nums[j] < third) {
                return true;
            }

            // While nums[j] > stack top, pop and update "third"
            while (!stack.isEmpty() && nums[j] > stack.peek()) {
                third = stack.pop();
            }

            // Push current nums[j] as a candidate for "2"
            stack.push(nums[j]);
        }

        return false;
    }
}
