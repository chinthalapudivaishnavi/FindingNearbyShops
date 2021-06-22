import java.util.*;
import java.util.Arrays;
class KSmall
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int[] arr=new int[]{7,10,4,20,15};
		int k=5;
		int length=arr.length;
        if(k<=length)
        {
        	Arrays.sort(arr);
        }
        for(int i=0;i<length;i++){
        	System.out.println(arr[i]);
        }
       /* int result=arr[k-1];
        System.out.println(result);*/
	}
}
