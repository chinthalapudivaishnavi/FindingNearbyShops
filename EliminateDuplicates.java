import java.util.*;
class Duplicates
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] arr=new int[N];
		int[] newarr=null;
		int[] visited=new int[N];
		int index=0,flag=0,count=0;
		for(int i=0;i<N;i++)
		{
			arr[i]=sc.nextInt();
		}
		for(int i=0;i<N;i++)
		{
			
			for(int m=0;m<N;m++)
			{
				if(visited[m]==arr[i])
				{
					flag=1;
					break;
				}
			}
			if(flag!=1)
			{
				for(int j=i+1;j<N;j++)
				{
					if(arr[i]==arr[j])
					{
						count++;
						newarr=new int[arr.length-count];
						for(int k=0;k<j;k++)
						{
							newarr[k]=arr[k];
						}
						for(int l=j;l<newarr.length;l++)
						{
							newarr[l]=arr[l+1];
						}
					}
				}
				visited[index]=arr[i];
				index++;
			}
			
		}
		int newlen=newarr.length;
		for(int i=0;i<newlen;i++)
		{
			System.out.println(newarr[i]);
		}
	}
}







