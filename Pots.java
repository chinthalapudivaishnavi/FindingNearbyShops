import java.util.*;
import java.lang.Math;
class Pots
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=0;i<T;i++)
        {
            int N=sc.nextInt();
            int A=sc.nextInt();
            int B=sc.nextInt();
            int min=999;
            for(int x=0;x<=N;x++)
            {
		int y=N-x;
		int result=x*x*A+y*y*B;
		if(result<min)
		{
			min=result;
		}
		
            }
	    System.out.println(min);
        }
    }
}
