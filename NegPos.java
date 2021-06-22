import java.util.*;
class Solution
{
    public static void main(String args[])
    {
    	int[] arr=new int[]{-1,-2,3,4,-5};
    	int length=arr.length;
    	int index=0;
    	for(int i=0;i<length;i++)
    	{
    		if(arr[i]<0){
    			index=i;
    			if(index+1!=i){
    				arr[index+1]=arr[i];
    			}

    		}
    	}

    }
}