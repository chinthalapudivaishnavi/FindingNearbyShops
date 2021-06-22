import java.util.*;
class Stones
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		 int T=sc.nextInt();
		
		for(int j=0;j<T;j++)
		{
		    int N=sc.nextInt();
		    int[] Rupam=new int[N];
		    int[] Ankit=new int[N];
		    for(int i=0;i<N;i++)
		    {
		        Rupam[i]=sc.nextInt();
		    }
		    for(int i=0;i<N;i++)
		    {
		        Ankit[i]=sc.nextInt();
		    }
			
			int[] freq1=new int[100];
			int[] freq2=new int[100];
			for(int i=0;i<N;i++)
			{
				int a=Rupam[i];
				freq1[a]++;
				int b=Ankit[i];
				freq2[b]++;
			}
			int max=-999,weight=0;
			for(int i=0;i<100;i++)
			{
				if(freq1[i]>max)
				{
					max=freq1[i];
					weight=i;
				}else if(freq1[i]==max)
				{
					if(i>weight)
					{
						max=freq1[i];
						weight=i;
					}
					else{
						weight=weight;
					}
				}
			}
			int max1=-999,weight1=0;
			for(int i=0;i<100;i++)
			{
				if(freq2[i]>max1)
				{
					max1=freq2[i];
					weight1=i;
				}else if(freq2[i]==max1)
				{
					if(i>weight1)
					{
					max1=freq2[i];
						weight1=i;
					}
					else{
						weight1=weight1;
					}
				}
			}
			if(weight>weight1)
				System.out.println("Rupam");
			else if(weight<weight1)
				System.out.println("Ankit");
			else
				System.out.println("Tie");
		}
		
	}
}









