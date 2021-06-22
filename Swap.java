import java.util.*;
import java.io.*;
class Swap
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int d=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		int temp=arr[0];
		for(int i=0;i<d;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(j+1<n)
				{
					arr[j]=arr[j+1];					
				}
				else{
					arr[j]=temp;
				}
			}
			temp=arr[0];
		}
		for(int i=0;i<n;i++)
		{
			System.out.println(arr[i]);
		}
	}
}		
