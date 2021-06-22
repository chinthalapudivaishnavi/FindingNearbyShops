import java.util.*;
class Mountain
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] arr=new int[N];
        int[] highmount=new int[N];
        for(int i=0;i<N;i++)
        {
            arr[i]=sc.nextInt();
        }
        int index=0;
        highmount[index]=arr[N-1];
        for(int i=N-2;i>=0;i--)
        {
            if(arr[i]>=highmount[index])
	    {
                index++;
                highmount[index]=arr[i];
                
            }
        }
        int len=index+1;
	int middle=0;
        if(len%2==0)
        {
               middle=len/2;
		middle=middle-1;
        }else{
               middle=len/2;
        }
        for(int i=0;i<N;i++)
	{
		if(arr[i]==highmount[middle])
		{
			System.out.println(i);
		}
	}
    }
}










