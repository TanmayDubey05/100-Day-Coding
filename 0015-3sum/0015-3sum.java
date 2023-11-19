class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);


    Set<List<Integer>> seen = new HashSet<>();


    for (int i = 0; i < nums.length - 2; i++) {

      int l = i + 1;
      int r = nums.length - 1;


      while (l < r) {

        int sum = nums[i] + nums[l] + nums[r];


        if (sum == 0) {

          List<Integer> triplet = new ArrayList<>();
          triplet.add(nums[i]);
          triplet.add(nums[l]);
          triplet.add(nums[r]);
          seen.add(triplet);

          l++;
          r--;
        } else if (sum > 0) {

          r--;
        } else {

          l++;
        }
      }
    }

    return new ArrayList<>(seen);
    }
}