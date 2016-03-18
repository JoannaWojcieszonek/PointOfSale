package controller;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BarcodeScanner {
	
	private BlockingQueue<Object> queue;

	public BarcodeScanner()
	{
		this.queue = new ArrayBlockingQueue<Object>(1);
	}
	
	public BlockingQueue<Object> getQueue() {
		return queue;
	}

	public void scan() throws NullPointerException, InterruptedException {
		System.out.println("Wpisz kod kreskowy produktu:");
		Scanner in = new Scanner(System.in);
		Integer t = null;
		if(in.hasNext("exit"))
		{
			queue.put("exit");
		}
		else if(in.hasNextInt())
		{
			t = in.nextInt();
			queue.put(t);
		}
		else throw new NullPointerException();
	}
}
