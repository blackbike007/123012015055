//编写Java程序，输出从公元1990年到2007年所有
//闰年的年号，每输出两个年号换一行。判断年号是
//否为闰年的条件是：
//（1）若年号能被4整除，而不能被100整除，则是闰年；
//（2）若年号能被400整除也是闰年。
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