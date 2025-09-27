import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>(); // stores indices

        for(int i = 0; i < n; i++){
            // remove indices out of current window
            while(!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            // remove indices whose values are less than current
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();

            dq.offerLast(i);

            // window has reached size k
            if(i >= k - 1)
                res[i - k + 1] = nums[dq.peekFirst()];
        }

        return res;
    }
}
