## 换钱的方法数
###题目：给定数组arr，arr中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim代表要找的钱数，求换钱有多少种方法。

###举例：
```
arr = [5,10,25,1], aim = 0
组成0元的方法有1种，return 1
arr = [5,10,25,1], aim = 15
组成15元的方法有6种 (3*5, 10+5, 10+5*1, 10*1+5, 2*5+5*1, 15*1)
arr = [3,5], aim = 2
任何方法都无法组成2元, return 0
```

#### Step1 : 暴力递归
- 递归要传递的变量:
```
arr - 代表钱的数组
index - 当前使用的钱币
aim - 当前剩余的要达成的目标
```
- 递推结束的条件:
```java
if(index == arr.length):
    result = aim == 0 ? 1 : 0
index 和 arr.length相等代表能用的所有钱数已经用完了，如果还有剩的，说明不能组成
```
完整代码：
```java
public int coins1(int[] arr, int aim) {
    if (arr == null || arr.length == 0 || aim < 0) {
        return 0;
    }
    return countMethod(arr, 0, aim);
}

int countMethod(int[] arr, int index, int aim) {
    int res = 0;
    if (index == arr.length) {
        res = aim == 0 ? 1 : 0;
        return res;
    }
    for (int i = 0; arr[index] * i <= aim; i++) {
        res += countMethod(arr, index + 1, aim - arr[index] * i);
    }
    return res;
}
```