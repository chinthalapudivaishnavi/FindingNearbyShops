import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        // code here 
      int[] a=new int[]{0,2,1,0,1};
        int countZero=0;
        int countOne=0;
        int countTwo=0;
        int[] result=new int[5];
       for(int i=0;i<5;i++)
       {
            if(a[i]==0){
                countZero+=1;
            }else if(a[i]==1){
                countOne+=1;
            }else{
                countTwo+=1;
            }
       }
       int index=0;
       while(countZero!=0){
           result[index]=0;
           countZero--;
           index++;
       }
        while(countOne!=0){
           result[index]=1;
           countOne--;
           index++;
       }
        while(countTwo!=0){
           result[index]=2;
           countTwo--;
           index++;
       }
       for(int i=0;i<index;i++){
           System.out.print(result[i]);
       }
    }
}