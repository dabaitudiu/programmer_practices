#include<stdio.h> 

/*
����ע�����㣺
1. 쳲����������õݹ�ᳬʱ��������O(N)��
2. ����test case�� ע�������long long, ���Ҳûʲô�� 
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
