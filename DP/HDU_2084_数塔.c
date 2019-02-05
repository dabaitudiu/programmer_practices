#include<stdio.h>

int main() {
	int c = 0;
	int n, tree[105][105];
	int i = 0, j = 0;
	
	scanf("%d", &c);
	while(c--) {
		scanf("%d", &n);
		for (i = 0; i < n; i++) {
			for (j = 0; j <= i; j++) {
				scanf("%d", &tree[i][j]);
			}
		}
		for (i = n - 2; i >= 0; i--) {
			for (j = 0; j <= i; j++) {
				if (tree[i+1][j] > tree[i+1][j+1]) {
					tree[i][j] += tree[i+1][j];
				} else {
					tree[i][j] += tree[i+1][j+1];
				}
//				printf("tree[%d][%d] becomes %d\n", i,j,tree[i][j]);
			}
		}
		printf("%d\n", tree[0][0]);
	}
	
	return 0;
} 
