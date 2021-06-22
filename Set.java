import java.util.*;
class Try
{
	static void generate(Set<String> ts1,String s)
	{
		if(s.length()==0)
		{
			return;
		}
		if(!ts1.contains(s))
		{
			ts1.add(s);
			for(int i=0;i<s.length();i++)
			{
				String t=s;
				t=t.substring(0,i)+t.substring(i+1);
				generate(ts1,t);
			}
		}
		return;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s="xyz";
		TreeSet<String> ts1=new TreeSet<>();
		generate(ts1,s);
		for(String str: ts1)
		{
			System.out.println(str);
		}
		
	}
}
