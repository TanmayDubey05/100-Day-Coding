class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
              int k=  map.get(nums[i]);
              map.put(nums[i],k+1);
            }
        }
  for(Map.Entry<Integer,Integer> entry: map.entrySet()){
      int value=entry.getValue();
      if(value==1){
           res=entry.getKey();
          break;
      }
  }

      return res;  
    }
}