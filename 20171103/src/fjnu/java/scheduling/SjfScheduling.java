package fjnu.java.scheduling;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SjfScheduling {
	private List<Task> tasks = new ArrayList<Task>();
	private List<Task> inQueue = null;
	private List<Task> notInQueue = new ArrayList<Task>();
	
	//������еĸ�������ʵ���У�������1����2
	private int mQueues;
	
	public SjfScheduling(String filename) {
		this(filename, 1);
	}
	
	public SjfScheduling(String filename, int queues) {
		this.mQueues = queues;
		tasks = Util.readTasks(filename);
		inQueue = new ArrayList<Task>();
		//print();
	}
	
	public void print() {
		for(Task t : tasks) {
			System.out.print(t);
		}
	}
	

	
	public void execute() {
		int currentTime = 0;
		int taskIndex = 0;
		int inQueueIndex = 0;
		int taskSize = tasks.size();
		
		while(true) {
			Task task = null;
			
			do { //����ǰʱ���Ѿ������������õ�notInQueue������
				if(taskIndex >= taskSize)
					break;
				task = tasks.get(taskIndex);
				if(task.getArrivalTime() <= currentTime) {
					notInQueue.add(task);
					taskIndex++;
				} else {
					//taskIndex--;
					break;
				}
			} while (true);
			
			System.out.println("taskIndex: " + taskIndex);
			
			//�Է���ʱ�䳤�����򣬶���ҵ��ǰ
			Util.sortByServiceTime(notInQueue);
			
			Iterator<Task> iterator = notInQueue.iterator();
			
			//��notInQueue�����з������񵽴������inQueue��
			while(iterator.hasNext()) {
				//˵����ǰ���ж����ж�������
				if(inQueueIndex >= mQueues) 
					break;
				
				task = iterator.next();
				inQueue.add(task);
				//notInQueue.remove(task);
				iterator.remove();
				inQueueIndex++;
			}
			
			Iterator<Task> iterInQueue = inQueue.iterator();
			
			//�����ڴ�������е���������ʱ��
			while(iterInQueue.hasNext()) {
				task = iterInQueue.next();
				if(!task.isVisited()) {
					task.setStartingTime(currentTime);
					task.setFinishingTime(task.getStartingTime() + task.getServiceTime());
					task.setTurnAroundTime(task.getFinishingTime() - task.getArrivalTime());
					task.setWeightTurnAround((double)task.getTurnAroundTime() / task.getServiceTime());
					task.setVisited(true);
				}
				
				//������ɺ�Ӷ�����ɾ��
				if(task.getFinishingTime() == currentTime) {
					//inQueue.remove(task);
					iterInQueue.remove();
					inQueueIndex--;
				}
			}
					
			//����п��ж���,����������
			while(inQueueIndex < mQueues && notInQueue.size() != 0) {
				task = (Task) notInQueue.get(0); //���ǻ�ȡ���׵����񣬼���̷���ʱ�������
				task.setStartingTime(currentTime);
				task.setFinishingTime(task.getStartingTime() + task.getServiceTime());
				task.setTurnAroundTime(task.getFinishingTime() - task.getArrivalTime());
				task.setWeightTurnAround((double)task.getTurnAroundTime() / task.getServiceTime());
				task.setVisited(true);
				inQueue.add(task);
				notInQueue.remove(0);
				inQueueIndex++;
			} 
			
			if(inQueue.size() == 0 && notInQueue.size() == 0) break;
			
			currentTime++;
		}
		writeResult();
	}
	
	private void writeResult() {
		Util.sortByID(tasks);
		StringBuilder sb = new StringBuilder();
		//Data Title
		sb.append("TaskID" + " " + "ArrivalTime" + " "
				+ "ServiceTime" + " " + "StartingTime" + " "
				+ "FinishingTime" + " " + "TurnAroundTime" + " "
				+ "WeightTurnAround" + "\n");
		for(Task t : tasks) {
			sb.append(t.toString());
		}
		
		//Write results to the file
		try {
			FileWriter writer = new FileWriter("sjf.txt");
			writer.write(sb.toString());
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
}