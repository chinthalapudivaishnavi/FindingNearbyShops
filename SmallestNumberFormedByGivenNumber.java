import java.util.*;
class Smallest
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int freq[]=new int[10];
		while(N>0)
		{
			int d=N%10;
			freq[d]++;
			N=N/10;
		}
		String result="";
		for(int i=1;i<=9;i++)
		{
			if(freq[i]!=0)
			{
				result+=i;
				freq[i]--;
				break;
			}
		}
		for(int i=0;i<=9;i++)
		{
			while(freq[i]!=0)
			{
				result+=i;
				freq[i]--;
			}
		}
		System.out.println(result);
	}
}

















