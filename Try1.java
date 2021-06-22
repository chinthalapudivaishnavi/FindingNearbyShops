import java.util.*;
class Try
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
	String s="12345";
	//int a=Integer.parseInt(s);
	//System.out.println(s.getClass().getSimpleName());
	for(int i=0;i<s.length();i++)
	{
		String str=s.substring(0,i)+s.substring(i+1);
		System.out.println(str);
	}
     }
}
