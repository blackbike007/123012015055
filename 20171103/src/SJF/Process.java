package SJF;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Created by 32706 on 2016/12/8.
 * ������������Ľ����б����������ֲ�ͬ�ĵ����㷨
 */
public class Process {

    public static List<double []> task_info=new ArrayList<>();//�����б�
    public static  int task_num=10;//������

   
    public static  void init_task()//��ʼ�������б�
    {
        for(int i=0;i<task_num;i++)
        {
            int arr[]={6,2,1,3,9};
            int len = arr.length;
        	 Random random = new Random();
        	    int arrIdx = random.nextInt(len-1);
        	    int num = arr[arrIdx];
            double[] t=new double[4];
            t[0]=i;//���̺�
            t[1]=0;//����ʱ��
            t[2]=0;//��Ӧ��
            t[3]=num;//��Ҫ����ʱ��
            task_info.add(t);
        }
    }

    public static void main(String arg[])
    {
        Process.init_task();//��ʼ�������б�


        System.out.println("�����ҵ����================================================");
        SJF.init_task(task_info,task_num);
        SJF.SJF();//�����ҵ����









    }
}

