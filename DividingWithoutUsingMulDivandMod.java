import java.util.*;
class Division
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int dividend=30;
		int divisor=6;
		int quo=0;
		while(dividend>=divisor){
			dividend-=divisor;
			quo++;
			
		}
		System.out.println(quo);

	}
	

}
