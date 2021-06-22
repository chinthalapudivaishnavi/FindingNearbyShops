//to get the exact result after division we need to type cast numerator 
//or denominator to double
import java.util.*;
class Ratio
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        long count=0;
        for(int i=0;i<N;i++)
        {
            long W=sc.nextLong();
            long H=sc.nextLong();
           double result=(double)W/H;
            if(result>=1.6 && result<=1.7)
            {
                count++;
            }
        }
        System.out.println(count);
    }
}
