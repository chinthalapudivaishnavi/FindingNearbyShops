import java.util.*;
class Hexa
{
	static int count=0;
   static void GCD(int j,int sum)
   {
	    if(j==sum && j>1)
	    {
		count++;
		//System.out.println(j);
	    }
	    else
	    {
		while(j!=sum)
		{
			if(j>sum)
			{
				j-=sum;
			}
			else{
				sum-=j;
			}
		}
		if(j>1)
		{
			count++;
			//System.out.println(j);
		}
		       	
	    }	
   }
   
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=0;i<T;i++)
        {
            int L=sc.nextInt();
            int R=sc.nextInt();
            char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	    
            for(int j=L;j<=R;j++)
            {
                int temp=j;
		String hex="";
		while(temp>0)
		{
			int rem=temp%16;
			hex=hexchars[rem]+hex;
			temp=temp/16;	
		}
		//System.out.println(hex);
		int sum=0,ind=0;
		int len=hex.length()-1;
		if(len==0)
		{
			String hexdigits="0123456789ABCDEF";
			char c=hex.charAt(0);
			int index=hexdigits.indexOf(c);
			while(index>0)
			{
				int a=index%10;
				sum+=a;
				index=index/10;
			}
		}
		else{
			for(int k=len;k>=0;k--)
			{
				String hexdigits="0123456789ABCDEF";
				char c=hex.charAt(k);
				int index=hexdigits.indexOf(c);
				
				sum+=16*ind+index;
				ind++;
			
			}
		}
		 GCD(j,sum);
		
		
		

            }
	   System.out.println(count);
        }                  
    }
    
}
