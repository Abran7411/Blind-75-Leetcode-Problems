class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numToIndex = new HashMap<>();
        int numsLength = nums.length;
        for(int i=0; i<numsLength; i++){
                        int complement = target - nums[i];
                        if(numToIndex.containsKey(complement)){
                            return new int[]{numToIndex.get(complement),i};
                        }
                        numToIndex.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two Sum Solutions.");
    }
}
