import java.util.*;
class Demo 
{
  	public static void main(String args[])
  	{
  		Scanner sc=new Scanner(System.in);
  		List<Integer> prices = new ArrayList<>();
  		prices.add(1);
  		prices.add(12);
  		prices.add(5);
  		prices.add(111);
  		prices.add(200);
  		prices.add(1000);
  		prices.add(10);
  		int length=prices.size();
  		
  		for(int i=0;i<length;i++)
  		{
  			for(int j=i+1;j<length-i-1;j++)
  			{
  				if(prices.get(i)>prices.get(j)){
  					int temp=prices.get(i);
  					prices.set(i,j);
  					prices.set(j,temp);
  				}
  			}
  		}
  		for(int i=0;i<length;i++)
  		{
  			System.out.println(prices.get(i));
  		}
  		/*int sum=0,k=50,count=0;
  		for(int i=0;i<length;i++)
  		{
  			if(sum+prices.get(i)>k){
  				break;
  			}
  			sum+=prices.get(i);

  			count++;
  			
  		}
  		System.out.println(count);*/
  	}
}
  