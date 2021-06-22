import java.util.*;
class LeastPossibleNumber
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		int length=str.length();
		int min=999,index=0;
		for(int i=0;i<length;i++)
		{
			for(int j=i+1;j<length;j++)
			{
				if(min<=str.charAt(j))
				{
					min=str.charAt(i);
					index=i;
				}else{
					min=str.charAt(j);
					index=j;
				}
			}
			System.out.print(min);
		}
	}
}
