import java.util.*;
class Cards
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] arr=new int[N-1];
	int sum=0;
        for(int i=0;i<N-1;i++)
        {
            arr[i]=sc.nextInt();
	    sum+=arr[i];
        }
	int sumodd=1,temp=1;
	int count=1;
	while(count<N)
	{
		 temp+=2;
		sumodd=sumodd+temp;
		count++;
	}
	int result=sumodd-sum;
	System.out.println(result);
       
    }
}
