import java.util.*;
class StringOperations{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s="vaishu";
		String repl=s.replace(s.charAt(1),'x');
		String remove=s.substring(0,4)+s.substring(5);
		String add=s.substring(0,3)+'l'+s.substring(3);
		System.out.println(repl);
		System.out.println(remove);
		System.out.println(add);
	}
}