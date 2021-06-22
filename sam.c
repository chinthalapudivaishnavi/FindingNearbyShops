#include<stdio.h>
#include<stdlib.h>
int display(int i)
{
	if(i==5)
	{
		printf("yes");
		return i;
	}
	else{
		return display(i+1);
	}
}
int main()
{
	int c=display(1);
	printf("%d",c);
}

