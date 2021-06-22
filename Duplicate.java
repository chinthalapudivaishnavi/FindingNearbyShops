import java.util.*;
import java.io.*;
class Duplicates{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int len=sc.nextInt();
		int[] arr=new int[len];
		int[] temp=new int[len];
		int flag=0;
		for(int i=0;i<len;i++)
		{
			arr[i]=sc.nextInt();
		}
		int j=0;
		for(int i=0;i<len-1;i++)
		{
			if(arr[i+1]<len)
			{
				if(arr[i]!=arr[i+1])
				{
					temp[j++]=arr[i];
				}
			}else{
				if(arr[i-1]!=arr[i])
				{
					temp[j++]=arr[i];
				}else{
					for(int k=0;k<j;k++)
					{
						if(temp[k]==arr[i])
						{
							flag=1;
							break;
						}
					}
					if(flag!=1)
					{
						temp[j++]=arr[i];
					}
				}				
			}
		}
		//temp[j++]=arr[len-1];
		for(int i=0;i<j;i++)
		{
			System.out.println(temp[i]);
		}
		
	}
}









