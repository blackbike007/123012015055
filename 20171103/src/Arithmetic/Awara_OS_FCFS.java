package Arithmetic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Awara_OS_FCFS {

	public static int i;
	public double awara[];
	public double awara1[];
	public int process_number;
	public double taskid[];
	public double arrival_time[];
	public double services_time[];
	public double start_time[];
	public double wait_time[];
	public double completion_time[];
	public double turn_around_time[];
	public double turn_around_time_with_weight[];

	private void Set_process_number(int process_nuber) {
		this.process_number = process_nuber;

	}

	private double get_process_number() {
		return process_number;
	}

	private void Set_arrival_time(int arrival_time[]) {
		for (i = 0; i < process_number; i++) {
			this.arrival_time[i] = arrival_time[i];
		}
	}

	private double[] get__arrival_time() {

		for (i = 0; i < process_number; i++) {
			awara[i] = arrival_time[i];
		}
		return awara;
	}

	private void Set_services_time(int services_time[]) {
		for (i = 0; i < process_number; i++) {
			this.services_time[i] = services_time[i];
		}
	}

	private double[] get_services_time() {
		for (i = 0; i < process_number; i++) {
			awara1[i] = services_time[i];
		}
		return awara1;
	}

	private void FCFS() {

		start_time[0] = arrival_time[0];
		completion_time[0] = arrival_time[0] + services_time[0];
		start_time[0] = arrival_time[0];
		turn_around_time[0] = completion_time[0] - arrival_time[0];
		turn_around_time_with_weight[0] = turn_around_time[0]
				/ services_time[0];
		for (i = 1; i < process_number; i++) {
			start_time[i] = completion_time[i - 1];
			wait_time[i] = start_time[i] - arrival_time[i];
			completion_time[i] = arrival_time[i] + services_time[i]
					+ wait_time[i];
			turn_around_time[i] = completion_time[i] - arrival_time[i];
			turn_around_time_with_weight[i] = turn_around_time[i]
					/ services_time[i];

		}
		System.out.println("\n��ʼʱ���ǣ� ");
		for (i = 0; i < process_number; i++) {
			System.out.print(start_time[i] + "\t");

		}
		System.out.println("\n�ȴ�ʱ���ǣ�");
		for (i = 0; i < process_number; i++) {
			System.out.print(wait_time[i] + "\t");
		}
		System.out.println("\n���ʱ���ǣ�");

		for (i = 0; i < process_number; i++) {
			System.out.print(completion_time[i] + "\t");
		}
		System.out.println("\n��תʱ���ǣ�");

		for (i = 0; i < process_number; i++) {
			System.out.print(turn_around_time[i] + "\t");
		}
		System.out.println("\n��Ȩ��תʱ�䣺");
		for (i = 0; i < process_number; i++) {
			System.out.print(turn_around_time_with_weight[i] + "\t");
		}
	}

	public static void main(String[] args) throws Exception {
		
		Awara_OS_FCFS cok = new Awara_OS_FCFS();
		BufferedReader buf = null;
		buf =  new BufferedReader(new InputStreamReader(
				new FileInputStream("D://hjj/JAVA/input.txt")));
		String strbuff;
		int str1=100;
		cok.process_number = str1;
		cok.taskid=new double[cok.process_number];
		cok.arrival_time = new double[cok.process_number];
		cok.services_time = new double[cok.process_number];
		cok.completion_time = new double[cok.process_number + 1];
		cok.turn_around_time = new double[cok.process_number + 1];
		cok.start_time = new double[cok.process_number];
		cok.wait_time = new double[cok.process_number];
		cok.turn_around_time_with_weight = new double[cok.process_number];

		//String str = null;
		 
		for (int i = 0; i < cok.process_number; i++) {
			// ��ȡһ�����ݣ����ݸ�ʽ1 6734 1453
			strbuff = buf.readLine();
			// �ַ��ָ�
			String[] strcol = strbuff.split("\t");
			cok.taskid[i] = Integer.valueOf(strcol[0]);
			cok.arrival_time[i] = Integer.valueOf(strcol[1]);
			cok.services_time[i] = Integer.valueOf(strcol[2]);
		}
/*		System.out.println("\n����������̵���ʱ��");
		for (i = 0; i < cok.process_number; i++) {
			str = buf.readLine();
			cok.arrival_time[i] = Double.parseDouble(str);
		}

		System.out.println("\n������������̷���ʱ��");
		for (i = 0; i < cok.process_number; i++) {
			   int arr[]={6,2,1,3,9};
	            int len = arr.length;
	        	 Random random = new Random();
	        	    int arrIdx = random.nextInt(len-1);
	        	    int	 str2  = arr[arrIdx];
			 
			cok.services_time[i] = str2;

		}
		*/
		System.out.println("�ý�����Ϊ" + cok.process_number);
		System.out.println("\n�����Ϊ");
		for (i = 0; i < cok.process_number; i++) {
			System.out.print(cok.taskid[i] + "\t");
		}
		System.out.println("\n����ʱ��Ϊ");
		for (i = 0; i < cok.process_number; i++) {
			System.out.print(cok.arrival_time[i] + "\t");
		}
		System.out.println("\n����ʱ��Ϊ��");
		for (i = 0; i < cok.process_number; i++) {
			System.out.print(cok.services_time[i] + "\t");
		}
		cok.FCFS();
		buf.close();
	}

}