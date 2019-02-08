class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mp = new HashMap();
        int[] a = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (mp.get(target - nums[i]) == null) {
                mp.put(nums[i],i);
            } else {
                a[0] = mp.get(target - nums[i]);
                a[1] = i;
                return a;
            }
        }
        return a;
    }
}
