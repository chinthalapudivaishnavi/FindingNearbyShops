import java.util.*;
class Interleaved
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int k=0;k<T;k++)
		{
			String s=sc.next();
			int len=s.length();
			int count=0;
			for(int i=0;i<len;i++)
			{
				if(s.charAt(i)=='I')
				{
					for(int j=i+1;j<len;j++)
					{
						if(s.charAt(j)=='O')
						{
							count++;
							break;
						}
					}
				}		
			}
			System.out.println(count);
		}
	}
}
