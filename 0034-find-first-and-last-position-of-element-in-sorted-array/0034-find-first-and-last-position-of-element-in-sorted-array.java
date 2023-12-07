class Solution {
    public int[] searchRange(int[] nums, int target) {
         int[] ans = {-1 , -1};

        int s = 0;
        int n = nums.length;
        int e = n - 1;
        while(s <= e){
            int mid = e - (e - s)/2;

            if(nums[mid] > target){
                e = mid - 1;
            }else if(nums[mid] < target){
                s = mid + 1;
            }else{
                   
                  
                   // while loop for finding last occurance 
                     int temp = mid;
                   while(temp +1 < n && nums[temp+1] == target){
                       temp++;
                   }
                   // while loop for finding first occurance
                     int temp2 = mid;
                   while(temp2 - 1 >= 0 && nums[temp2 - 1] == target){
                       temp2--;
                   }

                   ans[0] = temp2;
                   ans[1] = temp;

                   break;

            }
        }

        return ans;
    }
}