import java.util.*;
class Bits
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        String binary=Integer.toBinaryString(N);
        int length=binary.length();
        int count=0;
        for(int i=0;i<length;i++)
        {
        	if(binary[i]==1)
        	{
        		count++;
        	}
        }
        System.out.println(count);
    }
}