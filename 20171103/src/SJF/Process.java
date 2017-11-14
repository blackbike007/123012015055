package SJF;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Created by 32706 on 2016/12/8.
 * 用于生成随机的进程列表，并测试三种不同的调度算法
 */
public class Process {

    public static List<double []> task_info=new ArrayList<>();//进程列表
    public static  int task_num=10;//进程数

   
    public static  void init_task()//初始化进程列表
    {
        for(int i=0;i<task_num;i++)
        {
            int arr[]={6,2,1,3,9};
            int len = arr.length;
        	 Random random = new Random();
        	    int arrIdx = random.nextInt(len-1);
        	    int num = arr[arrIdx];
            double[] t=new double[4];
            t[0]=i;//进程号
            t[1]=0;//到达时间
            t[2]=0;//响应比
            t[3]=num;//需要运行时间
            task_info.add(t);
        }
    }

    public static void main(String arg[])
    {
        Process.init_task();//初始化进程列表


        System.out.println("最短作业优先================================================");
        SJF.init_task(task_info,task_num);
        SJF.SJF();//最短作业优先









    }
}

