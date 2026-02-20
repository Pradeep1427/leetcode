import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new ArrayDeque<>(), min = new ArrayDeque<>();
        int l = 0, ans = 0;

        for(int r = 0; r < nums.length; r++) {
            while(!max.isEmpty() && nums[max.peekLast()] < nums[r]) max.pollLast();
            while(!min.isEmpty() && nums[min.peekLast()] > nums[r]) min.pollLast();
            max.offer(r); 
            min.offer(r);

            while(nums[max.peek()] - nums[min.peek()] > limit) {
                if(max.peek() == l) max.poll();
                if(min.peek() == l) min.poll();
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}