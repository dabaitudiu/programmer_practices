## 11.DNA序列
### 题目：
牛牛又从生物科研工作者那里获得一个任务,这次牛牛需要帮助科研工作者从DNA序列s中找出最短没有出现在DNA序列s中的DNA片段的长度。
例如:s = AGGTCTA
序列中包含了所有长度为1的('A','C','G','T')片段,但是长度为2的没有全部包含,例如序列中不包含"AA",所以输出2。

### 输入描述：
```
输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 2000),其中只包含'A','C','G','T'这四种字符。
```

### 输出描述：
```
输出一个正整数,即最短没有出现在DNA序列s中的DNA片段的长度。
```

### 示例：
```
输入
AGGTCTA
输出
2
```

### 思路：
又是一道被大神智商碾压的题。
- 以长度i=1， 起始index为0开始，遍历字符串，把每个长度为i的substring丢入hashset
- 该轮结束后，比较4<sup>i</sup>与hashset的长度，一致则进入下一轮，不一致则直接返回

### 解答：
```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        for (int i = 1; i <= n; i++) {
            HashSet<String> hst = new HashSet<String>();
            for (int j = 0; j < n - i; j++) {
                hst.add(s.substring(j,j+i));
            }
            if (hst.size() < Math.pow(4, i)) {
                System.out.println(i);
                return;
            }
        }
    }
}
```