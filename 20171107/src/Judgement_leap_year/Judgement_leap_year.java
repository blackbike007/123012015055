//��дJava��������ӹ�Ԫ1990�굽2007������
//�������ţ�ÿ���������Ż�һ�С��ж������
//��Ϊ����������ǣ�
//��1��������ܱ�4�����������ܱ�100�������������ꣻ
//��2��������ܱ�400����Ҳ�����ꡣ
package Judgement_leap_year;

public class Judgement_leap_year {

	  public static void main(String[] args) {  
		  int year,j=0;
		  for(year=1990;year<2007;year++)
	        {
			
			  if((year%4==0&&year%100!=0)||year%400==0){
	                j++;
	                if(j%2==0)
	                {
	                    System.out.println(year);
	                }
	                else{
	                    System.out.print(year+" ");
	                }
	            }
			       
			    


	        
	        }
	    }  


}