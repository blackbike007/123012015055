package Print_pattern;

public class Print_pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int i,j,k,n;
		 n=15;
         //���ѭ�����Ʋ���
       for(i=0;i<n;i=i+2)
       {
    	   if(i<n/2)
             //��������кţ�����Ǻ���߿ո�
    	   { for(j=1;j<=n/2-i;j=j+2)
               System.out.print(" ");
             //��������кţ�����ǺŸ���
           for(k=0;k<=i;k++)
               System.out.printf("*");
             //һ�н���������
           
           System.out.printf("\n");
    	   }
    	   else
    	   {
    		    
    		   for(j=5;j>=3-i+(n/2+1);j=j-2)
                   System.out.print(" ");
                 //��������кţ�����ǺŸ���
               for(k=5;k>i-(n/2+1);k--)
                   System.out.printf("*");
                 //һ�н���������
               
               System.out.printf("\n");
    	   }
         
       }
	

}
}