/*
这道题我做了1个多小时才通过，考虑太不细致，有几个点：
1. 审题首先错误，题干内容可精炼为：(1) 去空格 (2) 检查正负号 (3) 生成数字的过程中一旦又出现字符，后面全部省略 (4) 不能超Integer范围
2. 首先由第七题联想到了用long，然而test cases里有比long还要大的数，这样在计算过程中就出现了overflow
   解决：把检查是否超2^31-1 的步骤放在每次generate number之后
3. 以下是提交的code，冗长，有很多地方可以简化。逻辑是：第一个for：去空格; 检测第一个字符是否为数字:
                                                             若非数字，(1) 检测是否为符号，若有符号，index后移一位，进入下一个for，
                                                                      (2) 若不是符号，即首字母非数字，return 0；
                                                             若是数字，什么都不做，进入下一个for
                                                   第二个for: 首字母非数字，return 0； else 并入 number
可见，重复的地方非常多。而且提交了n多次才pass。欠练。
*/

public static int atoi(String s) {
        long sum = 0;
        char c;
        int i;
        int flag = 0;

        for (i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            boolean range = (c >= 48) && (c <= 57);
            if (c == 32) {
                continue;
            }
            if (!range) {
                if (c == 45 || c == 43) {
                    if (c == 45) {
                        flag = 1;
                    }
                    i++;
                    break;
                } else {
                    return 0;
                }
            } else {
                break;
            }
        }
        String v = s.substring(i);
        for (i = 0; i < v.length(); i++) {
            c = v.charAt(i);
            boolean range = (c >= 48) && (c <= 57);
            if (range) {
                sum *= 10;
                sum += (c - 48);
                if (sum > Integer.MAX_VALUE) {
                    if (flag == 1) {
                        return Integer.MIN_VALUE;
                    } else {
                        return  Integer.MAX_VALUE;
                    }
                }
                if (sum < Integer.MIN_VALUE) {
                    if (flag == 1) {
                        return Integer.MIN_VALUE;
                    } else {
                        return  Integer.MAX_VALUE;
                    }
                }
            } else {
                if (i == 0) {
                    return 0;
                }
                break;
            }
        }
        if (flag == 1) {
            sum = -sum;
        }
        return (int)sum;
    }

/*
改动之后的逻辑：
1. 去空格
2.  == char？
            首位？
                是： 
                    符号？ 是：ok
                           不是：return 0；
                不是：break

改动之后的code，逻辑简化了很多，然而不知道为什么速度还不如原code，原code竟然速度>99%
比较了一下，感觉可能是因为改动后的逻辑判断总次数更多了？
*/

public static int atoi(String s) {
        String s = str;
       int i = 0;
        int flag = 1;
        while(i < s.length()) {
            if (s.charAt(i) == ' ') i++;
            else break;
        }
        String v = s.substring(i);
        long sum = 0;
        for (int j = 0; j < v.length(); j++) {
            char c = v.charAt(j);
            boolean range = (c >= 48) && (c <= 57);
            if (!range) {
                if (j == 0) {
                    if (c == 45 || c == 43) {
                        if (c == 45) {
                            flag = -1;
                        }
                    } else {
                        return 0;
                    }
                } else {
                    break;
                }
            } else {
                sum *= 10;
                sum += flag * (c - 48);
                if (sum > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (sum < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }
        }
        return (int)sum;
    }
