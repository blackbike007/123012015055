package Narcissistic_number;

public class Narcissistic_number{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		int i;
		for(i=100;i<=999;i++){
			a=i/100;
			b=(i/10) % 10;
			c=i %10;
			if (i==a*a*a+b*b*b+c*c*c) System.out.printf("%d\n",i);
		}
	}

}