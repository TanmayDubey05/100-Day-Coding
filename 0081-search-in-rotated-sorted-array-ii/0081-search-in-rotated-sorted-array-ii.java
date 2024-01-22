class Solution {
    public boolean search(int[] nums, int target) {
        boolean b = false;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==target){
                b = true;
                break;
            }
        }
        return b;
    }
}