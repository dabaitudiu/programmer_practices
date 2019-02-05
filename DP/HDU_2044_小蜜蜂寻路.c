#include<stdio.h> 

/*
这题注意两点：
1. 斐波那契数列用递归会超时，至少用O(N)的
2. 垃圾test case， 注意变量用long long, 别的也没什么了 
*/ 

int main() {
	int n;
	long long tmp,cur,pre;
	int num;
	int start,end;
	scanf("%d", &n);
	while(n--) {
		scanf("%d", &start);
		scanf("%d", &end);
		num = 1 + (end - start);	
		
		pre = 1;
		cur = 1;
		while(num - 2 > 0) {
			tmp = pre + cur;
			pre = cur;
			cur = tmp;
			num--;
		}
		printf("%I64d\n", cur);
	}
}
