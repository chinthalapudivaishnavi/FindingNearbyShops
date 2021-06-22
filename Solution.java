import java.util.*;
class Solution
{
    public static void main(String args[])
    {
       Scanner sc=new Scanner(System.in);
	int[] arr=new int[]{1,2,3,2,1};
	
	int length=arr.length;
	int[] copy=new int[length];
	int flag=0,index=0;
	for(int i=0;i<length;i++)
	{
		for(int element:copy)
		{
			System.out.println(element);
			if(element==copy[i]){
				flag=1;
				break;
			}
		}
		System.out.println(flag);
		int flag1=0;
		if(flag!=1)
		{
			
			for(int j=i+1;j<length;j++)
			{
				if(arr[i]==arr[j])
				{
					flag1=1;
					break;
				}
			}
			copy[index]=arr[i];
			index++;
			if(flag1!=1)
			{
				//System.out.print(arr[i]+" ");
			}
		}	
	}
       
    }
}
