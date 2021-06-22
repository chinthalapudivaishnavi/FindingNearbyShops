import java.util.*;
class RemoveChars
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String str1=sc.next();
		String str2=sc.next();
		int len1=str1.length();
		int len2=str2.length();
		for(int i=0;i<len2;i++)
		{
			int flag=0;
			for(int j=0;j<len1;j++)
			{
				if(str2.charAt(i)==str1.charAt(j))
				{
					flag=1;
					break;
				}
			}
			if(flag!=1)
			{
				System.out.print(str2.charAt(i));
			}
		}
	}
}
