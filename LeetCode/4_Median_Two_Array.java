class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] a = nums1;
    int[] b = nums2;
    int len = a.length + b.length;
    int half = len / 2 + 1;
    int[] c = new int[half + 1];
    int indexA = 0;
    int indexB = 0;

    int i;
    for (i = 0; i < half + 1; i++) {
      if (indexA < a.length && indexB < b.length) {
        if (a[indexA] < b[indexB]) {
          c[i] = a[indexA++];
        } else {
          c[i] = b[indexB++];
        }
      } else if (indexA >= a.length) {
        if (indexB < b.length) {
          c[i] = b[indexB++];
        }
      } else if (indexB >= b.length) {
        if (indexA < a.length) {
          c[i] = a[indexA++];
        }
      }
    }
    i--;
    double subResult = 0;
    if (len > 1)
    subResult = (c[i-1] + c[i-2]) / 2.0;
    double result = (len % 2 == 0) ? (subResult) : c[i-1];
    return result;
    }
}
