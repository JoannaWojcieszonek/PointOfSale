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
		try {
			queue.put(event);
		} catch (InterruptedException e) {
			System.out.println("Sending event failed");
		}
	}

	@Override
	public void run() {
		while(true)
		{
			Object[] options = { "EXIT" };
			Object option = JOptionPane.showOptionDialog(null, "Click exit to continue", "",
			JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
			null, options, options[0]);
			//String inputValue = JOptionPane.showInputDialog("Please input a value");
			if(((Integer)option)==0) {
				Event event = new Event("exit", EventType.ExitButtonClickedEvent);
				sendEvent(event);
			}
		}
	}

}
