package Print_pattern;

public class Print_pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int i,j,k,n;
		 n=15;
         //外层循环控制层数
       for(i=0;i<n;i=i+2)
       {
    	   if(i<n/2)
             //根据外层行号，输出星号左边空格
    	   { for(j=1;j<=n/2-i;j=j+2)
               System.out.print(" ");
             //根据外层行号，输出星号个数
           for(k=0;k<=i;k++)
               System.out.printf("*");
             //一行结束，换行
           
           System.out.printf("\n");
    	   }
    	   else
    	   {
    		    
    		   for(j=5;j>=3-i+(n/2+1);j=j-2)
                   System.out.print(" ");
                 //根据外层行号，输出星号个数
               for(k=5;k>i-(n/2+1);k--)
                   System.out.printf("*");
                 //一行结束，换行
               
               System.out.printf("\n");
    	   }
         
       }
	

}
}