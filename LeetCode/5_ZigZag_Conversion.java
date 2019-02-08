class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        int k = numRows;
        int times = (k >1) ? ((n + 2 * k - 3) / (2 * k - 2)):n;
        int col = times;
        int g_i = 0;
        int total = n;
        int list_index = 0;
        char[][] M = new char[k][col * k];




        while(times != 0 && list_index != n) {
            int i = 0;
            for(int v = 0; v < k; v++) {
                M[i][g_i] = s.charAt(list_index++);
                if (list_index == n) {
                    break;
                }
                i++;
            }

            if (list_index == n) {
                break;
            }
            i = k - 2;
            for (int u = 0; u < k - 2; u++) {
                M[i--][g_i + 1] = s.charAt(list_index++);
                if (list_index == n) {
                    break;
                }
            }
            g_i += (k == 1) ? 1:(k - 1);
            times--;
        }

        StringBuilder result = new StringBuilder();

        for(int a = 0; a < k; a++) {
            for(int b = 0; b < col * k; b++) {
                if (M[a][b] <= 126 && M[a][b] >= 32)
                    result.append(M[a][b]);
            }
        }

        return String.valueOf(result);
    }
}
