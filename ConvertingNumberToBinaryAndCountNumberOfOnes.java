import java.util.*;
class Binary
{
    public static void main(String args[])
    {
        try{
              Scanner sc=new Scanner(System.in);
                int N=sc.nextInt();
                String binary=Integer.toBinaryString(N);
                int count=0;
                int length=binary.length();
                for(int i=0;i<length;i++)
                {
                    if(binary.charAt(i)=='1')
                    {
                        count++;
                    }
                }
                System.out.println(count);
         }catch(Exception e){
             
         }    
        
    }
}
