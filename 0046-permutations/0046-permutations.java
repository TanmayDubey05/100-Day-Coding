class Solution {
    public List<List<Integer>> permute(int[] nums) {
       if (nums.length == 1) {
            List<List<Integer>> permutations = new ArrayList<>();
            List<Integer> permutation = new ArrayList<>();
            permutation.add(nums[0]);
            permutations.add(permutation);
            return permutations;
        }

        List<List<Integer>> permutations = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int[] remainingNums = new int[nums.length - 1];
            System.arraycopy(nums, 0, remainingNums, 0, i);
            System.arraycopy(nums, i + 1, remainingNums, i, nums.length - 1 - i);

            for (List<Integer> remainingPermutation : permute(remainingNums)) {
                List<Integer> newPermutation = new ArrayList<>();
                newPermutation.add(currentNum);
                newPermutation.addAll(remainingPermutation);
                permutations.add(newPermutation);
            }
        }

        return permutations; 
    }
}