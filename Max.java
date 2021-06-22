import java.util.*;
import java.io.*;
class Max
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int i=0;i<T;i++)
		{
			int N=sc.nextInt();
			int[] edge=new int[N];
			for(int j=0;j<N;j++)
			{
				edge[j]=sc.nextInt();
			}
			int max=0;
			int max_node=0;
			for(int k=0;k<N;k++)
			{
				
				int count=1;
				for(int l=k+1;l<N;l++)
				{
					if(edge[k]==edge[l])
					{
						count++;
					}
					
				}
				if(count>max)
				{
					max=count;
					max_node=edge[k];
				}
			}
			System.out.println(max_node);
		}
	}
}








