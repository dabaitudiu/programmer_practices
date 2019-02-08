这是一个easy题，但还是搞了半天，水平真的不行。
第一次提速度排后20%多，有几个点：
1. long 用long存储数据然后比较把问题简化很多
2. 边界条件 x!=0， 省去了符号判断
3. （非优化） Integer.MAX_VALUE和Integer.MIN_VALUE可以直接用 

class Solution {
    public int reverse(int x) {
       long sum = 0;
        while (x != 0) {
            sum *= 10;
            sum += x % 10;
            x /= 10;
        }
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)sum;
    }
}