import java.util.*;
class npr{
	static int fact(int a){
		int product=1;
		for(int i=a;i>=1;i--){
            product*=i;
           
        }
        
       	return product;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=10,r=2;
		int result=fact(n)/fact(n-r);
		System.out.println(result);
	}
}