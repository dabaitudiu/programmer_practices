## 12. Integer to Roman
### 题目：
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
```
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
```
I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
```

### 思路：
这题有个trick，把所有digit的可能的结果建个dict，然后直接拼。但是感觉终究是trick，还是按照传统大神的解法稳妥一点。
- base从1000开始，每次除以10,开始循环:
- digit == 4, str + (base) + (base*50)
- digit == 9, str + (base) + (base*100)
- digit >=5, str + (base*50), num = digit - 5
- else, num = digit
- str.append(base) for num times

### 解答：
```java
class Solution {
    public static String intToRoman(int num) {
        HashMap<Integer,String> hmp = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        hmp.put(1,"I");
        hmp.put(5,"V");
        hmp.put(10,"X");
        hmp.put(50,"L");
        hmp.put(100,"C");
        hmp.put(500,"D");
        hmp.put(1000,"M");

        int base = 1000;
        int now = 0;
        int left = 0;
        while(base > 0) {
            now = num / base;
            if (now == 4) {
                sb.append(hmp.get(base)).append(hmp.get(base * 5));
            } else if (now == 9) {
                sb.append(hmp.get(base)).append(hmp.get(base * 10));
            } else if (now >= 5) {
                sb.append(hmp.get(base * 5));
                left = now - 5;
            } else {
                left = now;
            }
            for (int i = 0; i < left; i++) {
                sb.append(hmp.get(base));
            }
            num %= base;
            base /= 10;
            left = 0;
        }
        return sb.toString();
    }
}
```

### trick:
```java
class Solution {
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }
}
```