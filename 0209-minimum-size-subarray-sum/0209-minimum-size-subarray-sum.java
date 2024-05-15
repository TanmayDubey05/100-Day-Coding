class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int currSum = 0;
        int minLen = Integer.MAX_VALUE;
        while (r < nums.length) {
            currSum += nums[r];
            while (l <= r && currSum >= target) {
                minLen = Math.min(minLen, r - l + 1);
                currSum -= nums[l++];
            }
            ++r;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}