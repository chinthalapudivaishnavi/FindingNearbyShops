import java.util.*;
class Factors{
    static int GCD(int a,int b)
    {
        while(a!=b)
        {
            if(a>b){
                a=a-b;
            }else{
                b=b-a;
            }
        }
        return a;
    }
    public static void main(String args[])
    {
        int count=0;
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int gcd=GCD(a,b);
        for(int i=1;i<=Math.sqrt(gcd);i++)
        {
            if(gcd%i==0)
            {
               if(gcd/i==i){
                 count+=1;
             }else{
                count+=2;
             }
               
            }
        }
        System.out.println(count);
       
    }
}