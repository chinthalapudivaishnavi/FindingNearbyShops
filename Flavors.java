import java.util.*;
class CommonElements
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int choclate[]=new int[N]; 
		int strawberry[]=new int[M];
		for(int i=0;i<N;i++)
		{
			choclate[i]=sc.nextInt();
		}
		for(int i=0;i<M;i++)
		{
			strawberry[i]=sc.nextInt();
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(choclate[i]==strawberry[j])
				{
					System.out.print(choclate[i]+" ");
					break;
				}
			}
		}
	}
}
