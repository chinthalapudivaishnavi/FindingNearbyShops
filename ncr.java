import java.util.*;
class ncr{
	static int fact(int a){
		int product=1;
        for(int i=a;i>=1;i--){
            product*=i;
           
        }
         System.out.println(product);
       	return product;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=15,r=3;
		int result=fact(n)/(fact(n-r)*fact(r));
		System.out.println(result);
		result=(int)(result%((Math.pow(10,9))+7));
		System.out.println(result);
		
	}
}