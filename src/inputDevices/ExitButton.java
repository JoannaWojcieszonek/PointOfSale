package inputDevices;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

import javax.swing.JOptionPane;

public class ExitButton implements InputDevice, Runnable {

	private BlockingQueue<Event> queue;
	
	public ExitButton(BlockingQueue<Event> queue) {
		this.queue = queue;
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void sendEvent(Event event) {
		// TODO Auto-generated method stub
		try {
			queue.put(event);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			/*Scanner in = new Scanner(System.in);
			if(in.hasNext("exit"))
			{
				Event event = new Event("exit", EventType.ExitButtonClickedEvent);
				sendEvent(event);
			}*/
			String inputValue = JOptionPane.showInputDialog("Please input a value");
			if(inputValue.equals("exit")) {
				Event event = new Event(inputValue, EventType.ExitButtonClickedEvent);
				sendEvent(event);
			}
		}
	}

}
