import java.util.*;
class Matrix
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int rows=sc.nextInt();
		int matrix[][]=new int[rows][rows];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<rows;j++)
			{
				matrix[i][j]=sc.nextInt();
			}
		}
		int rowpos=sc.nextInt();
		int colpos=sc.nextInt();
		int sum=0,max=0;
		for(int i=rowpos-1;i<rows;i++)
		{
			for(int j=colpos-1;j<rows;j++)
			{
				sum=sum+matrix[i][j];
				
			}
		}
		sum-=matrix[rowpos][colpos];
		System.out.println(sum);

	}
}
