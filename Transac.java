import java.util.*;
class Transac
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int arr[]=new int[T];
        for(int i=0;i<T;i++)
        {
            arr[i]=sc.nextInt();
        }
        int Q=sc.nextInt();
        for(int i=0;i<Q;i++)
        {
            int target=sc.nextInt();
            int sum=0;
            for(int j=0;j<T;j++)
            {
                sum+=arr[j];
                if(sum>=target)
                {
                    System.out.println(j+1);
                    break;
                }
            }
        }
    }
}
