class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length, sum = 0, left = 0;
        for (int x : nums) sum += x;

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int right = sum - left - nums[i];
            ans[i] = nums[i] * i - left + right - nums[i] * (n - i - 1);
            left += nums[i];
        }
        return ans;
    }
}
