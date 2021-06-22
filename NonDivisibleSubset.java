import java.util.*;
class NonDivisibleSubset
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] arr=new int[N];
		int K=sc.nextInt();
		for(int i=0;i<N;i++)
		{
			arr[i]=sc.nextInt();
		}
		String result="";
		for(int i=0;i<N;i++)
		{
			for(int j=i+1;j<N;j++)
			{
				int sum=arr[i]+arr[j];
				if(sum%K!=0)
				{
					result+=arr[i];
					result+=arr[j];
				}
			}
		}
		System.out.println(result);
	}
}
