class Solution {
    public int lengthOfLongestSubstring(String s) {
      int len = s.length();
      int[] arr;
      int maxLen = 0;
      for (int i = 0; i < len; i++) {
          arr = new int[128];
          int subLen = 0;
          for (int j = i; j < len; j++) {
              arr[s.charAt(j)]++;
              if (arr[s.charAt(j)] > 1) {
                  break;
              }
              subLen++;
              if (maxLen < subLen) {
                  maxLen = subLen;
              }
          }
      }
    return maxLen;
}
}
