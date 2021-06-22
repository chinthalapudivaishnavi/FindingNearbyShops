import java.util.*;
class Subarray
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] arr=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=sc.nextInt();
		}
		int flag=0;
		for(int i=0;i<N;i++)
		{
			int leftsum=0;
			for(int k=0;k!=i&&k<N;k++)
			{
				leftsum+=arr[k];
				int rightsum=0;
				for(int j=k+1;j!=i&&j<N;j++)
				{
					rightsum+=arr[j];
				}
				if(leftsum==rightsum)
				{
					flag=1;
					
				}
			}
				
		}
		if(flag!=1)
		{
			System.out.println("NO");
		}else{
			System.out.println("YES");
		}
	}
}









