class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while(left < right) {
            int min_h = Math.min(height[left], height[right]);
            int area = min_h * (right - left);
            while(height[left] <= min_h && left < right) {
                left += 1;
            }
            while(height[right] <= min_h && left < right) {
                right -= 1;
            }
            max = Math.max(max, area);
        }
        return max;
    }
}