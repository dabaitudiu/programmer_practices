# 龙与地下城(迷宫得分问题;DP)

- 1. 推右下角最低血量
- 2. 最后一排从右到左推血量
- 3. 倒数第二排往上，每排先推最右元素，之后从右到左推血量

**key point: 在一个位置dp(i,j), 其所需要的最小血量取决于下一步的方向. 注意血量要>=1**

```java
Right: dp[i][j] = max(dp[i][j+1] - m[i][j], 1)
Down: dp[i][j] = max(dp[i+1][j] - m[i][j], 1)
dp[i][j] = min(Right, Down)

```

```java
public static int minHealth(int[][] m) {
        int row = m.length;
        int col = m[0].length;
        int dp[][] = new int[row--][col--];

        // 初始化右下角最小血量
        dp[row][col] = (m[row][col] > 0) ? 1 : 1 - m[row][col];

        // Loop 1: 最后一排的最小血量
        for (int j = col - 1; j >= 0; j--) {
            dp[row][j] = Math.max(dp[row][j + 1] - m[row][j], 1);
        }

        // Loop 2: 从倒数第二排开始，初始化最右格子血量，之后向左迭代
        for (int i = row - 1; i >= 0; i--) {
            dp[i][col] = Math.max(dp[i + 1][col] - m[i][col], 1);

            for (int j = col - 1; j >= 0 ; j--) {
                int right = Math.max(dp[i][j + 1] - m[i][j], 1);
                int down = Math.max(dp[i + 1][j] - m[i][j], 1);
                dp[i][j] = Math.min(right, down);
            }
        }

        return dp[0][0];
    }
```