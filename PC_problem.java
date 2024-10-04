package Revanth;

class Queue{
	private int data;
	boolean isPresentData=false;
	
	public synchronized void setData(int data) {
		if(isPresentData==false) {
			this.data=data;
			System.out.println("Producer produce data "+data);
			isPresentData=true;
			notify();
		}
		else {
			try {
				wait();
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public synchronized void getData() {
		if(isPresentData==true) {
			System.out.println("Consumer consume data "+data);
			isPresentData=false;
			notify();
		}
		else {
			try {
				wait();
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Producer extends Thread{
	Queue q;
	Producer(Queue q){
		this.q=q;
	}
	@Override
	public void run() {
	 for(int i=1 ; ; ) {
		q.setData(i++);
	 }
	}
}

class Consumer extends Thread{
	Queue q;
	Consumer(Queue q){
		this.q=q;
	}
	
	@Override
	public void run() {
		for( ; ; ) {
	     q.getData();
		}
	}
}


public class PC_problem {
	public static void main(String[] args) {
		Queue q= new Queue();
		Producer p=new Producer(q);
		Consumer c=new Consumer(q);
		
		p.start();
		c.start();
		
	}
}
