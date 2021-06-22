import java.util.*;
class PowerofTwo
{
    public static void main(String args[])
    {
	Scanner sc=new Scanner(System.in);
	double n=549755813888;
	boolean a= (int)(Math.ceil((Math.log(n) / Math.log(2)))) == (int)(Math.floor(((Math.log(n) / Math.log(2)))));
	//boolean a=(int)(Math.ceil((Math.log(n)/Math.log(2)))
	System.out.println(a);
    }
}
        
