import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            // remove elements out of window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            // remove smaller elements
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();

            dq.offerLast(i);

            // store result when first window is ready
            if (i >= k - 1)
                res[idx++] = nums[dq.peekFirst()];
        }
        return res;
    }
}