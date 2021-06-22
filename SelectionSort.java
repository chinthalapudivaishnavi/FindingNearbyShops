import java.util.*;
class SelectionSort
{
	static int index;
	static int min(int arr[],int length,int lb)
	{
		int  min=999;
		while(lb<length)
			if(arr[lb]<min)
			{
				int small=arr[lb];
				index=lb;			
			}
			lb++;
		}
		
		return index;			
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int arr[]=new int[]{5,4,3,2,1};
		int length=arr.length;
		for(int i=0;i<length;i++)
		{
			int a=min(arr,length,i);
			int temp=arr[i];
			arr[i]=arr[a];
			arr[a]=temp;	
		}
		for(int i=0;i<length;i++)
		{
			System.out.println(arr[i]);
		}
	}
}








