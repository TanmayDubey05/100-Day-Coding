class Solution {
    public int maxProduct(int[] nums) {
        int maxL = nums[0];
        int maxR = nums[0];
        int pro = 1;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            pro = pro * nums[i];
            if (pro == 0) {
                flag = true;
                pro = 1;
                continue;
            }
            maxL = Math.max(pro, maxL);
        }
        pro = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            pro = nums[i] * pro;
            if (pro == 0) {
                flag = true;
                pro = 1;
                continue;
            }
            maxR = Math.max(maxR, pro);
        }
        if (flag) {
            return Math.max(Math.max(maxR, maxL), 0);
        }
        return Math.max(maxR, maxL);
    }
}