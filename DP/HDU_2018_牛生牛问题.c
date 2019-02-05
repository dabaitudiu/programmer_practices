#include<stdio.h>

int fib(int n) {
	if (n <= 4) {
		return n;
	} else {
		return fib(n-1) + fib(n-3);
	}
}

int main() {
	int c;
	
	while(scanf("%d", &c)) {
		if (c == 0) {
			break;
		} else {
			printf("%d\n",fib(c));
		}
	}
	return 0;
} 
