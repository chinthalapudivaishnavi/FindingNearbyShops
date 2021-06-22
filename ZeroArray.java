import java.util.*;
class ZeroArray
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++)
        {
            arr[i]=sc.nextInt();
        }
        while(true)
        {
            for(int i=0;i<N;i+=2)
            {
                arr[i]-=1;
		if(i+1<N){
               	   arr[i+1]-=1;
		}
            }
            for(int j=0;j<N;j++)
            {
                if(arr[j]<0)
		{
                    System.out.println("NO");
                    break;
                }
		else if(arr[j]==0)
		{
                    flag++;
                }
            }
	    if(flag==N){
		System.out.println("NO");
                break;
	    }
        }
    }
}
