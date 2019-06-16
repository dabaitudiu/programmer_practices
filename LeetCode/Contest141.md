## Weekly Contest 141

#### 1. Duplicate Zeros
```java
我的code：
class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) sbf.append(String.valueOf(0));
            sbf.append(String.valueOf(arr[i]));
        }
        String s = sbf.toString();
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - '0';
        }
    }
}
```
```java
大佬的code：
class Solution {
	    public void duplicateZeros(int[] arr) {
	    	int n = arr.length;
	        int[] a = Arrays.copyOf(arr, n);
	        int p = 0;
	        for(int i = 0;i < n;i++){
	        	if(a[i] == 0){
	        		if(p < n)arr[p++] = 0;
	        		if(p < n)arr[p++] = 0;
	        	}else{
	        		if(p < n)arr[p++] = a[i];
	        	}
	        }
	    }
	}	
```

#### 2. Largest Values From Labels
```java
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int n = values.length;
        int end = n;
        int sum = 0;
        while(end > 0) {
            for (int i = 0; i < end - 1; i++) {
                if (values[i] < values[i+1]) {
                    int tmp = values[i];
                    values[i] = values[i+1];
                    values[i+1] = tmp;
                    
                    int jmp = labels[i];
                    labels[i] = labels[i+1];
                    labels[i+1] = jmp;
                }
            }
            end--;
        }
        
        HashMap<Integer,Integer> hmp = new HashMap<>();
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            int curr = values[i];
            if (hmp.get(labels[i]) == null) {
                hmp.put(labels[i],1);
            } else if (hmp.get(labels[i]) >= use_limit) continue;
            else {
                int k = hmp.get(labels[i]);
                hmp.put(labels[i], k+1);
            }
            sum += curr;
            count += 1;
            if (count == num_wanted) break;
        }
        
        return sum;
        
    }
}
```
```java
大佬的code:
class Solution {
	    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
	    	int n = values.length;
	        int[][] ai = new int[n][];
	        for(int i = 0;i < n;i++){
	        	ai[i] = new int[]{values[i], labels[i]};
	        }
	        Arrays.sort(ai, new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return a[0] - b[0];
				}
			});
	        int[] f = new int[50000];
	        int sum = 0;
	        int used = 0;
	        for(int i = n-1;i >= 0;i--){
	        	if(used < num_wanted && ++f[ai[i][1]] <= use_limit){
	        		sum += ai[i][0];
	        		used++;
	        	}
	        }
	        return sum;
	    }
	}	
```
#### 3.Shortest Path in Binary Matrix
```java
大佬的code：
private int dir[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};

    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0]==1 || grid[m-1][n-1]==1) {
            return -1;
        }

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        int ans=0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int[] pop = queue.remove();
                if(pop[0]==m-1 && pop[1]==n-1) {
                    return ans+1;
                }
                for (int k=0;k<8;k++) {
                    int nextX = dir[k][0]+pop[0];
                    int nextY = dir[k][1]+pop[1];

                    if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && !visited[nextX][nextY] && grid[nextX][nextY]==0) {
                        queue.add(new int[]{nextX,nextY});
                        visited[nextX][nextY]=true;
                    }

                }
            }
            ans++;
        }

        return -1;
    }
```