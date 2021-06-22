class BitDiff
{
    
    // Function to find number of bits needed to be flipped to convert A to B
    public static void main(String args[])
    {
        
        String binary1=Integer.toBinaryString(57);
        String binary2=Integer.toBinaryString(46);
	int length1=binary1.length();
	int length2=binary2.length();
        int count=0;
        if(length1!=length2)
        {
       		if(length1<length2)
		{
			int diff=length2-length1;
			while(diff!=0)
			{
				binary1='0'+binary1;
				diff--;
			}
		} else{
			int diff=length1-length2;
			while(diff!=0)
			{
				binary2='0'+binary2;
				diff--;
			}
		}  
		 
        }
	int newlength=binary1.length();
	for(int i=0;i<newlength;i++)
        {
               if(binary1.charAt(i)!=binary2.charAt(i))
               {
                  count++;
               }
        }
	System.out.println(count);
          
        
    }
    
    
}
