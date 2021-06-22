import java.util.*;
class Time
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int l=0;l<T;l++)
        {
            int N=sc.nextInt();
            int K=sc.nextInt();
            int[] arr=new int[N];
	    for(int k=0;k<N;k++)
		{
			arr[k]=sc.nextInt();
		}
            int time=0,flag=0;
            while(true)
            {
                for(int i=0;i<N;i++)
                {
                    if(arr[i]<K)
                    {
			flag=1;
                        arr[i]++;
                    }
                }
		if(flag!=1){
			System.out.println(time);
			break;
		}
                time++;
                int count=0;
                for(int j=0;j<N;j++)
                {
                    if(arr[j]>=K)
                    {
                        count++;
                    }
                }
                if(count==N){
			 System.out.println(time);
                    break;
                }
            }
           
            
        }
    }
}
