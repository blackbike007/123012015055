package One_hundred_grades_are_translated_into_grades;
import java.util.Scanner; 
public class One_hundred_grades_are_translated_into_grades {

	public static String change(int t) {
        if (t >= 0 && t < 60) {
            return "不及格";
        } else if (t >= 60 && t < 70) {
            return "及格";
        } else if (t >= 70 && t < 80) {
            return "中";
        } else if (t >= 80 && t < 90) {
            return "良";
        } else if (t >= 90 && t <= 100) {
            return "优";
        } else {
            return "Score is error!";
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Input a Score:");
        int t = 0;
        try {
            t = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Score is error!");
            return;
        }
        System.out.println(change(t));
    }

}