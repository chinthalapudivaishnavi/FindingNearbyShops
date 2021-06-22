import java.util.*;
class RemoveWord
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		String word=sc.next();
		//str=str.replaceAll(word,"");
		//System.out.println(str);
		for(int i=0;str.charAt(i)!='\0';i++)
		{
			char a=word.charAt(i);
			if(str.charAt(i)==a)
			{
				for(int j=i+1;str.charAt(j)!='\0';j++)
				{
					if(str.charAt(j))
				}
			}	
		}
	}
}
