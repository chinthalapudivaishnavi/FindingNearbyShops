import java.util.*;
class ModuloFunction
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int k=0;k<T;k++)
        {
            String s="";
            int M=sc.nextInt();
            int K=sc.nextInt();
            while(s==null || s.length()!=M)
	    {
				s=sc.next();
	    }
		
	   long a=Long.parseLong(s);
	   long max=a%K;
	    if(M==1 || K>a)
		{
			
			System.out.println(a%K);
		}
	    else{
		for(int i=0;i<M;i++)
	    	{
			String str=s.substring(0,i)+s.substring(i+1);
			a=Integer.parseInt(str);
			long modulo=a%K;
			if(modulo > max){
				max=modulo;
			}
			
	   	 }
	    	System.out.println(max);
	    }
	    
           
        }
    }
}
