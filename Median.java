import java.util.*;
class Median
{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int[] arr1=new int[]{1,2,3,4,5};
		int[] arr2=new int[]{};
		int len1=arr1.length;
		int len2=arr2.length;
		int[] result=new int[len1+len2];
		System.arraycopy(arr1,0,result,0,len1);
		System.arraycopy(arr2,0,result,0,len2);
		System.out.println(Arrays.toString(result));

	}
}