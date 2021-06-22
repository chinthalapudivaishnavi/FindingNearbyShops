import java.util.*;
class Try
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
	String s="75";
	for(int i=0;i<s.length();i++)
	{
		String a=s.substring(0,i)+s.substring(i+1);
		System.out.println(a);
	}
    }
}
