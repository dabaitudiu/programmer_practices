## 10. Container with Most Water
- 枚举O(N^2)一定超时
- 参考了网上解答，首位双指针，不断往中间缩进，控制条件为left_index < right_index，遇到更高的水闸就移动index，否则跳过，不断刷新max variable
```java
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
```