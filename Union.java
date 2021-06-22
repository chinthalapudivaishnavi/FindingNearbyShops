import java.util.*;
class Solution{
    public static void main(String args[])
    {
       HashMap<Integer,Integer> hashmap=new HashMap<Integer,Integer>();
       int[] a=new int[]{1,2,3,1,4,5,4};
       int[] b=new int[]{6,7,8,9,10};
       int len1=a.length;
       int len2=b.length;
       for(int i=0;i<len1;i++)
       {
            hashmap.put(a[i],i); 
       }
       for(int i=0;i<len2;i++)
       {
       		hashmap.put(b[i],i);
       }
       System.out.println(hashmap.keySet());
        System.out.println(hashmap.size());
    }
    
}