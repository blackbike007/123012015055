package One_hundred_grades_are_translated_into_grades;
import java.util.Scanner; 
public class One_hundred_grades_are_translated_into_grades {

	public static String change(int t) {
        if (t >= 0 && t < 60) {
            return "������";
        } else if (t >= 60 && t < 70) {
            return "����";
        } else if (t >= 70 && t < 80) {
            return "��";
        } else if (t >= 80 && t < 90) {
            return "��";
        } else if (t >= 90 && t <= 100) {
            return "��";
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